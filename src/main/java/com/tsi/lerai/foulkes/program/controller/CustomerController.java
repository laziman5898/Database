package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.customer.Customer;
import com.tsi.lerai.foulkes.program.repoandobj.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired private CustomerRepo customerRepo;

    public CustomerController (CustomerRepo customerRepo) {this.customerRepo=customerRepo;}

    //Read operation
    @GetMapping("/customers")
    public List<Customer> customerFetchAll() {
        return (List<Customer>) customerRepo.findAll();
    }


}
