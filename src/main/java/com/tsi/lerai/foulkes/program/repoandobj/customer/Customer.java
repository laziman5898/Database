package com.tsi.lerai.foulkes.program.repoandobj.customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long customer_id  ;

    //Attributes
        private int  store_id ;
        private String first_name;
        private String last_name;
        private String email;
        private int address_id;
        private int active;
        private LocalDate create_date ;
        private LocalDate last_update;
        private String password ;
        private int actor_id ;

        public Customer(String first_name , String last_name , String email , String password , int store_id , int address_id , int actor_id  ){
            this.first_name=first_name;
            this.last_name=last_name;
            this.email = email;
            this.store_id=store_id;
            this.address_id = address_id ;
            this.actor_id = actor_id;
        }

        //Constructor
    public Customer() {}

    public Long getActor_id() {
        return customer_id;
    }

    public void setActor_id(Long actor_id) {
        this.customer_id = actor_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
