/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Medical_Record;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.IdAlreadyExistException;
import com.api.healthsystemapi.exception.Medical_RecordNotFoundException;
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
 * Medical_RecordDAO class provides data access operations for medical records in the system.
 * It manages the storage, retrieval, update, and deletion of medical record entries.
 */
public class Medical_RecordDAO {
    private static final List<Medical_Record> Medical_Records = new ArrayList<>();
     
    private static final Logger LOGGER = LoggerFactory.getLogger(Medical_RecordDAO.class);
    
    /**
     * Get all medical records.
     *
     * @return List of medical records
     */
    public List<Medical_Record> getAllMedical_Records() {
        LOGGER.info("Fetching all medical records.");
        if (Medical_Records.isEmpty()) {
            LOGGER.warn("No medical records found.");
            throw new Medical_RecordNotFoundException("Medical Records not found.");
        } else {
            LOGGER.info("Retrieved {} Medical Records.", Medical_Records.size());
            return Collections.unmodifiableList(Medical_Records);
        }
    }
    
    /**
     * Get medical record by record ID.
     *
     * @param ID record ID
     * @return Medical record
     */
    public Medical_Record getRecordByID(String ID) {
        LOGGER.info("Fetching medical record by ID: {}", ID);
        for (Medical_Record medical_Record : Medical_Records) {
            if (medical_Record.getMedical_RecordID().equals(ID)) {
                return medical_Record;
            }
        }
        LOGGER.warn("Medical record with ID {} not found.", ID);
        throw new Medical_RecordNotFoundException("Medical Record with ID " + ID + " not found.");
    }

    /**
     * Get medical record by patient ID.
     *
     * @param ID Patient ID
     * @return Medical record
     */
    public Medical_Record getRecordByPatientID(String ID) {
        LOGGER.info("Fetching medical record by Patient ID: {}", ID);
        for (Medical_Record medical_Record : Medical_Records) {
            if (medical_Record.getMedical_RecordID().equals(ID)) {
                return medical_Record;
            }
        }
        LOGGER.warn("Medical record with Patient ID {} not found.", ID);
        throw new Medical_RecordNotFoundException("Medical Record with Patient ID " + ID + " not found.");
    }

   
   /**
    * Add a new medical record.
    *
    * @param medical_Record Medical record to add
    */
   public void addMedical_Record(Medical_Record medical_Record) {
       checkExsistance(medical_Record);

       LOGGER.info("Adding new medical record: {}", medical_Record);
       Medical_Records.add(medical_Record);
   }

   /**
    * Check the existence of a medical record ID and medical record data.
    *
    * @param medical_Record The medical record to check
    * @throws IdAlreadyExistException if the medical record ID already exists
    * @throws DataAlreadyExistException if the medical record data already exists
    */
   private void checkExsistance(Medical_Record medical_Record){
       // Check if medical record ID already exists or if medical record data already exists
       for (Medical_Record m : Medical_Records) {
           if (m.getMedical_RecordID().equals(medical_Record.getMedical_RecordID())) {
               LOGGER.warn("Medical record with ID {} already exists while adding medical record: {}", medical_Record.getMedical_RecordID(), medical_Record);
               throw new IdAlreadyExistException("ID " + medical_Record.getMedical_RecordID() + " already exists.");
           } else if (m.getDiagnosesAndtreatments().equals(medical_Record.getDiagnosesAndtreatments()) &&
                   m.getCurrentMedications() == medical_Record.getCurrentMedications() &&
                   m.getAllergies() == medical_Record.getAllergies() &&
                   m.getMedicalConditions().equals(medical_Record.getMedicalConditions())) {
               LOGGER.warn("Medical record data already exists while adding medical record: {}", medical_Record);
               throw new DataAlreadyExistException("Data already exists with ID " + medical_Record.getMedical_RecordID());
           }
       }
   }



    /**
    * Update an existing medical record.
    *
    * @param updatedMedical_Record Updated medical record
    * @throws Medical_RecordNotFoundException if the medical record to update is not found
    */
   public void updateMedical_Record(Medical_Record updatedMedical_Record) {
       LOGGER.info("Updating medical record with ID: {}", updatedMedical_Record.getMedical_RecordID());
       for (int i = 0; i < Medical_Records.size(); i++) {
           Medical_Record medical_Record = Medical_Records.get(i);
           if (medical_Record.getMedical_RecordID().equals(updatedMedical_Record.getMedical_RecordID())) {
               Medical_Records.set(i, updatedMedical_Record);
               LOGGER.info("Medical record updated: {}", updatedMedical_Record);
               return;
           }
       }
       LOGGER.warn("Medical record with ID {} not found for update.", updatedMedical_Record.getMedical_RecordID());
       throw new Medical_RecordNotFoundException("Medical Record with ID " +
               updatedMedical_Record.getMedical_RecordID() + " not found.");
   }


    /**
     * Delete a medical record by ID.
     *
     * @param id ID of the medical record to delete
     */
    public void deleteMedical_Record(String id) {
        LOGGER.info("Deleting medical record with ID: {}", id);
        if (Medical_Records.removeIf(medical_Record -> medical_Record.getMedical_RecordID().equals(id))) {
            LOGGER.info("Medical record deleted with ID: {}", id);
        } else {
            LOGGER.warn("Medical record with ID {} not found for deletion.", id);
            throw new Medical_RecordNotFoundException("Medical Record with ID " + id + " not found.");
        }
    }
}

