package top.wuhunyu.codegenbyddl.admin.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.wuhunyu.codegenbyddl.admin.dto.DDLSqlDto;
import top.wuhunyu.codegenbyddl.admin.dto.UserConfigurationDto;
import top.wuhunyu.codegenbyddl.admin.properties.ConfigurationProperty;
import top.wuhunyu.codegenbyddl.admin.properties.DataTypeMappingProperty;
import top.wuhunyu.codegenbyddl.admin.service.CodeGenService;
import top.wuhunyu.codegenbyddl.admin.utils.Assert;
import top.wuhunyu.codegenbyddl.admin.utils.DateUtil;
import top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlDataInfoDto;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlFiledInfoDto;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlTableInfoDto;
import top.wuhunyu.codegenbyddl.sqlparse.utils.MySqlParserUtil;
import top.wuhunyu.codegenbyddl.template.dto.EntityFiledTemplateDto;
import top.wuhunyu.codegenbyddl.template.dto.EntityTemplateDto;
import top.wuhunyu.codegenbyddl.template.dto.TemplateDto;
import top.wuhunyu.codegenbyddl.template.utils.StrUtil;
import top.wuhunyu.codegenbyddl.template.utils.TemplateParseUtil;
import top.wuhunyu.codegenbyddl.template.vo.TemplateVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 代码生成 service 实现
 *
 * @author wuhunyu
 * @date 2023/02/14 09:31
 **/

@Service("codeGenService")
@Slf4j
@RequiredArgsConstructor
public class CodeGenServiceImpl implements CodeGenService {

    private final DataTypeMappingProperty dataTypeMappingProperty;

    private final ConfigurationProperty configurationProperty;

    @Override
    public TemplateVo codeGen(UserConfigurationDto userConfigurationDto, Map<String, String> mapping, DDLSqlDto ddlSqlDto) {
        // 检查 模板名称 是否存在
        Assert.isTrue(configurationProperty.getAvailableTemplates().contains(ddlSqlDto.getTemplateName()),
                "请检查 模板名称 是否存在");

        // sql 解析
        SqlDataInfoDto sqlDataInfoDto = null;
        try {
            sqlDataInfoDto = MySqlParserUtil.parseDdlStr(ddlSqlDto.getDdlSql());
        } catch (Exception e) {
            log.info("sql 脚本: {}", ddlSqlDto.getDdlSql());
            log.info("sql 解析失败: {}", e.getLocalizedMessage(), e);
            Assert.isTrue("sql 脚本解析失败");
        }
        Assert.isTrue(sqlDataInfoDto != null, "sql 脚本解析失败");

        TemplateDto templateDto = this.collectParseData(userConfigurationDto, mapping, sqlDataInfoDto);
        Assert.isTrue(templateDto != null, "模板数据构造失败");

        try {
            return TemplateParseUtil.parseTemplate(templateDto, ddlSqlDto.getTemplateName());
        } catch (Exception e) {
            log.warn("模板生成失败: {}", e.getLocalizedMessage(), e);
            Assert.isTrue("模板生成失败，请稍后再试");
        }
        return null;
    }

    /**
     * 收集 sql 解析数据
     *
     * @param userConfigurationDto 用户自定义配置数据
     * @param mapping              用户自定义 数据类型映射关系
     * @param sqlDataInfoDto       sql 解析结果
     * @return 适配模板生成的解析数据
     */
    private TemplateDto collectParseData(UserConfigurationDto userConfigurationDto,
                                         Map<String, String> mapping,
                                         SqlDataInfoDto sqlDataInfoDto) {
        // 默认值
        Map<String, String> defaultMapping = dataTypeMappingProperty.getMapping();

        // 表信息
        SqlTableInfoDto sqlTableInfo = sqlDataInfoDto.getSqlTableInfo();
        String sourceTableName = sqlTableInfo.getTableName();
        // 表名称
        String tablePrefix = userConfigurationDto != null && StringUtils.isNoneBlank(userConfigurationDto.getTablePrefix()) ?
                userConfigurationDto.getTablePrefix() : configurationProperty.getTablePrefix();
        String tableName = sourceTableName;
        if (sourceTableName.startsWith(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        EntityTemplateDto entityTemplateDto = EntityTemplateDto.of(
                userConfigurationDto == null || StringUtils.isBlank(userConfigurationDto.getPackageName()) ?
                        configurationProperty.getPackageName() : userConfigurationDto.getPackageName(),
                userConfigurationDto == null || StringUtils.isBlank(userConfigurationDto.getModuleName()) ?
                        configurationProperty.getModuleName() : userConfigurationDto.getModuleName(),
                sourceTableName,
                tableName,
                userConfigurationDto == null || StringUtils.isBlank(userConfigurationDto.getAuthorName()) ?
                        configurationProperty.getAuthorName() : userConfigurationDto.getAuthorName(),
                sqlTableInfo.getPrimaryKeyCount() == 1,
                userConfigurationDto == null || StringUtils.isBlank(userConfigurationDto.getCreateDatetime()) ?
                        DateUtil.formatDatetime(configurationProperty.getCreateDateFormat()) :
                        userConfigurationDto.getCreateDatetime(),
                sqlTableInfo.getTableComment()
        );
        // 字段信息
        List<SqlFiledInfoDto> sqlFiledInfos = sqlDataInfoDto.getSqlFiledInfos();
        List<EntityFiledTemplateDto> entityFiledTemplates = new ArrayList<>(sqlFiledInfos.size());
        for (SqlFiledInfoDto sqlFiledInfo : sqlFiledInfos) {
            String filedType = sqlFiledInfo.getFiledType();
            String javaType = mapping != null ?
                    mapping.getOrDefault(filedType, defaultMapping.getOrDefault(filedType, "")) :
                    defaultMapping.getOrDefault(filedType, "");

            // 数据类型不能为空
            if (StringUtils.isBlank(javaType)) {
                Assert.isTrue(filedType + " 类型 无法找到对应的 Java 类型");
                return null;
            }
            entityFiledTemplates.add(new EntityFiledTemplateDto(
                    StrUtil.underlineCase2CamelCase(sqlFiledInfo.getFiledName()),
                    sqlFiledInfo.getFiledName(),
                    javaType,
                    sqlFiledInfo.getPrimaryKey() == YesOrNoEnum.YES.getStatus(),
                    false,
                    false,
                    configurationProperty.getDateTypes().contains(filedType) ?
                            configurationProperty.getDateFormat() : "",
                    sqlFiledInfo.getFiledComment()
            ));
        }

        // 组合
        return new TemplateDto(
                entityTemplateDto,
                entityFiledTemplates
        );
    }

}
