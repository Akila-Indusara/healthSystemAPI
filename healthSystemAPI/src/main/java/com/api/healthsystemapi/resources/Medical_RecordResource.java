/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Medical_Record;
import com.api.healthsystemapi.dao.Medical_RecordDAO;
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
 * Resource class for handling Medical_Record-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting medical records.
 * Endpoints support JSON format for data exchange.
 */
@Path("/medical_records")
public class Medical_RecordResource {
    private static final Medical_RecordDAO Medical_RecordDAO = new Medical_RecordDAO();
    private static final PatientDAO patientDAO = new PatientDAO();
    
    /**
     * Retrieve all medical records.
     * 
     * @return List of all medical records
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medical_Record> getAllPeople() {
        return Medical_RecordDAO.getAllMedical_Records();
    }
    
    /**
     * Get medical record by record ID.
     * 
     * @param recordID The record ID
     * @return Medical_Record object
     */
    @GET
    @Path("/{RecordID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medical_Record getRecordByID(@PathParam("RecordID") String recordID) {
        return Medical_RecordDAO.getRecordByID(recordID);
    }
    
    /**
     * Get medical record by patient ID.
     * 
     * @param patientID The patient ID
     * @return Medical_Record object
     */
    @GET
    @Path("/byPatient/{PatientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medical_Record getRecordByPatientID(@PathParam("PatientID") String patientID) {
        return Medical_RecordDAO.getRecordByPatientID(patientID);
    }
    
    /**
     * Add a new medical record.
     * 
     * @param patientID The patient ID
     * @param medical_Record The medical record to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{PatientID}")
    public void addMedical_Record(@PathParam("PatientID") String patientID, Medical_Record medical_Record) {
        Medical_RecordDAO.addMedical_Record(medical_Record);
        patientDAO.getPatientByID(patientID).setMedical_record(medical_Record);
    }
    
    /**
     * Update an existing medical record.
     * 
     * @param patientID The patient ID
     * @param updatedMedical_Record The updated medical record object
     */
    @PUT
    @Path("/{PatientID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMedical_Record(@PathParam("PatientID") String patientID, Medical_Record updatedMedical_Record) {
        Medical_Record existingMedical_Record = Medical_RecordDAO.getRecordByPatientID(patientID);

        if (existingMedical_Record != null) {
            Medical_RecordDAO.updateMedical_Record(updatedMedical_Record);
        }
    }
    
    /**
     * Delete a medical record by patient ID.
     * 
     * @param patientID The patient ID
     */
    @DELETE
    @Path("/{PatientID}")
    public void deleteMedical_Record(@PathParam("PatientID") String patientID) {
        Medical_RecordDAO.deleteMedical_Record(patientID);
    }
}

