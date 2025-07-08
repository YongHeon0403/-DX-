package org.zerock.house.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /uploads/** URL로 요청이 오면 C:/uploads/ 경로에서 파일을 찾아 제공
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///C:/uploads/");
    }
}