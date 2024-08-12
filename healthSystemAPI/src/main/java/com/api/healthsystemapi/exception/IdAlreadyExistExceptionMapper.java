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
 * Exception mapper for handling IdAlreadyExistException and providing appropriate responses.
 */
@Provider
public class IdAlreadyExistExceptionMapper implements ExceptionMapper<IdAlreadyExistException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdAlreadyExistExceptionMapper.class);

    /**
     * Maps the IdAlreadyExistException to a Response object with error status and message.
     *
     * @param exception The IdAlreadyExistException instance
     * @return Response object with error status and message
     */
    @Override
    public Response toResponse(IdAlreadyExistException exception) {
        LOGGER.error("ID Already Exists.", exception); // Log the exception with an error message and stack trace

        // Build and return a Response with error status and message
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}

