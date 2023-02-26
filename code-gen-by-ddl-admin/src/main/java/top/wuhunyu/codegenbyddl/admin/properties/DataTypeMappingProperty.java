package top.wuhunyu.codegenbyddl.admin.properties;

import cn.hutool.core.collection.CollUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 数据类型映射
 *
 * @author wuhunyu
 * @date 2023/02/14 08:11
 **/

@Slf4j(topic = "数据类型映射")
@Data
@ConfigurationProperties(prefix = "codegenbyddl")
@Component("dataTypeMappingProperty")
public class DataTypeMappingProperty implements InitializingBean {

    private Map<String, String> mapping;

    @Override
    public void afterPropertiesSet() {
        log.info("mapping: {}", mapping);
        // 避免非空
        if (CollUtil.isEmpty(mapping)) {
            mapping = Collections.emptyMap();
            return;
        }
        // 修改为 不可变map
        mapping = Collections.unmodifiableMap(mapping);
    }
}
