/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Person class represents a person in the healthcare system.
 */
public class Person {
    private String ID;  // Unique ID for each person
    private String name;  // Name of the person
    private int age;  // Age of the person
    private int contactNumber;  // Contact number of the person
    private String address;  // Address of the person
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);  // Logger for logging person creation
    
    /**
     * Default constructor for Person class.
     */
    public Person() {
    }
    
    /**
     * Constructor for Person class with parameters.
     * 
     * @param ID Unique ID for the person
     * @param name Name of the person
     * @param age Age of the person
     * @param contactNumber Contact number of the person
     * @param address Address of the person
     */
    public Person(String ID, String name, int age, int contactNumber, String address) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
        LOGGER.info("New Person created: {}", ID);  // Log the creation of a new person
    }

    // Getters
    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getContactNumber() {
        return contactNumber;
    }
    public String getAddress() {
        return address;
    }
    
    // Setters
    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

