/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Doctor;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.DoctorNotFoundException;
import com.api.healthsystemapi.exception.IdAlreadyExistException;
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
 * DoctorDAO class provides data access operations for doctors in the system.
 * It manages the storage, retrieval, update, and deletion of doctor records.
 */
public class DoctorDAO {
    private static final List<Doctor> Doctors = new ArrayList<>();  // List to store doctor records

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorDAO.class);  // Logger for logging DAO operations
     
    /**
     * Retrieve all doctors stored in the DAO.
     *
     * @return List of doctors
     * @throws DoctorNotFoundException if no doctors are found
     */
    public List<Doctor> getAllDoctors() {
        LOGGER.info("Fetching all doctors.");
        if (Doctors.isEmpty()) {
            LOGGER.warn("No doctors found.");
            throw new DoctorNotFoundException("Doctors not found.");
        } else {
            LOGGER.info("Retrieved {} Doctors.", Doctors.size());
            return Collections.unmodifiableList(Doctors);
        }
    }

    /**
     * Get a doctor record by its ID.
     *
     * @param ID Doctor ID
     * @return The doctor record
     * @throws DoctorNotFoundException if the doctor record is not found
     */
    public Doctor getDoctorByID(String ID) {
        LOGGER.info("Fetching doctor by ID: {}", ID);
        for (Doctor doctor : Doctors) {
            if (doctor.getID().equals(ID)) {
                return doctor;
            }
        }
        LOGGER.warn("Doctor with ID {} not found.", ID);
        throw new DoctorNotFoundException("Doctor with ID " + ID + " not found.");
    }

    /**
     * Get a doctor record by its name.
     *
     * @param name Doctor name
     * @return The doctor record
     * @throws DoctorNotFoundException if the doctor record is not found
     */
    public Doctor getDoctorByName(String name) {
        LOGGER.info("Fetching doctor by name: {}", name);
        for (Doctor doctor : Doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        LOGGER.warn("Doctor with name {} not found.", name);
        throw new DoctorNotFoundException("Doctor with name " + name + " not found.");
    }

    /**
     * Get doctors with a specific specialization.
     *
     * @param specialization Doctor specialization
     * @return List of doctors with the given specialization
     * @throws DoctorNotFoundException if no doctors are found for the specialization
     */
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        LOGGER.info("Fetching doctors by specialization: {}", specialization);
        List<Doctor> doc = new ArrayList<>();
        for (Doctor doctor : Doctors) {
            if (doctor.getSpecialization().equals(specialization)) {
                doc.add(doctor);
            }
        }
        if (doc.isEmpty()) {
            LOGGER.warn("No doctors found for specialization {}.", specialization);
            throw new DoctorNotFoundException("Doctors with specialization " + specialization + " not found.");
        } else {
            return doc;
        }
    }

    /**
     * Get doctors working in a specific department.
     *
     * @param department Doctor department
     * @return List of doctors in the given department
     * @throws DoctorNotFoundException if no doctors are found for the department
     */
    public List<Doctor> getDoctorsByDepartment(String department) {
        LOGGER.info("Fetching doctors by department: {}", department);
        List<Doctor> doc = new ArrayList<>();
        for (Doctor doctor : Doctors) {
            if (doctor.getDepartment().equals(department)) {
                doc.add(doctor);
            }
        }
        if (doc.isEmpty()) {
            LOGGER.warn("No doctors found for department {}.", department);
            throw new DoctorNotFoundException("Doctors in department " + department + " not found.");
        } else {
            return doc;
        }
    }

   
   /**
    * Add a new doctor record to the DAO.
    *
    * @param doctor The doctor record to add
    */
   public void addDoctor(Doctor doctor) {
       checkExsistance(doctor);

       LOGGER.info("Adding new doctor: {}", doctor);
       Doctors.add(doctor);
   }

   /**
    * Check the existence of a doctor ID and doctor data.
    *
    * @param doctor The doctor record to check
    * @throws IdAlreadyExistException if the doctor ID already exists
    * @throws DataAlreadyExistException if the doctor data already exists
    */
   private void checkExsistance(Doctor doctor){
       // Check if doctor ID already exists or if doctor data already exists
       for (Doctor d : Doctors) {
           if (d.getID().equals(doctor.getID())) {
               LOGGER.warn("Doctor with ID {} already exists while adding doctor: {}", doctor.getID(), doctor);
               throw new IdAlreadyExistException("ID " + doctor.getID() + " already exists.");
           } else if (d.getName().equals(doctor.getName()) &&
                   d.getAge() == doctor.getAge() &&
                   d.getContactNumber() == doctor.getContactNumber() &&
                   d.getAddress().equals(doctor.getAddress()) &&
                   d.getSpecialization().equals(doctor.getSpecialization()) &&
                   d.getDepartment().equals(doctor.getDepartment())) {
               LOGGER.warn("Doctor data already exists while adding doctor: {}", doctor);
               throw new DataAlreadyExistException("Data already exists with ID " + doctor.getID());
           }
       }
   }



    /**
    * Update an existing doctor record in the DAO.
    *
    * @param updatedDoctor The updated doctor record
    * @throws DoctorNotFoundException if the doctor record to update is not found
    */
   public void updateDoctor(Doctor updatedDoctor) {
       LOGGER.info("Updating doctor with ID: {}", updatedDoctor.getID());
       for (int i = 0; i < Doctors.size(); i++) {
           Doctor doctor = Doctors.get(i);
           if (doctor.getID().equals(updatedDoctor.getID())) {
               Doctors.set(i, updatedDoctor);
               LOGGER.info("Doctor updated: {}", updatedDoctor);
               return;
           }
       }
       LOGGER.warn("Doctor with ID {} not found for update.", updatedDoctor.getID());
       throw new DoctorNotFoundException("Doctor with ID " + updatedDoctor.getID() + " not found.");
   }


    /**
     * Delete a doctor record from the DAO by its ID.
     *
     * @param id The ID of the doctor record to delete
     */
    public void deleteDoctor(String id) {
        LOGGER.info("Deleting doctor with ID: {}", id);
        if (Doctors.removeIf(doctor -> doctor.getID().equals(id))) {
            LOGGER.info("Doctor deleted with ID: {}", id);
        } else {
            LOGGER.warn("Doctor with ID {} not found for deletion.", id);
            throw new DoctorNotFoundException("Doctor with ID " + id + " not found.");
        }
    }
}

