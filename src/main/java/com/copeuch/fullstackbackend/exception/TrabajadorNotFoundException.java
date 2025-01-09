package com.copeuch.fullstackbackend.exception;



public class TrabajadorNotFoundException extends RuntimeException{
    public TrabajadorNotFoundException(Long id){
        super("Could not found the Trabajador with id "+ id);
    }
}