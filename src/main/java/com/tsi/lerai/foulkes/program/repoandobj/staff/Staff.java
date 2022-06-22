package com.tsi.lerai.foulkes.program.repoandobj.staff;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long staff_id  ;

    //Attributes

    private String first_name ;
    private String last_name ;
    private int address_id ;
   // private Byte picture ;
    private String email ;

    //Empty Constructor
    public Staff(){}

    public Staff(String first_name, String last_name, int address_id, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_id = address_id;
        this.email = email;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
