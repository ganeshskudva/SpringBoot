package com.example.gkudva.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Doctor {
    UUID doctorID;
    @NotBlank @NonNull
    String firstName;
    @NotBlank @NonNull
    String lastName;

    public Doctor(@JsonProperty("id") UUID doctorID,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getDoctorID() {
        return doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDoctorID(UUID doctorID) {
        this.doctorID = doctorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
