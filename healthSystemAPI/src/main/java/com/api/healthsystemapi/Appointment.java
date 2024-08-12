/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Appointment class represents a scheduled appointment between a doctor and a patient.
 */
public class Appointment {
    private String appointmentID;  // Unique ID for each appointment
    private Doctor doctor;  // Doctor object representing the doctor for this appointment
    private Patient patient;  // Patient object representing the patient for this appointment
    private String date;  // Date of the appointment
    private String time;  // Time of the appointment
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Appointment.class);  // Logger for logging appointment creation
    
    /**
     * Default constructor for Appointment class.
     */
    public Appointment(){
    }
    
    /**
     * Constructor for Appointment class with parameters.
     * 
     * @param appointmentID Unique ID for the appointment
     * @param doctor Doctor object for this appointment
     * @param patient Patient object for this appointment
     * @param date Date of the appointment
     * @param time Time of the appointment
     */
    public Appointment(String appointmentID, Doctor doctor, Patient patient, String date, String time) {
        this.appointmentID = appointmentID;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        LOGGER.info("New appointment created: {}", appointmentID);  // Log the creation of a new appointment
    }
    
    //getters
    public String getAppointmentID(){
        return appointmentID;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }

    //setters
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
}

