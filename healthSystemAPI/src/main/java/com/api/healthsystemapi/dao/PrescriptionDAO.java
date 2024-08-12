/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Doctor;
import com.api.healthsystemapi.Patient;
import com.api.healthsystemapi.Prescription;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.DoctorNotFoundException;
import com.api.healthsystemapi.exception.IdAlreadyExistException;
import com.api.healthsystemapi.exception.PatientNotFoundException;
import com.api.healthsystemapi.exception.PrescriptionNotFoundException;
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
 * PrescriptionDAO class provides data access operations for prescriptions in the system.
 * It manages the storage, retrieval, update, and deletion of prescription records.
 * The class includes methods to fetch prescriptions by ID, doctor ID, and patient ID.
 * It maintains a list of prescriptions and provides methods to interact with this list.
 */
public class PrescriptionDAO {
    private static final List<Prescription> Prescriptions = new ArrayList<>();
    private static final PatientDAO patientDAO = new PatientDAO();
    private static final DoctorDAO doctorDAO = new DoctorDAO();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionDAO.class);
    
    /**
     * Get all prescriptions.
     *
     * @return List of prescriptions
     * @throws PrescriptionNotFoundException if no prescriptions are found
     */
    public List<Prescription> getAllPrescriptions() {
        LOGGER.info("Fetching all prescriptions.");
        if (Prescriptions.isEmpty()) {
            LOGGER.warn("No prescriptions found.");
            throw new PrescriptionNotFoundException("Prescriptions not found.");
        } else {
            LOGGER.info("Retrieved {} prescriptions.", Prescriptions.size());
            return Collections.unmodifiableList(Prescriptions);
        }
    }

    /**
     * Get prescription by ID.
     *
     * @param ID Prescription ID
     * @return Prescription
     * @throws PrescriptionNotFoundException if prescription with the given ID is not found
     */
    public Prescription getPrescriptionByID(String ID) {
        LOGGER.info("Fetching prescription by ID: {}", ID);
        for (Prescription prescription : Prescriptions) {
            if (prescription.getPrescriptionID().equals(ID)) {
                return prescription;
            }
        }
        LOGGER.warn("Prescription with ID {} not found.", ID);
        throw new PrescriptionNotFoundException("Prescription with ID " + ID + " not found.");
    }

    /**
     * Get prescriptions by Doctor ID.
     *
     * @param ID Doctor ID
     * @return List of prescriptions
     * @throws PrescriptionNotFoundException if no prescriptions are found for the given Doctor ID
     */
    public List<Prescription> getPrescriptionsByDoctorID(String ID) {
        LOGGER.info("Fetching prescriptions by Doctor ID: {}", ID);
        List<Prescription> prescriptionsByDoc = new ArrayList<>();
        for (Prescription prescription : Prescriptions) {
            if (prescription.getDoctor().getID().equals(ID)) {
                prescriptionsByDoc.add(prescription);
            }
        }
        if (prescriptionsByDoc.isEmpty()) {
            LOGGER.warn("No prescriptions found for Doctor ID: {}", ID);
            throw new PrescriptionNotFoundException("Prescriptions for Doctor ID " + ID + " not found.");
        } else {
            return prescriptionsByDoc;
        }
    }

    /**
     * Get prescriptions by Patient ID.
     *
     * @param ID Patient ID
     * @return List of prescriptions
     * @throws PrescriptionNotFoundException if no prescriptions are found for the given Patient ID
     */
    public List<Prescription> getPrescriptionsByPatientID(String ID) {
        LOGGER.info("Fetching prescriptions by Patient ID: {}", ID);
        List<Prescription> prescriptionsByPat = new ArrayList<>();
        for (Prescription prescription : Prescriptions) {
            if (prescription.getPatient().getID().equals(ID)) {
                prescriptionsByPat.add(prescription);
            }
        }
        if (prescriptionsByPat.isEmpty()) {
            LOGGER.warn("No prescriptions found for Patient ID: {}", ID);
            throw new PrescriptionNotFoundException("Prescriptions for Patient ID " + ID + " not found.");
        } else {
            return prescriptionsByPat;
        }
    }

      /**
     * Add a new prescription.
     *
     * @param prescription Prescription to add
     */
    public void addPrescription(Prescription prescription) {
        checkExsistance(prescription);

        LOGGER.info("Adding new prescription: {}", prescription);
        Prescriptions.add(prescription);
    }

    /**
     * Check the existence of a prescription ID and prescription data.
     *
     * @param prescription The prescription to check
     * @throws PatientNotFoundException if the patient does not exist
     * @throws DoctorNotFoundException if the doctor does not exist
     * @throws IdAlreadyExistException if the prescription ID already exists
     * @throws DataAlreadyExistException if the prescription data already exists
     */
    private void checkExsistance(Prescription prescription){
        // Check if the patient exists in the PatientDAO
        Patient patient = patientDAO.getPatientByID(prescription.getPatient().getID());
        if (patient == null) {
            LOGGER.warn("Patient with ID {} not found while adding prescription: {}", prescription.getPatient().getID(), prescription);
            throw new PatientNotFoundException("Patient with ID " + prescription.getPatient().getID() + " not found.");
        }

        // Check if the doctor exists in the DoctorDAO
        Doctor doctor = doctorDAO.getDoctorByID(prescription.getDoctor().getID());
        if (doctor == null) {
            LOGGER.warn("Doctor with ID {} not found while adding prescription: {}", prescription.getDoctor().getID(), prescription);
            throw new DoctorNotFoundException("Doctor with ID " + prescription.getDoctor().getID() + " not found.");
        }

        // Check if prescription ID already exists or if prescription data already exists
        for (Prescription p : Prescriptions) {
            if (p.getPrescriptionID().equals(prescription.getPrescriptionID())) {
                LOGGER.warn("Prescription with ID {} already exists while adding prescription: {}", prescription.getPrescriptionID(), prescription);
                throw new IdAlreadyExistException("ID " + prescription.getPrescriptionID() + " already exists.");
            } else if (p.getDoctor().getID().equals(prescription.getDoctor().getID()) &&
                    p.getPatient().getID().equals(prescription.getPatient().getID()) &&
                    p.getDate().equals(prescription.getDate()) &&
                    p.getTime().equals(prescription.getTime()) &&
                    p.getMedicine().equals(prescription.getMedicine()) &&
                    p.getDosage().equals(prescription.getDosage()) &&
                    p.getDuration().equals(prescription.getDuration())) {
                LOGGER.warn("Prescription data already exists while adding prescription: {}", prescription);
                throw new DataAlreadyExistException("Data already exists with ID " + prescription.getPrescriptionID());
            }
        }
    }

    /**
     * Update an existing prescription.
     *
     * @param updatedPrescription Updated prescription
     * @throws PrescriptionNotFoundException if prescription with the updated prescription's ID is not found
     */
    public void updatePrescription(Prescription updatedPrescription) {
        LOGGER.info("Updating prescription with ID: {}", updatedPrescription.getPrescriptionID());
        for (int i = 0; i < Prescriptions.size(); i++) {
            Prescription prescription = Prescriptions.get(i);
            if (prescription.getPrescriptionID().equals(updatedPrescription.getPrescriptionID())) {
                Prescriptions.set(i, updatedPrescription);
                LOGGER.info("Prescription updated: {}", updatedPrescription);
                return;
            }
        }
        LOGGER.warn("Prescription with ID {} not found for update.", updatedPrescription.getPrescriptionID());
        throw new PrescriptionNotFoundException("Prescription with ID " + updatedPrescription.getPrescriptionID() + " not found.");
    }

    /**
     * Delete a prescription by ID.
     *
     * @param id ID of the prescription to delete
     * @throws PrescriptionNotFoundException if prescription with the given ID is not found for deletion
     */
    public void deletePrescription(String id) {
        LOGGER.info("Deleting prescription with ID: {}", id);
        if (Prescriptions.removeIf(prescription -> prescription.getPrescriptionID().equals(id))) {
            LOGGER.info("Prescription deleted with ID: {}", id);
        } else {
            LOGGER.warn("Prescription with ID {} not found for deletion.", id);
            throw new PrescriptionNotFoundException("Prescription with ID " + id + " not found.");
        }
    }
}

