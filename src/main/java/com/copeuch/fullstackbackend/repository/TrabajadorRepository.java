package com.copeuch.fullstackbackend.repository;

import com.copeuch.fullstackbackend.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Long> {
}
