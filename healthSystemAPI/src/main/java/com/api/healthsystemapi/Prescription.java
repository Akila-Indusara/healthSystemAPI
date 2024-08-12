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
 * Prescription class represents a prescription given by a doctor to a patient.
 */
public class Prescription {
    private String prescriptionID;  // Unique ID for each prescription
    private Doctor doctor;  // Doctor who issued the prescription
    private Patient patient;  // Patient to whom the prescription is issued
    private String date;  // Date when the prescription was issued
    private String time;  // Time when the prescription was issued
    private String medicine;  // Name of the prescribed medicine
    private String dosage;  // Dosage of the prescribed medicine
    private String duration;  // Duration for which the medicine should be taken

    private static final Logger LOGGER = LoggerFactory.getLogger(Prescription.class);  // Logger for logging prescription creation
    
    /**
     * Default constructor for Prescription class.
     */
    public Prescription() {
    }
    
    /**
     * Constructor for Prescription class with parameters.
     * 
     * @param prescriptionID Unique ID for the prescription
     * @param doctor Doctor who issued the prescription
     * @param patient Patient to whom the prescription is issued
     * @param date Date when the prescription was issued
     * @param time Time when the prescription was issued
     * @param medicine Name of the prescribed medicine
     * @param dosage Dosage of the prescribed medicine
     * @param duration Duration for which the medicine should be taken
     */
    public Prescription(String prescriptionID, Doctor doctor, Patient patient, 
            String date, String time, String medicine, String dosage, 
            String duration) {
        this.prescriptionID = prescriptionID;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
        LOGGER.info("New Prescription created: {}", prescriptionID);  // Log the creation of a new prescription
    }

    // Getters
    public String getPrescriptionID(){
        return prescriptionID;
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
    public String getMedicine() {
        return medicine;
    }
    public String getDosage() {
        return dosage;
    }
    public String getDuration() {
        return duration;
    }

    // Setters
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
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
