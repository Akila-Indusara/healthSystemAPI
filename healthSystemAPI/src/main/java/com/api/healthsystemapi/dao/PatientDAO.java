/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Patient;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.IdAlreadyExistException;
import com.api.healthsystemapi.exception.PatientNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * PatientDAO class provides data access operations for patients in the system.
 * It manages the storage, retrieval, update, and deletion of patient records.
 * It also provides methods to fetch patients by ID and name.
 * The class maintains a list of patients and provides methods to interact with this list.
 */
public class PatientDAO {
    private static final List<Patient> Patients = new ArrayList<>();
     
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientDAO.class);
   
    /**
     * Get all patients.
     *
     * @return List of patients
     * @throws PatientNotFoundException if no patients are found
     */
    public List<Patient> getAllPatients() {
        LOGGER.info("Fetching all patients.");
        if (Patients.isEmpty()) {
            LOGGER.warn("No patients found.");
            throw new PatientNotFoundException("Patients not found.");
        } else {
            LOGGER.info("Retrieved {} patients.", Patients.size());
            return Collections.unmodifiableList(Patients);
        }
    }

    /**
     * Get patient by ID.
     *
     * @param ID Patient ID
     * @return Patient
     * @throws PatientNotFoundException if patient with the given ID is not found
     */
    public Patient getPatientByID(String ID) {
        LOGGER.info("Fetching patient by ID: {}", ID);
        for (Patient patient : Patients) {
            if (patient.getID().equals(ID)) {
                return patient;
            }
        }
        LOGGER.warn("Patient with ID {} not found.", ID);
        throw new PatientNotFoundException("Patient with ID " + ID + " not found.");
    }

    /**
     * Get patient by name.
     *
     * @param name Patient name
     * @return Patient
     * @throws PatientNotFoundException if patient with the given name is not found
     */
    public Patient getPatientByName(String name) {
        LOGGER.info("Fetching patient by name: {}", name);
        for (Patient patient : Patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        LOGGER.warn("Patient with name {} not found.", name);
        throw new PatientNotFoundException("Patient with name " + name + " not found.");
    }

    
   /**
    * Add a new patient.
    *
    * @param patient Patient to add
    */
   public void addPatient(Patient patient) {
       checkExsistance(patient);

       LOGGER.info("Adding new patient: {}", patient);
       Patients.add(patient);
   }

   /**
    * Check the existence of a patient ID and patient data.
    *
    * @param patient The patient to check
    * @throws IdAlreadyExistException if the patient ID already exists
    * @throws DataAlreadyExistException if the patient data already exists
    */
   private void checkExsistance(Patient patient){
       // Check if patient ID already exists or if patient data already exists
       for (Patient p : Patients) {
           if (p.getID().equals(patient.getID())) {
               LOGGER.warn("Patient with ID {} already exists while adding patient: {}", patient.getID(), patient);
               throw new IdAlreadyExistException("ID " + patient.getID() + " already exists.");
           } else if (p.getName().equals(patient.getName()) &&
                   p.getAge() == patient.getAge() &&
                   p.getContactNumber() == patient.getContactNumber() &&
                   p.getAddress().equals(patient.getAddress()) &&
                   p.getCurrent_Health_Status().equals(patient.getCurrent_Health_Status()) &&
                   p.getHospital().equals(patient.getHospital())) {
               LOGGER.warn("Patient data already exists while adding patient: {}", patient);
               throw new DataAlreadyExistException("Data already exists with ID " + patient.getID());
           }
       }
   }

   /**
    * Update an existing patient.
    *
    * @param updatedPatient Updated patient
    * @throws PatientNotFoundException if patient with the updated patient's ID is not found
    */
   public void updatePatient(Patient updatedPatient) {
       LOGGER.info("Updating patient with ID: {}", updatedPatient.getID());
       for (int i = 0; i < Patients.size(); i++) {
           Patient patient = Patients.get(i);
           if (patient.getID().equals(updatedPatient.getID())) {
               Patients.set(i, updatedPatient);
               LOGGER.info("Patient updated: {}", updatedPatient);
               return;
           }
       }
       LOGGER.warn("Patient with ID {} not found for update.", updatedPatient.getID());
       throw new PatientNotFoundException("Patient with ID " + updatedPatient.getID() + " not found.");
   }


    /**
     * Delete a patient by ID.
     *
     * @param id ID of the patient to delete
     * @throws PatientNotFoundException if patient with the given ID is not found for deletion
     */
    public void deletePatient(String id) {
        LOGGER.info("Deleting patient with ID: {}", id);
        if (Patients.removeIf(patient -> patient.getID().equals(id))) {
            LOGGER.info("Patient deleted with ID: {}", id);
        } else {
            LOGGER.warn("Patient with ID {} not found for deletion.", id);
            throw new PatientNotFoundException("Patient with ID " + id + " not found.");
        }
    }
}

