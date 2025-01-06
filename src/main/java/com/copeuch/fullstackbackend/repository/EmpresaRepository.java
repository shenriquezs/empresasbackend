package com.copeuch.fullstackbackend.repository;

import com.copeuch.fullstackbackend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
