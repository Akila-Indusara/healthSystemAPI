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
 * Exception indicating that a billing record was not found.
 * Extends RuntimeException to allow unchecked handling of this exception type.
 */
public class BillingNotFoundException extends RuntimeException {
    public BillingNotFoundException(String message) {
        super(message);
    }
}
