package com.example.gkudva.SpringBoot.dao;

import com.example.gkudva.SpringBoot.model.Appointment;

import java.util.*;

public interface AppointmentDAO {
    int insertAppointment(UUID id,
                                 String patientFirstName,
                                 String patientLastName,
                                 String docFirstName,
                                 String docLastName,
                                 String date,
                                 String time,
                                 String kind);

    int insertAppointment(String patientFirstName,
                          String patientLastName,
                          String docFirstName,
                          String docLastName,
                          String date,
                          String time,
                          String kind);

    int insertAppointment(UUID id, Appointment appointment);

    default int insertAppointment(Appointment appointment) {
        UUID id = UUID.randomUUID();
        return insertAppointment(id, appointment);
    }

    List<Appointment> getAppointmentList();

    List<Appointment> getAppointmentListByDoc(String docFirstName, String docLastName, String date);

    int deleteAppointment(String docFirstName, String docLastName, String date);
}
