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
 * Custom exception class for handling cases where a doctor is not found in the system.
 * Extends RuntimeException for unchecked exception behavior.
 */
public class DoctorNotFoundException extends RuntimeException {
    /**
     * Constructs a new DoctorNotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public DoctorNotFoundException(String message) {
        super(message);
    }
}

