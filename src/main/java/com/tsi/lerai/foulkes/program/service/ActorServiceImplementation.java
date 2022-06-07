package com.tsi.lerai.foulkes.program.service;

import com.tsi.lerai.foulkes.program.Actor;
import com.tsi.lerai.foulkes.program.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ActorServiceImplementation implements ActorService {

    @Autowired
    private ActorRepo actorRepo;

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepo.save(actor);
    }

    @Override
    public List<Actor> fetchActor() {
        return (List<Actor>) actorRepo.findAll();
    }

    @Override
    public Actor updateActor(Actor actor, Long actorId) {
      Actor actorDB = actorRepo.findById(actorId).get() ;

      if (Objects.nonNull(actor.getFirst_name()) && !"".equalsIgnoreCase(actor.getFirst_name())){
          actorDB.setFirst_name(actor.getFirst_name());
      }
        if (Objects.nonNull(actor.getLast_name()) && !"".equalsIgnoreCase(actor.getLast_name())){
            actorDB.setLast_name(actor.getLast_name());
        }
return actorRepo.save(actorDB);
    }

    @Override
    public void deleteActorById(Long actorId) {
    actorRepo.deleteById(actorId);
    }
}
