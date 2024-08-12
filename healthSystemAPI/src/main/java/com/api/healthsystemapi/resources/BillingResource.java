/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Billing;
import com.api.healthsystemapi.dao.BillingDAO;
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
 * Resource class for handling Billing-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting billings.
 * Endpoints support JSON format for data exchange.
 */
@Path("/billing")
public class BillingResource {
    private final BillingDAO BillingDAO = new BillingDAO();

    /**
     * Retrieve all billings.
     * 
     * @return List of all billings
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        return BillingDAO.getAllBillings();
    }
    
    /**
     * Get billing by billing ID.
     * 
     * @param billingID The billing ID
     * @return Billing object
     */
    @GET
    @Path("/byID/{BillingID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getByBillingID(@PathParam("BillingID") String billingID) {
        return BillingDAO.getBillingByID(billingID);
    }
    
    
    /**
     * Get billings by patient ID.
     * 
     * @param patientID The patient ID
     * @return List of billings for the specified patient
     */
    @GET
    @Path("/byPatient/{PatientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getBillingsByPatient(@PathParam("PatientID") String patientID) {
        return BillingDAO.getBillingsByPatientID(patientID);
    }
    
    
    /**
     * Get billings by doctor ID.
     * 
     * @param DoctorID The doctor ID
     * @return List of billings for the specified doctor
     */
    @GET
    @Path("/byDoctor/{DoctorID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getBillingsByDoctor(@PathParam("DoctorID") String DoctorID) {
        return BillingDAO.getBillingsByDoctorID(DoctorID);
    }
    
    
    /**
     * Add a new billing.
     * 
     * @param billing The billing to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBilling(Billing billing) {
        BillingDAO.addBilling(billing);
    }
    
    
    /**
     * Update an existing billing.
     * 
     * @param billingID The ID of the billing to update
     * @param updatedBilling The updated billing object
     */
    @PUT
    @Path("/{BillingID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBilling(@PathParam("BillingID") String billingID, Billing updatedBilling) {
        Billing existingBilling = BillingDAO.getBillingByID(billingID);

        if (existingBilling != null) {
            BillingDAO.updateBilling(updatedBilling);
        }
    }
    
    
    /**
     * Delete a billing by billing ID.
     * 
     * @param billingID The ID of the billing to delete
     */
    @DELETE
    @Path("/{BillingID}")
    public void deleteBilling(@PathParam("BillingID") String billingID) {
        BillingDAO.deleteBilling(billingID);
    }
}

