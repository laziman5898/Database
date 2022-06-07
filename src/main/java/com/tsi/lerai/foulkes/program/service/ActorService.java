package com.tsi.lerai.foulkes.program.service;

import com.tsi.lerai.foulkes.program.Actor;

import java.util.List;

public interface ActorService {

//save operation
    Actor saveActor(Actor actor);

    //read operation
    List<Actor> fetchActor() ;
//update operation
    Actor updateActor(Actor actor , Long actorId) ;
//delete operation
    void deleteActorById(Long actorId);

}
