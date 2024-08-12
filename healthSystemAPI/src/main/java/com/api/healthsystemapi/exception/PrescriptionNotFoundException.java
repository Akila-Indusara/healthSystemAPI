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
 * Custom exception class for handling cases where a prescription is not found.
 * Extends RuntimeException to indicate unchecked exceptions.
 */
public class PrescriptionNotFoundException extends RuntimeException {
    /**
     * Constructs a new PrescriptionNotFoundException with the specified detail message.
     * 
     * @param message The detail message
     */
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}

