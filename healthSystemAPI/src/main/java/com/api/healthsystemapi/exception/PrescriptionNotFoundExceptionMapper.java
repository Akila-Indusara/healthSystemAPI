/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Exception mapper class for handling PrescriptionNotFoundException.
 * This mapper converts the exception into an HTTP response with status 404 (Not Found).
 * It also logs the exception details using SLF4J logger.
 */
public class PrescriptionNotFoundExceptionMapper implements ExceptionMapper<PrescriptionNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionNotFoundException.class);

    /**
     * Converts the exception into an HTTP response with status 404 (Not Found).
     * Logs the exception details using SLF4J logger.
     * 
     * @param exception The PrescriptionNotFoundException instance
     * @return Response with status 404 and the exception message as entity
     */
    @Override
    public Response toResponse(PrescriptionNotFoundException exception) {
        LOGGER.error("Prescription Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}

