package com.copeuch.fullstackbackend.exception;
/* Created by Arjun Gautam */

public class EmpresaNotFoundException extends RuntimeException{
    public EmpresaNotFoundException(Long id){
        super("Could not found the Empresa with id "+ id);
    }
}
