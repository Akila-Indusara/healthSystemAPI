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
 * Billing class represents the billing information for a medical appointment between a doctor and a patient.
 */
public class Billing {
    private String billingID;  // Unique ID for each billing record
    private Patient patient;  // Patient object representing the patient associated with the billing
    private Doctor doctor;  // Doctor object representing the doctor associated with the billing
    private String date;  // Date of the billing
    private String time;  // Time of the billing
    private String status;  // Status of the billing (e.g., paid, pending, etc.)
    private double amount;  // Amount to be billed

    private static final Logger LOGGER = LoggerFactory.getLogger(Billing.class);  // Logger for logging billing creation
    
    /**
     * Default constructor for Billing class.
     */
    public Billing() {
    }
    
    /**
     * Constructor for Billing class with parameters.
     * 
     * @param billingID Unique ID for the billing record
     * @param patient Patient object associated with the billing
     * @param doctor Doctor object associated with the billing
     * @param date Date of the billing
     * @param time Time of the billing
     * @param status Status of the billing
     * @param amount Amount to be billed
     */
    public Billing(String billingID, Patient patient, Doctor doctor, String date, String time, String status, double amount) {
        this.billingID = billingID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;
        this.amount = amount;
        LOGGER.info("New Bill created: {}", billingID);  // Log the creation of a new billing record
    }

    //getters
    public String getbillingID(){
        return billingID;
    }
    public Patient getPatient() {
        return patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getStatus() {
        return status;
    }
    public double getAmount() {
        return amount;
    }

    //setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
