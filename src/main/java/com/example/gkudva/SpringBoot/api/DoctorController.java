package com.example.gkudva.SpringBoot.api;

import com.example.gkudva.SpringBoot.model.Doctor;
import com.example.gkudva.SpringBoot.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/doctor")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public void insertDoctor(@Validated @NonNull @RequestBody Doctor doc) {
        this.doctorService.insertDoctor(doc);
    }

    @GetMapping
    public List<Doctor> getDoctorList() {
        return this.doctorService.getDoctorList();
    }
}
