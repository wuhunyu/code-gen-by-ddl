package top.wuhunyu.codegenbyddl.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/19 21:35
 */

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 放行哪些原始域
        config.addAllowedOrigin("*");
        // 是否发送Cookie信息
        config.setAllowCredentials(false);

        // 放行哪些原始域(请求方式)
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);

        // 放行哪些原始域(头部信息)
        config.addAllowedHeader("*");
        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        config.addExposedHeader("*");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

}
