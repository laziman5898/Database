package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.category.Category;
import com.tsi.lerai.foulkes.program.repoandobj.category.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryController(CategoryRepo categoryRepo){this.categoryRepo=categoryRepo;}

    //Read operation
    @GetMapping("/category")
    public List<Category> customerFetchAll() {
        return (List<Category>) categoryRepo.findAll();
    }
}
