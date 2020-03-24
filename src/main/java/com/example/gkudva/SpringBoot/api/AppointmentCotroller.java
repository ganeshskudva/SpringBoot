package com.example.gkudva.SpringBoot.api;

import com.example.gkudva.SpringBoot.model.Appointment;
import com.example.gkudva.SpringBoot.model.Doctor;
import com.example.gkudva.SpringBoot.service.AppointmentService;
import com.example.gkudva.SpringBoot.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.APOptions;

import java.util.List;

@RequestMapping("api/v1/appointment")
@RestController
public class AppointmentCotroller {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentCotroller(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public void insertAppointment(@Validated @NonNull @RequestBody Appointment appointment) {
        this.appointmentService.insertAppointment(appointment);
    }

    /*
    @GetMapping
    public List<Appointment> getAppointmentList() {
        return this.appointmentService.getAppointmentList();
    }

     */

    @GetMapping
    @ResponseBody
    public List<Appointment> getAppointmentByDoc(@RequestParam(value = "dFirst", required = false) String doctorFirstName,
                                                 @RequestParam(value = "dLast", required = false) String doctorLastName,
                                                 @RequestParam(value = "date", required = false) String date) {
        return this.appointmentService.getAppointmentByDoc(doctorFirstName, doctorLastName, date);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteAppointmentByDoc(@RequestParam(value = "dFirst", required = false) String doctorFirstName,
                                                 @RequestParam(value = "dLast", required = false) String doctorLastName,
                                                 @RequestParam(value = "date", required = false) String date) {
        int resp =  this.appointmentService.deleteAppointment(doctorFirstName, doctorLastName, date);

        if (resp != 0) {
            return new ResponseEntity<>(
                    "Appointment doesnt exist",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                "Appointment successfully added",
                HttpStatus.OK
        );
    }
}
