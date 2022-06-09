package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.staff.Staff;
import com.tsi.lerai.foulkes.program.repoandobj.staff.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired private StaffRepo staffRepo ;

            public StaffController(StaffRepo staffRepo){this.staffRepo=staffRepo;}

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return (List<Staff>) staffRepo.findAll();
    }
}
