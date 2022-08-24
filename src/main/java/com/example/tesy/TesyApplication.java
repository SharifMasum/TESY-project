package com.example.tesy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TesyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesyApplication.class, args);
	}

	//  Enable CRPS *******
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedMethods("*").allowedOrigins("*");
			}
		};
	}

	// End of CROS *********

}
