package com.empresas.fullstackbackend.controller;

import com.empresas.fullstackbackend.exception.EmpresaNotFoundException;

import com.empresas.fullstackbackend.model.Empresa;
import com.empresas.fullstackbackend.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping("/empresa")
    Empresa newEmpresa(@RequestBody Empresa newEmpresa) {
        return empresaRepository.save(newEmpresa);
    }

    @GetMapping("/empresas")
    List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/empresa/{id}")
    Empresa getEmpresaById(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    @PutMapping("/empresa/{id}")
    Empresa updateEmpresa(@RequestBody Empresa newEmpresa, @PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setRut(newEmpresa.getRut());
                    empresa.setRazonSocial (newEmpresa.getRazonSocial());
                    empresa.setFechaInsercion(newEmpresa.getFechaInsercion());
                    return empresaRepository.save(empresa);
                }).orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    @DeleteMapping("/empresa/{id}")
    String deleteEmpresa(@PathVariable Long id){
        if(!empresaRepository.existsById(id)){
            throw new EmpresaNotFoundException(id);
        }
        empresaRepository.deleteById(id);
        return  "Empresa with id "+id+" has been deleted success.";
    }



}
