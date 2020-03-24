package com.example.gkudva.SpringBoot.dao;

import com.example.gkudva.SpringBoot.model.*;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

public interface DoctorDAO {

    int insertDoc(UUID id, Doctor doc);

    default int insertDoc(Doctor doc) {
        UUID docId = UUID.randomUUID();
        return insertDoc(docId, doc);
    }

    List<Doctor> getDocList();

    UUID getDoctorID(String firstName, String lastName);
}
