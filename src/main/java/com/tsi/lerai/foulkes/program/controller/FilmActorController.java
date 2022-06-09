package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.category.Category;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActor;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmActorController {

    @Autowired private FilmActorRepo filmActorRepo;

    public FilmActorController(FilmActorRepo filmActorRepo){this.filmActorRepo=filmActorRepo;}

    @GetMapping("/filmActors")
    public List<FilmActor> fetchFilmActorId(){
        return (List<FilmActor>) filmActorRepo.findAll();

    }

}
