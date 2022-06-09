package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.store.Store;
import com.tsi.lerai.foulkes.program.repoandobj.store.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired private StoreRepo storeRepo ;

    public StoreController(StoreRepo storeRepo){this.storeRepo =  storeRepo;}


    @GetMapping("/store")
    public List<Store> getAllStores () {
        return (List<Store>) storeRepo.findAll() ;
    }
}
