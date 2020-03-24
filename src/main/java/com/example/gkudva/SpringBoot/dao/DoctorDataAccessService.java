package com.example.gkudva.SpringBoot.dao;

import com.example.gkudva.SpringBoot.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("doctorDAO")
public class DoctorDataAccessService implements DoctorDAO {
    private static List<Doctor> database = new ArrayList<>();
    private static Map<String, UUID> docMap = new HashMap<>();

    @Override
    public int insertDoc(UUID id, Doctor doc) {
        docMap.put(doc.getFirstName()+doc.getLastName(), id);
        database.add(new Doctor(id, doc.getFirstName(), doc.getLastName()));
        return 0;
    }

    @Override
    public List<Doctor> getDocList() {
        return database;
    }

    @Override
    public UUID getDoctorID(String firstName, String lastName) {
        return docMap.get(firstName+lastName);
    }

}
