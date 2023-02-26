package top.wuhunyu.codegenbyddl.admin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.wuhunyu.codegenbyddl.admin.interceptor.RateLimitInterceptor;
import top.wuhunyu.codegenbyddl.admin.properties.SystemProperty;

/**
 * web 配置
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/14 21:10
 */

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SystemProperty systemProperty;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 流量限制
        registry.addInterceptor(new RateLimitInterceptor(systemProperty.getLimit()))
                .addPathPatterns("/**");
    }

}
