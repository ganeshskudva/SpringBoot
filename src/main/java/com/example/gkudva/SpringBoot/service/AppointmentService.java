package com.example.gkudva.SpringBoot.service;

import com.example.gkudva.SpringBoot.dao.AppointmentDAO;
import com.example.gkudva.SpringBoot.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService {
    private final AppointmentDAO appointmentDAO;

    @Autowired
    public AppointmentService(@Qualifier("appointmentDAO") AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public int insertAppointment(Appointment appointment) {
        return this.appointmentDAO.insertAppointment(appointment);
    }

    public List<Appointment> getAppointmentList() {
        return this.appointmentDAO.getAppointmentList();
    }

    public List<Appointment> getAppointmentByDoc(String docFirstName, String docLastName, String date) {
        return this.appointmentDAO.getAppointmentListByDoc(docFirstName, docLastName, date);
    }

    public int deleteAppointment(String docFirstName, String docLastName, String date) {
        return this.appointmentDAO.deleteAppointment(docFirstName, docLastName, date);
    }
}
