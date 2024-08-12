/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Doctor;
import com.api.healthsystemapi.dao.DoctorDAO;
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
 * Resource class for handling Doctor-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting doctors.
 * Endpoints support JSON format for data exchange.
 */
@Path("/doctors")
public class DoctorResource {
    private final DoctorDAO doctorDAO = new DoctorDAO();
    
    /**
     * Retrieve all doctors.
     * 
     * @return List of all doctors
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
    
    /**
     * Get doctor by doctor ID.
     * 
     * @param doctorID The doctor ID
     * @return Doctor object
     */
    @GET
    @Path("/byID/{DoctorID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorByID(@PathParam("DoctorID") String doctorID) {
        return doctorDAO.getDoctorByID(doctorID);
    }
    
    
    /**
     * Get doctor by doctor name.
     * 
     * @param doctorName The doctor name
     * @return Doctor object
     */
    @GET
    @Path("/byName/{DoctorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorByName(@PathParam("DoctorName") String doctorName) {
        return doctorDAO.getDoctorByName(doctorName);
    }
    
    /**
     * Get doctors by specialization.
     * 
     * @param specializationName The specialization name
     * @return List of doctors with the specified specialization
     */
    @GET
    @Path("/bySpecialization/{SpecializationName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getDoctorsBySpecialization(@PathParam("SpecializationName") String specializationName) {
        return doctorDAO.getDoctorsBySpecialization(specializationName);
    }
    
    /**
     * Get doctors by department.
     * 
     * @param departmentName The department name
     * @return List of doctors in the specified department
     */
    @GET
    @Path("/byDepartment/{DepartmentName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getDoctorsByDepartment(@PathParam("DepartmentName") String departmentName) {
        return doctorDAO.getDoctorsByDepartment(departmentName);
    }
    
    /**
     * Add a new doctor.
     * 
     * @param doctor The doctor to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }
    
    /**
     * Update an existing doctor.
     * 
     * @param doctorID The ID of the doctor to update
     * @param updatedDoctor The updated doctor object
     */
    @PUT
    @Path("/{DoctorID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("DoctorID") String doctorID, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorDAO.getDoctorByID(doctorID);

        if (existingDoctor != null) {
            doctorDAO.updateDoctor(updatedDoctor);
        }
    }
    
    /**
     * Delete a doctor by doctor ID.
     * 
     * @param doctorID The ID of the doctor to delete
     */
    @DELETE
    @Path("/{DoctorID}")
    public void deleteDoctor(@PathParam("DoctorID") String doctorID) {
        doctorDAO.deleteDoctor(doctorID);
    }
}

