package com.empresas.fullstackbackend.repository;

import com.empresas.fullstackbackend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
