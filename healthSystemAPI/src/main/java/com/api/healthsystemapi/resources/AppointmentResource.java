/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Appointment;
import com.api.healthsystemapi.dao.AppointmentDAO;
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
 * Resource class for handling Appointment-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting appointments.
 * Endpoints support JSON format for data exchange.
 */
@Path("/appointments")
public class AppointmentResource {
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    /**
     * Retrieve all appointments.
     * 
     * @return List of all appointments
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    
    /**
     * Get appointment by appointment ID.
     * 
     * @param appointmentID The appointment ID
     * @return Appointment object
     */
    @GET
    @Path("/byID/{AppointmentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getByAppointmentID(@PathParam("AppointmentID") String appointmentID) {
        return appointmentDAO.getAppointmentByID(appointmentID);
    }
    
    
    /**
     * Get appointments by patient ID.
     * 
     * @param patientID The patient ID
     * @return List of appointments for the specified patient
     */
    @GET
    @Path("/byPatient/{PatientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointmentsByPatient(@PathParam("PatientID") String patientID) {
        return appointmentDAO.getAppointmentsByPatientID(patientID);
    }
    
    
    /**
     * Get appointments by doctor ID.
     * 
     * @param doctorID The doctor ID
     * @return List of appointments for the specified doctor
     */
    @GET
    @Path("/byDoctor/{DoctorID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointmentsByDoctor(@PathParam("DoctorID") String DoctorID) {
        return appointmentDAO.getAppointmentsByDoctorID(DoctorID);
    }
    
    
    /**
     * Add a new appointment.
     * 
     * @param appointment The appointment to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
    }
    
    
    /**
     * Update an existing appointment.
     * 
     * @param appointmentID The ID of the appointment to update
     * @param updatedAppointment The updated appointment object
     */
    @PUT
    @Path("/{AppointmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("AppointmentID") String appointmentID, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentDAO.getAppointmentByID(appointmentID);

        if (existingAppointment != null) {
            appointmentDAO.updateAppointment(updatedAppointment);
        }
    }
    
    
    /**
     * Delete an appointment by appointment ID.
     * 
     * @param appointmentID The ID of the appointment to delete
     */
    @DELETE
    @Path("/{AppointmentID}")
    public void deleteAppointment(@PathParam("AppointmentID") String appointmentID) {
        appointmentDAO.deleteAppointment(appointmentID);
    }
}

