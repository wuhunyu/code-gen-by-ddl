package top.wuhunyu.codegenbyddl.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/14 21:31
 */

@Data
@Component("systemProperty")
@ConfigurationProperties(prefix = "system-property")
public class SystemProperty {

    /**
     * 流量限制
     */
    private Integer limit = 50;

}
