package top.wuhunyu.codegenbyddl.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.anna.Nullable;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ddl sql dto
 *
 * @author wuhunyu
 * @date 2023/02/14 09:19
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DDLSqlDto implements Serializable {

    /**
     * ddl sql 语句
     */
    @NotBlank(message = "ddl sql 语句不能为空")
    private String ddlSql;

    /**
     * 生成模板 名称
     */
    @Nullable
    private String templateName;

    /**
     * 包名
     */
    @Nullable
    private String packageName;

    /**
     * 模块名
     */
    @Nullable
    private String moduleName;

    /**
     * 作者
     */
    @Nullable
    private String author;

    /**
     * 表前缀
     */
    @Nullable
    private String tablePrefix;

    /**
     * 创建日期时间
     */
    @Nullable
    private String createDatetime;

    /**
     * 后缀
     */
    @Nullable
    private String suffix;

}
