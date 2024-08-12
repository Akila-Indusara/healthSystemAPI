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
 * Custom exception class for handling PatientNotFoundException.
 * Extends RuntimeException for unchecked exception handling.
 */
public class PatientNotFoundException extends RuntimeException {
    /**
     * Constructs a new PatientNotFoundException with the specified detail message.
     * 
     * @param message The detail message
     */
    public PatientNotFoundException(String message) {
        super(message);
    }
}

