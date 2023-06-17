package com.example.rulebasedrouteoptimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
public class RuleBasedRouteOptimizationApplication {
	public static void main(String[] args) {
		SpringApplication.run(RuleBasedRouteOptimizationApplication.class, args);
	}

}
