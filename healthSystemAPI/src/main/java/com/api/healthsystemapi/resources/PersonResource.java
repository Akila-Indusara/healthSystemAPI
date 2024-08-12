/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.resources;

import com.api.healthsystemapi.Person;
import com.api.healthsystemapi.dao.PersonDAO;
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
 * Resource class for handling Person-related endpoints.
 * This class provides endpoints for retrieving, adding, updating, and deleting people (persons).
 * Endpoints support JSON format for data exchange.
 */
@Path("/people")
public class PersonResource {
    private final PersonDAO personDAO = new PersonDAO();
    
    /**
     * Retrieve all people.
     * 
     * @return List of all people
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }
    
    /**
     * Get person by ID.
     * 
     * @param personID The person ID
     * @return Person object
     */
    @GET
    @Path("/byID/{PersonID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByID(@PathParam("PersonID") String personID) {
        return personDAO.getPersonByID(personID);
    }
    
    /**
     * Get person by name.
     * 
     * @param personName The person name
     * @return Person object
     */
    @GET
    @Path("/byName/{PersonName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByName(@PathParam("PersonName") String personName) {
        return personDAO.getPersonByName(personName);
    }
    
    /**
     * Add a new person.
     * 
     * @param person The person to add
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }
    
    /**
     * Update an existing person.
     * 
     * @param personID The person ID
     * @param updatedPerson The updated person object
     */
    @PUT
    @Path("/{PersonID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("PersonID") String personID, Person updatedPerson) {
        Person existingPerson = personDAO.getPersonByID(personID);

        if (existingPerson != null) {
            personDAO.updatePerson(updatedPerson);
        }
    }
    
    /**
     * Delete a person by ID.
     * 
     * @param personID The person ID
     */
    @DELETE
    @Path("/{PersonID}")
    public void deletePerson(@PathParam("PersonID") String personID) {
        personDAO.deletePerson(personID);
    }
}

