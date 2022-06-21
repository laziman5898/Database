package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
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

    @PostMapping("/addCustomer")
    public @ResponseBody String addCustomer(@RequestParam String first_name,String last_name , String email,String password){
        String response = "Customer Added Successfully" ;
        Customer newCustomer = new Customer(first_name,last_name,email,password,1 ,1 ,1);
        customerRepo.save(newCustomer);

        return response ;
    }

    @GetMapping("/getEmailTest")
    public @ResponseBody String returnEmail (@RequestParam Long id){
        Customer customer= customerRepo.findById(id).get() ;
        return customer.getEmail() ;
    }
    @GetMapping("/Customers")
    public @ResponseBody Customer getCustomerByEmail(@RequestParam String email){
        List<Customer> customers = customerFetchAll();

        Customer foundCustomer = new Customer() ;
        Customer currentCustomer = new Customer() ;
        for (int i =0 ; i<customers.size() ; i++){
            currentCustomer= customers.get(i);
            if(currentCustomer.getEmail().equals(email)){
                foundCustomer=currentCustomer ;
            }
        }

    return foundCustomer ;
    }
}
