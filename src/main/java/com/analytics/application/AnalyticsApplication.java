package com.analytics.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.analytics"})
@EntityScan(basePackages = {"com.analytics.entity"})
public class AnalyticsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnalyticsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsApplication.class, args);
	}
}
