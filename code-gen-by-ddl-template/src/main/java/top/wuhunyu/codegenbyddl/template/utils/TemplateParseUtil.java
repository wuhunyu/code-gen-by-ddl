package top.wuhunyu.codegenbyddl.template.utils;

import cn.hutool.extra.spring.SpringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.anna.Nullable;
import top.wuhunyu.codegenbyddl.template.dto.TemplateDto;
import top.wuhunyu.codegenbyddl.template.handler.JarFileTemplateLoader;
import top.wuhunyu.codegenbyddl.template.properties.SqlTemplateProperty;
import top.wuhunyu.codegenbyddl.template.vo.TemplateVo;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static top.wuhunyu.codegenbyddl.template.constants.TemplateConstant.*;

/**
 * 模板解析工具类
 *
 * @author wuhunyu
 * @date 2023/02/13 10:57
 **/

@Slf4j(topic = "模板解析工具类")
public final class TemplateParseUtil {

    /**
     * 模板属性配置
     */
    @Nullable
    private static SqlTemplateProperty sqlTemplateProperty;

    /**
     * freemarker 配置对象
     */
    @NotNull
    private static Configuration configuration;

    static {
        sqlTemplateProperty = SpringUtil.getBean(SqlTemplateProperty.class);
        if (sqlTemplateProperty == null || !sqlTemplateProperty.getEnabled()) {
            log.info("模板解析功能已关闭");
        }

        configuration = new Configuration(Configuration.VERSION_2_3_31);
        // 默认字符集
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        // 去除 国际化配置
        configuration.setLocalizedLookup(false);
    }

    private TemplateParseUtil() {
    }

    /**
     * 解析模板
     *
     * @param templateDto  模板信息
     * @param templateName 指定解析的模板名称
     * @return 解析之后的字符串
     */
    public static TemplateVo parseTemplate(@NotNull TemplateDto templateDto, @NotNull String templateName) {
        if (templateDto == null) {
            log.warn("模板信息为空");
            return null;
        }
        if (sqlTemplateProperty == null || !sqlTemplateProperty.getEnabled()) {
            log.info("模板解析功能已关闭");
            return null;
        }
        // 检查 指定的模板 是否存在
        if (StringUtils.isBlank(templateName)) {
            log.warn("模板 {} 为空", templateName);
            return null;
        }

        configuration.setTemplateLoader(new JarFileTemplateLoader(
                StrUtil.pathMerge(sqlTemplateProperty.getLocation(), templateName)
        ));
        // 开始解析
        TemplateVo templateVo = new TemplateVo();
        try {
            for (String name : TEMPLATE_NAMES) {
                Template template = configuration.getTemplate(name);
                StringWriter stringWriter = new StringWriter();
                template.process(templateDto, stringWriter);
                templateVo.setFiled(name, stringWriter.toString());
            }
        } catch (TemplateException e) {
            log.warn("模板解析失败，请检查模板配置: {}", e.getLocalizedMessage(), e);
            return null;
        } catch (IOException e) {
            log.warn("读取模板文件失败，请检查模板配置: {}", e.getLocalizedMessage(), e);
            return null;
        }
        return templateVo;
    }
}
