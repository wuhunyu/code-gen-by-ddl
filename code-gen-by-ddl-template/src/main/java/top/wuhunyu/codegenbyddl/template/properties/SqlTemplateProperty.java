package top.wuhunyu.codegenbyddl.template.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * sql 代码生成模板
 *
 * @author wuhunyu
 * @date 2023/02/13 08:54
 **/

@Slf4j(topic = "sql 代码生成模板")
@Data
@ConditionalOnMissingBean(SqlTemplateProperty.class)
@ConfigurationProperties(prefix = "codegenbyddl.template")
public class SqlTemplateProperty {

    /**
     * 是否启用(true: 启用; false: 禁用)
     */
    private Boolean enabled = false;

    /**
     * 模板所在位置
     * 默认为 code-template
     */
    private String location = "code-template";

}