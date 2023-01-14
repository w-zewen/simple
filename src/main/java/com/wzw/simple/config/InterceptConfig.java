package com.wzw.simple.config;

import com.wzw.simple.intercept.WebIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author zewen.wang
 * @date 2023/1/12
 */
@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebIntercept()).addPathPatterns("/**");
    }

}