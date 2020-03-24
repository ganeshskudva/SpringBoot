package com.example.gkudva.SpringBoot.service;

import com.example.gkudva.SpringBoot.dao.DoctorDAO;
import com.example.gkudva.SpringBoot.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorDAO doctorDAO;

    @Autowired
    public DoctorService(@Qualifier("doctorDAO") DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public int insertDoctor(Doctor doc) {
        this.doctorDAO.insertDoc(doc);
        return 0;
    }

    public List<Doctor> getDoctorList() {
        return this.doctorDAO.getDocList();
    }
}
