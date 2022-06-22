package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.CustomerController;
import com.tsi.lerai.foulkes.program.controller.MovieController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.customer.Customer;
import com.tsi.lerai.foulkes.program.repoandobj.customer.CustomerRepo;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoCustomerTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @MockBean
    private CustomerRepo customerRepo;
    @InjectMocks
    CustomerController customerController;

    @BeforeEach
    void setup() {
        customerRepo = mock(CustomerRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        customerController = new CustomerController(customerRepo);
    }
    @Test
    public void customerFetchAllTest() {
        List<Customer> customers = new ArrayList<Customer>();
        Customer dummyCustomer = new Customer("first_name" , "last_name" , "email" ,"password" , 5 , 5 , 1 ) ;
        customers.add(dummyCustomer);
        when(customerRepo.findAll()).thenReturn(customers);
        List<Customer> expected = customers;
        List<Customer> actual = customerController.customerFetchAll();
        Assertions.assertEquals(expected,actual,"The lists do not match");
    }
    @Test
    public void addCustomerTest() {
    Customer dummyCustomer = new Customer("first_name" , "last_name" , "email" ,"password" , 5 , 5 , 1 );
    when(customerRepo.save(any(Customer.class))).thenReturn(dummyCustomer);
    String expected = "Customer Added Successfully" ;
    String actual = customerController.addCustomer(dummyCustomer.getFirst_name(), dummyCustomer.getLast_name(), dummyCustomer.getEmail(), dummyCustomer.getPassword());
    Assertions.assertEquals(expected,actual,"Function was not run successfully");
    }

    @Test
    public void returnEmailTest () {
    Customer dummyCustomer = new Customer("first_name" , "last_name" , "email" ,"password" , 5 , 5 , 1 );
    when(customerRepo.findById(dummyCustomer.getCustomer_id())).thenReturn(Optional.of(dummyCustomer));
    String expected = dummyCustomer.getEmail();
    String actual = customerController.returnEmail(dummyCustomer.getCustomer_id());
    Assertions.assertEquals(expected,actual,"The values did not match ");
    }

    @Test
    public void getCustomerByEmailTest(){
        List<Customer> customers = new ArrayList<Customer>();
        Customer dummyCustomer = new Customer("first_name" , "last_name" , "email" ,"password" , 5 , 5 , 1 ) ;
        Customer dummyCustomer2 = new Customer("James" , "Smith" , "James@outlook.com" ,"password" , 5 , 5 , 1 ) ;
        customers.add(dummyCustomer);
        when(customerRepo.findAll()).thenReturn(customers);

        Customer expected = dummyCustomer ;
        Customer actual = customerController.getCustomerByEmail(dummyCustomer.getEmail());
     Assertions.assertEquals(expected,actual,"Error has occured");

    }
}