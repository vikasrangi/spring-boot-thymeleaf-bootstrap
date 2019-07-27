package com.itbility.springbootbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.itbility")
public class SpringBootBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBootstrapApplication.class, args);
	}

}
