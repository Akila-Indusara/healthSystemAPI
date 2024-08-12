/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Patient;
import com.api.healthsystemapi.dao.PatientDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Akila
 */

/**
 * Resource class for handling Patient-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting patients.
 * Endpoints support JSON format for data exchange.
 */
@Path("/patients")
public class PatientResource {
    private final PatientDAO patientDAO = new PatientDAO();
    
    /**
     * Retrieve all patients.
     * 
     * @return List of all patients
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPeople() {
        return patientDAO.getAllPatients();
    }
    
    /**
     * Get patient by ID.
     * 
     * @param patientID The patient ID
     * @return Patient object
     */
    @GET
    @Path("/byID/{PatientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientByID(@PathParam("PatientID") String patientID) {
        return patientDAO.getPatientByID(patientID);
    }
    
    /**
     * Get patient by name.
     * 
     * @param patientName The patient name
     * @return Patient object
     */
    @GET
    @Path("/byName/{PatientName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientByName(@PathParam("PatientName") String patientName) {
        return patientDAO.getPatientByName(patientName);
    }
    
    /**
     * Add a new patient.
     * 
     * @param patient The patient to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }
    
    /**
     * Update an existing patient.
     * 
     * @param patientID The patient ID
     * @param updatedPatient The updated patient object
     */
    @PUT
    @Path("/{PatientID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("PatientID") String patientID, Patient updatedPatient) {
        Patient existingPatient = patientDAO.getPatientByID(patientID);

        if (existingPatient != null) {
            patientDAO.updatePatient(updatedPatient);
        }
    }
    
    /**
     * Delete a patient by ID.
     * 
     * @param patientID The patient ID
     */
    @DELETE
    @Path("/{PatientID}")
    public void deletePatient(@PathParam("PatientID") String patientID) {
        patientDAO.deletePatient(patientID);
    }
}

