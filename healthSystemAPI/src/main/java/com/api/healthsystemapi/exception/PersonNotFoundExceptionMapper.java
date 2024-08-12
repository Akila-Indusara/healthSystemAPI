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
 * Exception mapper class for handling PersonNotFoundException.
 * Maps PersonNotFoundException to an appropriate HTTP response.
 */
@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonNotFoundExceptionMapper.class);

    /**
     * Maps PersonNotFoundException to a HTTP response.
     * 
     * @param exception The PersonNotFoundException to be handled
     * @return Response representing the error status and message
     */
    @Override
    public Response toResponse(PersonNotFoundException exception) {
        LOGGER.error("Person Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
