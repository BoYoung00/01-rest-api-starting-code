package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration // 하나 이상의 빈 메서드를 포함하고 있을 때
public class BasicAuthenticationSecurityConfiguration {

    @Bean // 필터 체인, 요청이 들어오면 이 필터 체인 사용
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults()) // CORS 설정을 활성화
                .authorizeRequests(auth -> auth
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // 모든 사용자가 모든 엔드포인트에 대한 HTTP OPTIONS 요청 허용
                        .anyRequest().authenticated()) // 모든 HTTP 요청이 인증 되어야 한다
                .httpBasic(Customizer.withDefaults()) // 기본 인증 활성화 (팝업으로 로그인 창 뜨게 하는거)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf().disable() // 보호 비활성화
                .build();
    }
}
