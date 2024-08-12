/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.healthsystemapi.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akila
 */

/**
 * Exception mapper class for handling PatientNotFoundException.
 * Maps the exception to a HTTP response with status NOT_FOUND (404).
 * Logs the exception details using SLF4J logger.
 */
@Provider
public class PatientNotFoundExceptionMapper implements ExceptionMapper<PatientNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientNotFoundExceptionMapper.class);

    /**
     * Maps the PatientNotFoundException to a HTTP response.
     * 
     * @param exception The exception to be mapped
     * @return Response containing the error message and status NOT_FOUND
     */
    @Override
    public Response toResponse(PatientNotFoundException exception) {
        LOGGER.error("Patient Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}

