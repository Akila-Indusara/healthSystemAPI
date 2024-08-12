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
 * Custom exception for cases where data already exists.
 */
public class DataAlreadyExistException extends RuntimeException {
    /**
     * Constructs a new DataAlreadyExistException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method)
     */
    public DataAlreadyExistException(String message) {
        super(message); // Call the constructor of the superclass (RuntimeException) with the specified message
    }
}

