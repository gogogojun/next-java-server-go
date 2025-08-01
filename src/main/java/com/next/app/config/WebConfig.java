package com.next.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 경로에 대해
                        .allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메소드
                        .allowedHeaders("*") // 모든 헤더 허용
                        .allowCredentials(true) // 인증 정보 포함 허용 (프론트에서 credentials: true 쓸 경우 필요)
                        .maxAge(3600); // Pre-flight 요청 캐시 시간 (초)
            }
        };
    }
}
