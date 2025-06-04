package kr.co.dxcom.leeyh0403.hosting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import lombok.RequiredArgsConstructor;
import java.util.List;

/**
 * Spring Security 설정 - JWT 인증 적용
 * SpringBoot 3.5와 Spring Security 6 호환
 */
@Configuration
// @EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    /**
     * BCrypt 비밀번호 인코더 Bean 등록
     * 비밀번호를 안전하게 암호화하기 위해 사용
     */
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    /**
     * CORS 설정
     * React 프론트엔드와의 통신을 위한 CORS 설정
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 허용할 도메인 설정
        configuration.setAllowedOriginPatterns(List.of(
                "http://localhost:5173",           // React 개발 서버
                "https://kaksi.dxcom.co.kr"      // 운영 도메인
        ));

        // 허용할 헤더 설정
        configuration.setAllowedHeaders(List.of("*"));

        // 허용할 HTTP 메서드 설정
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 쿠키 및 인증 정보 허용
        configuration.setAllowCredentials(true);

        // Authorization 헤더 노출 허용 (JWT 토큰)
        configuration.setExposedHeaders(List.of("Authorization"));

        // 모든 경로에 CORS 설정 적용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
