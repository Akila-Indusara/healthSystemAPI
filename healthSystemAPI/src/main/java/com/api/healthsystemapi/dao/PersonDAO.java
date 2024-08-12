/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.dao;

import com.api.healthsystemapi.Person;
import com.api.healthsystemapi.exception.DataAlreadyExistException;
import com.api.healthsystemapi.exception.IdAlreadyExistException;
import com.api.healthsystemapi.exception.PersonNotFoundException;
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
 * PersonDAO class provides data access operations for people in the system.
 * It manages the storage, retrieval, update, and deletion of person records.
 * It also provides methods to fetch people by ID and name.
 * The class maintains a list of people and provides methods to interact with this list.
 */
public class PersonDAO {
    private static final List<Person> People = new ArrayList<>();
     
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

    /**
     * Get all people.
     *
     * @return List of people
     * @throws PersonNotFoundException if no people are found
     */
    public List<Person> getAllPeople() {
        LOGGER.info("Fetching all people.");
        if (People.isEmpty()) {
            LOGGER.warn("No people found.");
            throw new PersonNotFoundException("People not found.");
        } else {
            LOGGER.info("Retrieved {} people.", People.size());
            return Collections.unmodifiableList(People);
        }
    }

    /**
     * Get person by ID.
     *
     * @param ID Person ID
     * @return Person
     * @throws PersonNotFoundException if person with the given ID is not found
     */
    public Person getPersonByID(String ID) {
        LOGGER.info("Fetching person by ID: {}", ID);
        for (Person person : People) {
            if (person.getID().equals(ID)) {
                return person;
            }
        }
        LOGGER.warn("Person with ID {} not found.", ID);
        throw new PersonNotFoundException("Person with ID " + ID + " not found.");
    }

    /**
     * Get person by name.
     *
     * @param name Person name
     * @return Person
     * @throws PersonNotFoundException if person with the given name is not found
     */
    public Person getPersonByName(String name) {
        LOGGER.info("Fetching person by name: {}", name);
        for (Person person : People) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        LOGGER.warn("Person with name {} not found.", name);
        throw new PersonNotFoundException("Person " + name + " not found.");
    }

    /**
    * Add a new person.
    *
    * @param person Person to add
    */
   public void addPerson(Person person) {
       checkExsistance(person);

       LOGGER.info("Adding new person: {}", person);
       People.add(person);
   }

   /**
    * Check the existence of a person ID and person data.
    *
    * @param person The person to check
    * @throws IdAlreadyExistException if the person ID already exists
    * @throws DataAlreadyExistException if the person data already exists
    */
   private void checkExsistance(Person person){
       // Check if person ID already exists or if person data already exists
       for (Person p : People) {
           if (p.getID().equals(person.getID())) {
               LOGGER.warn("Person with ID {} already exists while adding person: {}", person.getID(), person);
               throw new IdAlreadyExistException("ID " + person.getID() + " already exists.");
           } else if (p.getName().equals(person.getName()) &&
                   p.getAge() == person.getAge() &&
                   p.getContactNumber() == person.getContactNumber() &&
                   p.getAddress().equals(person.getAddress())) {
               LOGGER.warn("Person data already exists while adding person: {}", person);
               throw new DataAlreadyExistException("Data already exists with ID " + p.getID());
           }
       }
   }

   /**
    * Update an existing person.
    *
    * @param updatedPerson Updated person
    * @throws PersonNotFoundException if person with the updated person's ID is not found
    */
   public void updatePerson(Person updatedPerson) {
       LOGGER.info("Updating person with ID: {}", updatedPerson.getID());
       for (int i = 0; i < People.size(); i++) {
           Person person = People.get(i);
           if (person.getID().equals(updatedPerson.getID())) {
               People.set(i, updatedPerson);
               LOGGER.info("Person updated: {}", updatedPerson);
               return;
           }
       }
       LOGGER.warn("Person with ID {} not found for update.", updatedPerson.getID());
       throw new PersonNotFoundException("Person with ID " + updatedPerson.getID() + " not found.");
   }


    /**
     * Delete a person by ID.
     *
     * @param id ID of the person to delete
     * @throws PersonNotFoundException if person with the given ID is not found for deletion
     */
    public void deletePerson(String id) {
        LOGGER.info("Deleting person with ID: {}", id);
        if (People.removeIf(person -> person.getID().equals(id))) {
            LOGGER.info("Person deleted with ID: {}", id);
        } else {
            LOGGER.warn("Person with ID {} not found for deletion.", id);
            throw new PersonNotFoundException("Person with ID " + id + " not found.");
        }
    }
}

