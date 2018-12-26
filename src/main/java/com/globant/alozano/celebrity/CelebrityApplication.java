package com.globant.alozano.celebrity;

import com.globant.alozano.celebrity.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CelebrityApplication implements CommandLineRunner {

	@Autowired
	IGroupService personService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CelebrityApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personService.findByGroupId(1));
		System.out.println(personService.findGroupRelationships(1));
	}
}

