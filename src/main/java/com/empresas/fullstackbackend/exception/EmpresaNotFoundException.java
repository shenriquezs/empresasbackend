package com.empresas.fullstackbackend.exception;


public class EmpresaNotFoundException extends RuntimeException{
    public EmpresaNotFoundException(Long id){
        super("Could not found the Empresa with id "+ id);
    }
}
