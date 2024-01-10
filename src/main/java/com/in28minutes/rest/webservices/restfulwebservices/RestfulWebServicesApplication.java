package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean // 크로스 오리진 리퀘스트 권한 허용
	public WebMvcConfigurer configurer() {
		return  new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				// 특정한 패턴에 대해 크로스 오리진 리퀘스트 처리
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000") // 허용할 출처를 명시 (필요에 따라 수정)
						.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드를 명시
						.allowedHeaders("Origin", "Content-Type", "Accept"); // 허용할 헤더를 명시
			}
		};
	}
}
