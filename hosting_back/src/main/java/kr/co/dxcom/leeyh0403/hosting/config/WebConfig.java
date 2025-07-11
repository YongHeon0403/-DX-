package kr.co.dxcom.leeyh0403.hosting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:5173") // 프론트엔드 허용
                .allowCredentials(true)  // 쿠키 및 인증 정보 허용
                .maxAge(3600)            // preflight 요청 캐시 시간 (1시간)
                .allowedHeaders("*")     // 모든 헤더 허용
                .allowedMethods("*");    // 허용할 HTTP 메서드
    }
}
