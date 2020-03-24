package com.example.gkudva.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Appointment {
    UUID appointmentID;
    UUID docID;
    String patientFirstName;
    String patientLastName;
    String docFirstName;
    String docLastName;
    String date;
    String time; //24 hr format
    KIND kind;

    public enum KIND {
        FOLLOW_UP,
        NEW_PATIENT,
        NONE
    }

    public Appointment(String patientFirstName, String patientLastName, String docFirstName, String docLastName, String date, String time, KIND kind) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.docFirstName = docFirstName;
        this.docLastName = docLastName;
        this.date = date;
        this.time = time;
        this.kind = kind;
    }

    public void setDocID(UUID docID) {
        this.docID = docID;
    }

    public void setDocFirstName(String docFirstName) {
        this.docFirstName = docFirstName;
    }

    public void setDocLastName(String docLastName) {
        this.docLastName = docLastName;
    }

    public UUID getDocID() {
        return docID;
    }

    public Appointment(@JsonProperty("id") UUID appointmentID,
                       @JsonProperty("pFirstName") String patientFirstName,
                       @JsonProperty("pLastName") String patientLastName,
                       @JsonProperty("dFirstName") String docFirstName,
                       @JsonProperty("dLastName") String docLastName,
                       @JsonProperty("date") String date,
                       @JsonProperty("time") String time,
                       @JsonProperty("kind") String kind) {
        this.appointmentID = appointmentID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.docFirstName = docFirstName;
        this.docLastName = docLastName;
        this.date = date;
        this.time = time;
        this.kind = getKindEnum(kind);
    }

    private KIND getKindEnum(String kind) {
        if (kind.equals("FOLLOW_UP"))
            return KIND.FOLLOW_UP;
        else if (kind.equals("NEW_PATIENT"))
            return KIND.NEW_PATIENT;
        else
            return KIND.NONE;
    }

    public Appointment(UUID id, Appointment appointment) {
        this.appointmentID = id;
        this.patientFirstName = appointment.getPatientFirstName();
        this.patientLastName = appointment.getPatientLastName();
        this.docFirstName = appointment.getDocFirstName();
        this.docLastName = appointment.getDocLastName();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.kind = appointment.getKind();

    }

    public Appointment(UUID appointmentID, UUID docID, String patientFirstName, String patientLastName, String date, String time, KIND kind) {
        this.appointmentID = appointmentID;
        this.docID = docID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.date = date;
        this.time = time;
        this.kind = kind;
    }


    public String getDocFirstName() {
        return docFirstName;
    }

    public String getDocLastName() {
        return docLastName;
    }

    public UUID getAppointmentID() {
        return appointmentID;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getDate() {
        return date;
    }

    public KIND getKind() {
        return kind;
    }

    public void setAppointmentID(UUID appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setKind(KIND kind) {
        this.kind = kind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
