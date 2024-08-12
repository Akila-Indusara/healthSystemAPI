/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Appointment;
import com.api.healthsystemapi.Doctor;
import com.api.healthsystemapi.Patient;
import com.api.healthsystemapi.exception.AppointmentNotFoundException;
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
 * AppointmentDAO class provides data access operations for appointments in the system.
 */
public class AppointmentDAO {
    private static final List<Appointment> Appointments = new ArrayList<>();  // List to store appointments
    private static final PatientDAO patientDAO = new PatientDAO();
    private static final DoctorDAO doctorDAO = new DoctorDAO();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentDAO.class);  // Logger for logging DAO operations
     
    /**
     * Get all appointments stored in the DAO.
     *
     * @return List of appointments
     * @throws AppointmentNotFoundException if no appointments are found
     */
    public List<Appointment> getAllAppointments() {
        if (Appointments.isEmpty()) {
            LOGGER.warn("No appointments found.");
            throw new AppointmentNotFoundException("Appointments not found.");
        } else {
            LOGGER.info("Retrieving all appointments.");
            return Collections.unmodifiableList(Appointments);
        }
    }
     
    /**
     * Get an appointment by its ID.
     *
     * @param ID Appointment ID
     * @return The appointment
     * @throws AppointmentNotFoundException if the appointment is not found
     */
    public Appointment getAppointmentByID(String ID) {
        LOGGER.info("Retrieving appointment by ID: {}", ID);
        for (Appointment appointment : Appointments) {
            if (appointment.getAppointmentID().equals(ID)) {
                return appointment;
            }
        }
        LOGGER.warn("Appointment with ID {} not found.", ID);
        throw new AppointmentNotFoundException("Appointment with ID " + ID + " not found.");
    }

    /**
     * Get appointments for a specific doctor by the doctor's ID.
     *
     * @param ID Doctor ID
     * @return List of appointments for the doctor
     * @throws AppointmentNotFoundException if no appointments are found for the doctor
     */
    public List<Appointment> getAppointmentsByDoctorID(String ID) {
        LOGGER.info("Retrieving appointments by Doctor ID: {}", ID);
        List<Appointment> appointmentsByDoc = new ArrayList<>();
        for (Appointment appointment : Appointments) {
            if (appointment.getDoctor().getID().equals(ID)) {
                appointmentsByDoc.add(appointment);
            }
        }
        if (appointmentsByDoc.isEmpty()) {
            LOGGER.warn("Appointments for Doctor ID {} not found.", ID);
            throw new AppointmentNotFoundException("Appointments for Doctor ID " + ID + " not found.");
        } else {
            return appointmentsByDoc;
        }
    }

    /**
     * Get appointments for a specific patient by the patient's ID.
     *
     * @param ID Patient ID
     * @return List of appointments for the patient
     * @throws AppointmentNotFoundException if no appointments are found for the patient
     */
    public List<Appointment> getAppointmentsByPatientID(String ID) {
        LOGGER.info("Retrieving appointments by Patient ID: {}", ID);
        List<Appointment> appointmentsByPat = new ArrayList<>();
        for (Appointment appointment : Appointments) {
            if (appointment.getPatient().getID().equals(ID)) {
                appointmentsByPat.add(appointment);
            }
        }
        if (appointmentsByPat.isEmpty()) {
            LOGGER.warn("Appointments for Patient ID {} not found.", ID);
            throw new AppointmentNotFoundException("Appointments for Patient ID " + ID + " not found.");
        } else {
            return appointmentsByPat;
        }
    }

   /**
    * Add a new appointment to the DAO.
    *
    * @param appointment The appointment to add
    */
   public void addAppointment(Appointment appointment) {
       checkExsistance(appointment);

       LOGGER.info("Adding new appointment: {}", appointment);
       Appointments.add(appointment);
   }

   /**
    * Check the existence of a patient, doctor, and appointment data.
    *
    * @param appointment The appointment to check
    * @throws PatientNotFoundException if the patient does not exist
    * @throws DoctorNotFoundException if the doctor does not exist
    * @throws IdAlreadyExistException if the appointment ID already exists
    * @throws DataAlreadyExistException if the appointment data already exists
    */
   private void checkExsistance(Appointment appointment){
       // Check if the patient exists in the PatientDAO
       Patient patient = patientDAO.getPatientByID(appointment.getPatient().getID());
       if (patient == null) {
           LOGGER.warn("Patient with ID {} not found while adding appointment: {}", appointment.getPatient().getID(), appointment);
           throw new PatientNotFoundException("Patient with ID " + appointment.getPatient().getID() + " not found.");
       }

       // Check if the doctor exists in the DoctorDAO
       Doctor doctor = doctorDAO.getDoctorByID(appointment.getDoctor().getID());
       if (doctor == null) {
           LOGGER.warn("Doctor with ID {} not found while adding appointment: {}", appointment.getDoctor().getID(), appointment);
           throw new DoctorNotFoundException("Doctor with ID " + appointment.getDoctor().getID() + " not found.");
       }

       // Check if appointment ID already exists or if appointment data already exists
       for (Appointment a : Appointments) {
           if (a.getAppointmentID().equals(appointment.getAppointmentID())) {
               LOGGER.warn("Appointment ID {} already exists while adding appointment: {}", appointment.getAppointmentID(), appointment);
               throw new IdAlreadyExistException("Appointment ID " + appointment.getAppointmentID() + " already exists.");
           } else if (a.getDoctor().getID().equals(appointment.getDoctor().getID()) &&
                   a.getPatient().getID().equals(appointment.getPatient().getID()) &&
                   a.getDate().equals(appointment.getDate()) &&
                   a.getTime().equals(appointment.getTime())) {
               LOGGER.warn("Appointment data already exists while adding appointment: {}", appointment);
               throw new DataAlreadyExistException("Data already exists with ID " + appointment.getAppointmentID());
           }
       }
   }



    /**
 * Update an existing appointment in the DAO.
 *
 * @param updatedAppointment The updated appointment
 * @throws AppointmentNotFoundException if the appointment to update is not found
 */
public void updateAppointment(Appointment updatedAppointment) {
    LOGGER.info("Updating appointment with ID: {}", updatedAppointment.getAppointmentID());
    for (int i = 0; i < Appointments.size(); i++) {
        Appointment appointment = Appointments.get(i);
        if (appointment.getAppointmentID().equals(updatedAppointment.getAppointmentID())) {
            Appointments.set(i, updatedAppointment);
            LOGGER.info("Appointment updated: {}", updatedAppointment);
            return;
        }
    }
    LOGGER.warn("Appointment with ID {} not found.", updatedAppointment.getAppointmentID());
    throw new AppointmentNotFoundException("Appointment with ID " +
            updatedAppointment.getAppointmentID() + " not found.");
}


    /**
     * Delete an appointment from the DAO by its ID.
     *
     * @param id ID of the appointment to delete
     * @throws AppointmentNotFoundException if the appointment to delete is not found
     */
    public void deleteAppointment(String id) {
        LOGGER.info("Deleting appointment with ID: {}", id);
        if (Appointments.removeIf(appointment -> appointment.getAppointmentID().equals(id))) {
            LOGGER.info("Appointment with ID {} deleted.", id);
        } else {
            LOGGER.warn("Appointment with ID {} not found.", id);
            throw new AppointmentNotFoundException("Appointment with ID " + id + " not found.");
        }
    }
}

