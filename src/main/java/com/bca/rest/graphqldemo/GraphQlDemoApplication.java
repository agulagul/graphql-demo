package com.bca.rest.graphqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GraphQlDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		try {
			SpringApplication.run(GraphQlDemoApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GraphQlDemoApplication.class);
	}

}
