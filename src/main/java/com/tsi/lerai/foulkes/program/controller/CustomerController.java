package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.customer.Customer;
import com.tsi.lerai.foulkes.program.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired private CustomerRepo customerRepo;

    public CustomerController (CustomerRepo customerRepo) {this.customerRepo=customerRepo;}
}
