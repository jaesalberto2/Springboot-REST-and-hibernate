package com.alberto.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(
		scanBasePackages = {"com.alberto.springcoredemo",
		"com.alberto.util"})*/

public class SpringcoredemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}


}
