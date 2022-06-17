package com.tsi.lerai.foulkes.program;

import com.tsi.lerai.foulkes.program.controller.CompleteController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ErFunctionality {


      CompleteController completeController = new CompleteController();


    @GetMapping("/test")
    private List<Actor> getAllActors() {

       return completeController.getActorController().fetchActor();
    }
}
