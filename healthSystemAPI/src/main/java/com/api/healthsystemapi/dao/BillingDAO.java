/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Billing;
import com.api.healthsystemapi.Doctor;
import com.api.healthsystemapi.Patient;
import com.api.healthsystemapi.exception.BillingNotFoundException;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.DoctorNotFoundException;
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
 * BillingDAO class provides data access operations for billings in the system.
 * It manages the storage, retrieval, update, and deletion of billing records.
 */
public class BillingDAO {
    private final List<Billing> Bills = new ArrayList<>();  // List to store billing records
    private static final PatientDAO patientDAO = new PatientDAO();
    private static final DoctorDAO doctorDAO = new DoctorDAO();

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingDAO.class);  // Logger for logging DAO operations
    
    /**
     * Retrieve all billings stored in the DAO.
     *
     * @return List of billings
     * @throws BillingNotFoundException if no billings are found
     */
    public List<Billing> getAllBillings() {
        if (Bills.isEmpty()) {
            LOGGER.warn("No bills found.");
            throw new BillingNotFoundException("Bills not found.");
        } else {
            LOGGER.info("Fetching all billings.");
            return Collections.unmodifiableList(Bills);
        }
    }

    /**
     * Get a billing record by its ID.
     *
     * @param ID Billing ID
     * @return The billing record
     * @throws BillingNotFoundException if the billing record is not found
     */
    public Billing getBillingByID(String ID) {
        LOGGER.info("Fetching billing by ID: {}", ID);
        for (Billing billing : Bills) {
            if (billing.getbillingID().equals(ID)) {
                return billing;
            }
        }
        LOGGER.warn("Billing with ID {} not found.", ID);
        throw new BillingNotFoundException("Billing with ID " + ID + " not found.");
    }

    /**
     * Get billings for a specific doctor by the doctor's ID.
     *
     * @param ID Doctor ID
     * @return List of billings for the doctor
     * @throws BillingNotFoundException if no billings are found for the doctor
     */
    public List<Billing> getBillingsByDoctorID(String ID) {
        LOGGER.info("Fetching billings by Doctor ID: {}", ID);
        List<Billing> billingsByDoc = new ArrayList<>();
        for (Billing billing : Bills) {
            if (billing.getDoctor().getID().equals(ID)) {
                billingsByDoc.add(billing);
            }
        }
        if (billingsByDoc.isEmpty()) {
            LOGGER.warn("No billings found for Doctor ID {}.", ID);
            throw new BillingNotFoundException("Billings with Doctor ID " + ID + " not found.");
        } else {
            return billingsByDoc;
        }
    }

    /**
     * Get billings for a specific patient by the patient's ID.
     *
     * @param ID Patient ID
     * @return List of billings for the patient
     * @throws BillingNotFoundException if no billings are found for the patient
     */
    public List<Billing> getBillingsByPatientID(String ID) {
        LOGGER.info("Fetching billings by Patient ID: {}", ID);
        List<Billing> billingsByPat = new ArrayList<>();
        for (Billing billing : Bills) {
            if (billing.getPatient().getID().equals(ID)) {
                billingsByPat.add(billing);
            }
        }
        if (billingsByPat.isEmpty()) {
            LOGGER.warn("No billings found for Patient ID {}.", ID);
            throw new BillingNotFoundException("Billings with Patient ID " + ID + " not found.");
        } else {
            return billingsByPat;
        }
    }

    
   /**
    * Add a new billing record to the DAO.
    *
    * @param billing The billing record to add
    */
   public void addBilling(Billing billing) {
       checkExsistance(billing);

       LOGGER.info("Adding new billing: {}", billing);
       Bills.add(billing);
   }

   /**
    * Check the existence of a patient, doctor, and billing data.
    *
    * @param billing The billing record to check
    * @throws PatientNotFoundException if the patient does not exist
    * @throws DoctorNotFoundException if the doctor does not exist
    * @throws IdAlreadyExistException if the billing ID already exists
    * @throws DataAlreadyExistException if the billing data already exists
    */
   private void checkExsistance(Billing billing){
       // Check if the patient exists in the PatientDAO
       Patient patient = patientDAO.getPatientByID(billing.getPatient().getID());
       if (patient == null) {
           LOGGER.warn("Patient with ID {} not found while adding billing: {}", billing.getPatient().getID(), billing);
           throw new PatientNotFoundException("Patient with ID " + billing.getPatient().getID() + " not found.");
       }

       // Check if the doctor exists in the DoctorDAO
       Doctor doctor = doctorDAO.getDoctorByID(billing.getDoctor().getID());
       if (doctor == null) {
           LOGGER.warn("Doctor with ID {} not found while adding billing: {}", billing.getDoctor().getID(), billing);
           throw new DoctorNotFoundException("Doctor with ID " + billing.getDoctor().getID() + " not found.");
       }

       // Check if billing ID already exists or if billing data already exists
       for (Billing b : Bills) {
           if (b.getbillingID().equals(billing.getbillingID())) {
               LOGGER.warn("Billing ID {} already exists while adding billing: {}", billing.getbillingID(), billing);
               throw new IdAlreadyExistException("ID " + billing.getbillingID() + " already exists.");
           } else if (b.getDoctor().getID().equals(billing.getDoctor().getID()) &&
                   b.getPatient().getID().equals(billing.getPatient().getID()) &&
                   b.getDate().equals(billing.getDate()) &&
                   b.getTime().equals(billing.getTime()) &&
                   b.getStatus().equals(billing.getStatus()) &&
                   b.getAmount() == billing.getAmount()) {
               LOGGER.warn("Billing data already exists while adding billing: {}", billing);
               throw new DataAlreadyExistException("Data already exists with ID " + billing.getbillingID());
           }
       }
   }



    /**
    * Update an existing billing record in the DAO.
    *
    * @param updatedBilling The updated billing record
    * @throws BillingNotFoundException if the billing record to update is not found
    */
   public void updateBilling(Billing updatedBilling) {
       LOGGER.info("Updating billing with ID: {}", updatedBilling.getbillingID());
       for (int i = 0; i < Bills.size(); i++) {
           Billing billing = Bills.get(i);
           if (billing.getbillingID().equals(updatedBilling.getbillingID())) {
               Bills.set(i, updatedBilling);
               LOGGER.info("Billing updated: {}", updatedBilling);
               return;
           }
       }
       LOGGER.warn("Billing with ID {} not found for update.", updatedBilling.getbillingID());
       throw new BillingNotFoundException("Billing with ID " + updatedBilling.getbillingID() + " not found.");
   }


    /**
     * Delete a billing record from the DAO by its ID.
     *
     * @param id The ID of the billing record to delete
     */
    public void deleteBilling(String id) {
        LOGGER.info("Deleting billing with ID: {}", id);
        if (Bills.removeIf(billing -> billing.getbillingID().equals(id))) {
            LOGGER.info("Billing deleted with ID: {}", id);
        } else {
            LOGGER.warn("Billing with ID {} not found for deletion.", id);
            throw new BillingNotFoundException("Billing with ID " + id + " not found.");
        }
    }
}

