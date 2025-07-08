package org.zerock.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer; // import 추가
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/favicon.ico", "/user/**", "/uploads/**", "/css/**", "/js/**", "/images/**", "/.well-known/**").permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(formLogin -> formLogin
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/")
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}