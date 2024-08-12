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
 * Exception mapper for handling Medical_RecordNotFoundException.
 * It implements ExceptionMapper<Medical_RecordNotFoundException>.
 * Logs the error and returns a 404 NOT FOUND response with a plain text message.
 */
@Provider
public class Medical_RecordNotFoundExceptionMapper implements ExceptionMapper<Medical_RecordNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Medical_RecordNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(Medical_RecordNotFoundException exception) {
        LOGGER.error("Medical Record Not Found", exception.getMessage(), exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
