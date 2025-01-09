package com.empresas.fullstackbackend.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Data
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rut;
    private String razonSocial;
    private String fechaInsercion;


    public Empresa() {

    }

    public Empresa(Long id, String rut, String razonSocial, String fechaInsercion) {
        this.id = id;
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.fechaInsercion = fechaInsercion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(String fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
}
