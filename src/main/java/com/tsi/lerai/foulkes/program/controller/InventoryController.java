package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.inventory.Inventory;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired private InventoryRepo inventoryRepo;

    public InventoryController(InventoryRepo inventoryRepo){this.inventoryRepo = inventoryRepo;}

    @GetMapping("/inventory")
    public List<Inventory> findAllInventory(){
        return (List<Inventory>) inventoryRepo.findAll();
    }
}
