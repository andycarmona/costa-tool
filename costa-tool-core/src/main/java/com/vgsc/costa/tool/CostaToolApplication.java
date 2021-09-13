package com.vgsc.costa.tool;

import com.vgsc.costa.tool.repository.VehicleRepository;
import com.vgsc.costa.tool.util.MockoonClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
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

	@Bean
	public CommandLineRunner demo(VehicleRepository vehicleRepository) {
		return (args) -> {
			MockoonClient client = new MockoonClient(  );
			client.saveVehicles(vehicleRepository);
		};
	}
}
