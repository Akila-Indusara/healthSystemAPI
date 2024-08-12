/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Prescription;
import com.api.healthsystemapi.dao.PrescriptionDAO;
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
 * Resource class for handling Prescription-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting prescriptions.
 * Endpoints support JSON format for data exchange.
 */
@Path("/prescriptions")
public class PrescriptionResource {
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    /**
     * Retrieve all prescriptions.
     * 
     * @return List of all prescriptions
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }
    
    /**
     * Get prescription by ID.
     * 
     * @param prescriptionID The prescription ID
     * @return Prescription object
     */
    @GET
    @Path("/byID/{PrescriptionID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getByPrescriptionID(@PathParam("PrescriptionID") String prescriptionID) {
        return prescriptionDAO.getPrescriptionByID(prescriptionID);
    }
    
    /**
     * Get prescriptions by patient ID.
     * 
     * @param patientID The patient ID
     * @return List of prescriptions related to the patient
     */
    @GET
    @Path("/byPatient/{PatientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getPrescriptionsByPatient(@PathParam("PatientID") String patientID) {
        return prescriptionDAO.getPrescriptionsByPatientID(patientID);
    }
    
    /**
     * Get prescriptions by doctor ID.
     * 
     * @param DoctorID The doctor ID
     * @return List of prescriptions related to the doctor
     */
    @GET
    @Path("/byDoctor/{DoctorID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getPrescriptionsByDoctor(@PathParam("DoctorID") String DoctorID) {
        return prescriptionDAO.getPrescriptionsByDoctorID(DoctorID);
    }
    
    /**
     * Add a new prescription.
     * 
     * @param prescription The prescription to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
    }
    
    /**
     * Update an existing prescription.
     * 
     * @param prescriptionID The prescription ID
     * @param updatedPrescription The updated prescription object
     */
    @PUT
    @Path("/{PrescriptionID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrescription(@PathParam("PrescriptionID") String prescriptionID, Prescription updatedPrescription) {
        Prescription existingPrescription = prescriptionDAO.getPrescriptionByID(prescriptionID);

        if (existingPrescription != null) {
            prescriptionDAO.updatePrescription(updatedPrescription);
        }
    }
    
    /**
     * Delete a prescription by ID.
     * 
     * @param prescriptionID The prescription ID
     */
    @DELETE
    @Path("/{PrescriptionID}")
    public void deletePrescription(@PathParam("PrescriptionID") String prescriptionID) {
        prescriptionDAO.deletePrescription(prescriptionID);
    }
}

