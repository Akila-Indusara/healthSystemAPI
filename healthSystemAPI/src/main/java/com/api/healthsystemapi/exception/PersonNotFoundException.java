/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.exception;

/**
 *
 * @author Akila
 */

/**
 * Exception class for handling Person not found scenarios.
 * Extends RuntimeException to represent unchecked exceptions. 
 */
public class PersonNotFoundException extends RuntimeException {
    /**
     * Constructs a new PersonNotFoundException with the specified detail message.
     * 
     * @param message The detail message
     */
    public PersonNotFoundException(String message) {
        super(message);
    }
}
