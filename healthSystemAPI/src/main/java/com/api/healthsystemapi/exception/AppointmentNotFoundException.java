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
 * Custom exception class for handling appointment not found scenarios.
 * Extends RuntimeException for unchecked exception behavior.
 */
public class AppointmentNotFoundException extends RuntimeException {
    
    /**
     * Constructs an AppointmentNotFoundException with the specified message.
     *
     * @param message the detail message
     */
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
