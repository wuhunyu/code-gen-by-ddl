package top.wuhunyu.codegenbyddl.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 默认配置属性
 *
 * @author wuhunyu
 * @date 2023/02/14 09:33
 **/

@Data
@Component("configurationProperty")
@ConfigurationProperties(prefix = "codegenbyddl.configuration")
public class ConfigurationProperty {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 创建日期格式
     */
    private String createDateFormat;

    /**
     * 字段格式化日期格式
     */
    private String dateFormat;

    /**
     * 日期类型
     */
    private Set<String> dateTypes;

    /**
     * 默认生成的模板名称
     */
    private String defaultTemplate;

    /**
     * 可用的模板名称
     */
    private Set<String> availableTemplates;

}
