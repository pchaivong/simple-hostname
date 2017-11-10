package com.oc.poc.simplehostname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SimpleHostnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleHostnameApplication.class, args);
	}

	@Bean
	public DelayedConfiguration delayedConfiguration(){
		return new DelayedConfiguration(0);
	}
}
