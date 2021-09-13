package com.vgsc.costa.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.vgsc.costa.tool.services"})
@EntityScan("com.vgsc.costa.tool.domain")
@EnableJpaRepositories("com.vgsc.costa.tool.repository")
public class CostaToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostaToolApplication.class, args);
	}

}
