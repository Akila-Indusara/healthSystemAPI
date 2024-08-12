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
 * Exception mapper for handling BillingNotFoundException in the REST API.
 * Maps BillingNotFoundException to a HTTP 404 Not Found response.
 * Logs the exception details using SLF4J.
 */
@Provider
public class BillingNotFoundExceptionMapper implements ExceptionMapper<BillingNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(BillingNotFoundException exception) {
        LOGGER.error("Billing Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}

