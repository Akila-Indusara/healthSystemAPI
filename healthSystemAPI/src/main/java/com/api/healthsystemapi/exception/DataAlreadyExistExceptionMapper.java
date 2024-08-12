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
 * Exception mapper for DataAlreadyExistException.
 * Maps DataAlreadyExistException to an appropriate HTTP response.
 */
@Provider
public class DataAlreadyExistExceptionMapper implements ExceptionMapper<DataAlreadyExistException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataAlreadyExistException.class);

    /**
     * Maps DataAlreadyExistException to an HTTP response.
     *
     * @param exception The DataAlreadyExistException instance
     * @return An HTTP response indicating the error
     */
    @Override
    public Response toResponse(DataAlreadyExistException exception) {
        LOGGER.error("Data Already Exists.", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
