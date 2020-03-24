package com.example.gkudva.SpringBoot.dao;

import com.example.gkudva.SpringBoot.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("appointmentDAO")
public class AppointmentDataAccessService implements AppointmentDAO{
    List<Appointment> appointmentList = new ArrayList<>();
    Map<UUID, List<Appointment>> appointmentMap = new HashMap<>();
    @Override
    public int insertAppointment(UUID id,
                                 String patientFirstName,
                                 String patientLastName,
                                 String docFirstName,
                                 String docLastName,
                                 String date,
                                 String time,
                                 String kind) {
        Appointment ap = new Appointment(id, patientFirstName, patientLastName, docFirstName, docLastName, date, time, kind);
        DoctorDataAccessService doctorDataAccessService = new DoctorDataAccessService();
        ap.setDocID(doctorDataAccessService.getDoctorID(docFirstName, docLastName));
        appointmentList.add(ap);

        if (!appointmentMap.containsKey(doctorDataAccessService.getDoctorID(docFirstName, docLastName)))
            appointmentMap.put(doctorDataAccessService.getDoctorID(docFirstName, docLastName), new ArrayList<>());
        appointmentMap.get(doctorDataAccessService.getDoctorID(docFirstName, docLastName)).add(ap);
;       return 0;
    }

    @Override
    public int insertAppointment(String patientFirstName, String patientLastName, String docFirstName, String docLastName, String date, String time, String kind) {
        UUID id =  UUID.randomUUID();
        return insertAppointment(id, patientFirstName, patientLastName, docFirstName, docLastName, date, time, kind);
    }

    @Override
    public int insertAppointment(UUID id, Appointment appointment) {
        Appointment ap = new Appointment(id, appointment);
        DoctorDataAccessService doctorDataAccessService = new DoctorDataAccessService();
        ap.setDocID(doctorDataAccessService.getDoctorID(appointment.getDocFirstName(), appointment.getDocLastName()));
        appointmentList.add(ap);

        UUID docID = doctorDataAccessService.getDoctorID(appointment.getDocFirstName(), appointment.getDocLastName());
        if (!appointmentMap.containsKey(docID))
            appointmentMap.put(docID, new ArrayList<>());
        appointmentMap.get(docID).add(ap);
        return 0;
    }

    @Override
    public int insertAppointment(Appointment appointment) {
        UUID id = UUID.randomUUID();

        return insertAppointment(id, appointment);
    }

    @Override
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    @Override
    public List<Appointment> getAppointmentListByDoc(String docFirstName, String docLastName, String date) {
        if (docFirstName == null && docLastName == null && date == null)
            return appointmentList;
        List<Appointment> lst = new ArrayList<>();
        DoctorDataAccessService doctorDataAccessService = new DoctorDataAccessService();
        UUID id = doctorDataAccessService.getDoctorID(docFirstName, docLastName);

        if (!appointmentMap.containsKey(id))
            return lst;

        for (Appointment appointment: appointmentMap.get(id)) {
            if (appointment.getDate().equals(date))
                lst.add(appointment);
        }

        return lst;
    }

    @Override
    public int deleteAppointment(String docFirstName, String docLastName, String date) {
        DoctorDataAccessService doctorDataAccessService = new DoctorDataAccessService();
        UUID id = doctorDataAccessService.getDoctorID(docFirstName, docLastName);

        if (!appointmentMap.containsKey(id))
            return 1;
        List<Appointment> lst = appointmentMap.get(id);
        int i = 0;
        for ( i = 0; i < lst.size(); i++) {
            if (lst.get(i).getDate().equals(date)) {
                break;
            }

        }
        if (i <= lst.size()-1) {
            Appointment ap = lst.get(i);
            lst.remove(i);

            for (int j = 0; j < appointmentList.size(); j++) {
                if (appointmentList.get(j).getAppointmentID() == ap.getAppointmentID())
                    appointmentList.remove(j);
            }


        }



        return 0;
    }
}
