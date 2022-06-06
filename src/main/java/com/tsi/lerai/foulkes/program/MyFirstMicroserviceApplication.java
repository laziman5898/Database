package com.tsi.lerai.foulkes.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@RequestMapping("/")

public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepo actorRepo;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}


	public MyFirstMicroserviceApplication(ActorRepo actorRepo) {
		this.actorRepo = actorRepo;
	}

	@GetMapping
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepo.findAll();
	}

}