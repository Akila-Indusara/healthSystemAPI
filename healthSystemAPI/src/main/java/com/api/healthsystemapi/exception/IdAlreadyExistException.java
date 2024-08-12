/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Custom exception class for ID already exists scenario.
 */
public class IdAlreadyExistException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdAlreadyExistException.class);

    /**
     * Constructs a new IdAlreadyExistException with the specified detail message.
     *
     * @param message The detail message
     */
    public IdAlreadyExistException(String message) {
        super(message);
        LOGGER.error("IdAlreadyExistException occurred: {}", message);
    }
}
