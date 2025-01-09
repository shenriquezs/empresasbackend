package com.empresas.fullstackbackend.repository;

import com.empresas.fullstackbackend.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Long> {
}
