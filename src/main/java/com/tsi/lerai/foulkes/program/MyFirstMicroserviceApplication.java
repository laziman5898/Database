package com.tsi.lerai.foulkes.program;

import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/")
@CrossOrigin
public class MyFirstMicroserviceApplication {


	@Autowired
	private ActorRepo actorRepo;
	public MyFirstMicroserviceApplication(ActorRepo actorRepo) {
		this.actorRepo = actorRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}


}