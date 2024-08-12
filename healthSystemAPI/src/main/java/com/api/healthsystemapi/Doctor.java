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
 * Doctor class represents a medical doctor in the healthcare system.
 * Extends the Person class.
 */
public class Doctor extends Person {
    private String specialization;  // The doctor's area of specialization (e.g., cardiology, pediatrics, etc.)
    private String department;  // The department within the healthcare system where the doctor works
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Doctor.class);  // Logger for logging doctor creation
    
    /**
     * Default constructor for Doctor class.
     */
    public Doctor() {
    }
    
    /**
     * Constructor for Doctor class with parameters.
     * 
     * @param ID Unique ID for the doctor
     * @param name Name of the doctor
     * @param age Age of the doctor
     * @param contactNumber Contact number of the doctor
     * @param address Address of the doctor
     * @param specialization Area of specialization for the doctor
     * @param department Department where the doctor works
     */
    public Doctor(String ID, String name, int age, int contactNumber, String address, String specialization, String department) {
        super(ID, name, age, contactNumber, address);  // Call the constructor of the superclass (Person)
        this.specialization = specialization;
        this.department = department;
        LOGGER.info("New Doctor created: {}", ID);  // Log the creation of a new doctor
    }
    
    //getters
    public String getSpecialization() {
        return specialization;
    }
    public String getDepartment() {
        return department;
    }
    
    //setters
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
