package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;


@RestController
public class ActorController {

   @Autowired private ActorRepo actorRepo ;
   public ActorController(ActorRepo actorRepo){this.actorRepo=actorRepo ;}

    //saveOperation
    @PostMapping("/addActor")
    public @ResponseBody String addActor(@RequestParam String first_name,String last_name){
        Actor addActor = new Actor(first_name,last_name);
        actorRepo.save(addActor);
        return "saved";}

    //Read operation
    @GetMapping("/actors")
    public List<Actor> fetchActor() {
        return (List<Actor>) actorRepo.findAll();
    }
    //Update Operation
    @PutMapping("/actors")
    public String updateActor(@RequestParam Long actorId ,String first_name,String last_name){
        Actor actorDB = actorRepo.findById(actorId).get() ;

        if (Objects.nonNull(actorDB.getFirst_name()) && !"".equalsIgnoreCase(actorDB.getFirst_name())){
            actorDB.setFirst_name(first_name);
        }
        if (Objects.nonNull(actorDB.getLast_name()) && !"".equalsIgnoreCase(actorDB.getLast_name())){
            actorDB.setLast_name(last_name);
        }
        actorRepo.save(actorDB);
        return "Updated Successfully" ;
    }
    //Delete Operation
    @DeleteMapping("/actors")
    public @ResponseBody String deleteActorById(@RequestParam Long actorId ){
        actorRepo.deleteById((actorId)) ;
        return "Deleted Successfully";
    }
    @GetMapping("/actors/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam Long actorId){
       if (actorRepo.existsById(actorId)){
           return true ;
       }else return false ;
    }

@GetMapping("/actors/FirstNameSearch")
    public @ResponseBody Actor getActorInfo(@RequestParam String first_name){
       List<Actor> actors = fetchActor();
       Actor foundActor = new Actor();
    for(int i =0 ; i <actors.size(); i++){
           Actor currentActor = actors.get(i);
           if(currentActor.getFirst_name().contains(first_name) ){
               foundActor = currentActor ;
           }
       }
     return foundActor ;
}

}
