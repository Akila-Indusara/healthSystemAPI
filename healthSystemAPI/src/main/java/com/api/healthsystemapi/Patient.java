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
 * Patient class represents a patient in the healthcare system.
 * Extends the Person class.
 */
public class Patient extends Person {
    private Medical_Record medical_record;  // The patient's medical record
    private String current_Health_Status;  // The patient's current health status
    private String hospital;  // The hospital where the patient is associated
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Patient.class);  // Logger for logging patient creation
    
    /**
     * Default constructor for Patient class.
     */
    public Patient() {
    }
    
    /**
     * Constructor for Patient class with parameters.
     * 
     * @param ID Unique ID for the patient
     * @param name Name of the patient
     * @param age Age of the patient
     * @param contactNumber Contact number of the patient
     * @param address Address of the patient
     * @param current_Health_Status Current health status of the patient
     * @param hospital Hospital where the patient is associated
     */
    public Patient(String ID, String name, int age, int contactNumber, String address, String current_Health_Status, String hospital) {
        super(ID, name, age, contactNumber, address);  // Call the constructor of the superclass (Person)
        this.current_Health_Status = current_Health_Status;
        this.hospital = hospital;
        LOGGER.info("New Patient created: {}", ID);  // Log the creation of a new patient
    }

    // Getters
    public Medical_Record getMedical_record() {
        return medical_record;
    }
    public String getCurrent_Health_Status() {
        return current_Health_Status;
    }
    public String getHospital(){
        return hospital;
    }

    // Setters
    public void setMedical_record(Medical_Record medical_record) {
        this.medical_record = medical_record;
    }
    public void setCurrent_Health_Status(String current_Health_Status) {
        this.current_Health_Status = current_Health_Status;
    }
    public void setHospital(String hospital){
        this.hospital = hospital;
    }
}

