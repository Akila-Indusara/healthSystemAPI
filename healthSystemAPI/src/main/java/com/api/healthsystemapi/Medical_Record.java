/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Medical_Record class represents a patient's medical record in the healthcare system.
 */
public class Medical_Record {
    private String PatientID;
    private String medical_RecordID;  // Unique ID for each medical record
    private Map<String, String> diagnosesAndtreatments;  // Map of diagnoses and treatments for the patient
    private List<String> currentMedications;  // List of current medications the patient is taking
    private List<String> allergies;  // List of allergies the patient has
    private List<String> medicalConditions;  // List of medical conditions the patient has

    private static final Logger LOGGER = LoggerFactory.getLogger(Medical_Record.class);  // Logger for logging medical record creation
    
    /**
     * Default constructor for Medical_Record class.
     */
    public Medical_Record() {
    }

    /**
     * Constructor for Medical_Record class with parameters.
     * 
     * @param PatientID Patient ID
     * @param medical_RecordID Unique ID for the medical record
     * @param diagnosesAndtreatments Map of diagnoses and treatments for the patient
     * @param currentMedications List of current medications the patient is taking
     * @param allergies List of allergies the patient has
     * @param medicalConditions List of medical conditions the patient has
     */
    public Medical_Record(String PatientID,
            String medical_RecordID,
            Map<String, String> diagnosesAndtreatments, 
            List<String> currentMedications,
            List<String> allergies, 
            List<String> medicalConditions) {
        this.PatientID = PatientID;
        this.medical_RecordID = medical_RecordID;
        this.diagnosesAndtreatments = diagnosesAndtreatments;
        this.currentMedications = currentMedications;
        this.allergies = allergies;
        this.medicalConditions = medicalConditions;
        LOGGER.info("New Medical Record created: {}", medical_RecordID);  // Log the creation of a new medical record
    }

    // Getters
    public String getPatientID() {
        return PatientID; //return patient ID
    }
    
    public String getMedical_RecordID() {
        return medical_RecordID; //return medical record ID
    }

    public Map<String, String> getDiagnosesAndtreatments() {
        return Collections.unmodifiableMap(diagnosesAndtreatments);  // Return an unmodifiable map to prevent direct modification
    }

    public List<String> getCurrentMedications() {
        return Collections.unmodifiableList(currentMedications);  // Return an unmodifiable list to prevent direct modification
    }

    public List<String> getAllergies() {
        return Collections.unmodifiableList(allergies);  // Return an unmodifiable list to prevent direct modification
    }

    public List<String> getMedicalConditions() {
        return Collections.unmodifiableList(medicalConditions);  // Return an unmodifiable list to prevent direct modification
    }

    // Setters with validation
    public void setDiagnosesAndtreatments(Map<String, String> diagnoses) {
        if (diagnoses != null && !diagnoses.isEmpty()) {
            this.diagnosesAndtreatments = diagnoses;
        }
    }

    public void setCurrentMedications(List<String> currentMedications) {
        if (currentMedications != null && !currentMedications.isEmpty()) {
            this.currentMedications = currentMedications;
        }
    }

    public void setAllergies(List<String> allergies) {
        if (allergies != null && !allergies.isEmpty()) {
            this.allergies = allergies;
        }
    }

    public void setMedicalConditions(List<String> medicalConditions) {
        if (medicalConditions != null && !medicalConditions.isEmpty()) {
            this.medicalConditions = medicalConditions;
        }
    }
}

