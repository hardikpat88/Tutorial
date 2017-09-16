package com.blog.hardikpat.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * 
 */
@SpringBootApplication(scanBasePackages="com.blog.hardikpat")
@EntityScan(basePackages="com.blog.hardikpat")
@EnableJpaRepositories(basePackages="com.blog.hardikpat")
public class HardikPatApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		 SpringApplication.run(HardikPatApplication.class); 
	}

}
