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
 * Exception indicating that a medical record was not found.
 * It extends RuntimeException.
 */
public class Medical_RecordNotFoundException extends RuntimeException {
    public Medical_RecordNotFoundException(String message) {
        super(message);
    }
}

