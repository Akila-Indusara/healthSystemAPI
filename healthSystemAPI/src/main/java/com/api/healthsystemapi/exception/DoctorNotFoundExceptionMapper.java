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
 * Exception mapper class for handling DoctorNotFoundException in the REST API.
 * It maps DoctorNotFoundException to an HTTP 404 response with a plain text entity.
 */
@Provider
public class DoctorNotFoundExceptionMapper implements ExceptionMapper<DoctorNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorNotFoundException.class);

    @Override
    public Response toResponse(DoctorNotFoundException exception) {
        LOGGER.error("Doctor Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}

