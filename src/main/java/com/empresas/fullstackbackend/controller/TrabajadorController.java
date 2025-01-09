package com.empresas.fullstackbackend.controller;


import com.empresas.fullstackbackend.exception.TrabajadorNotFoundException;
import com.empresas.fullstackbackend.repository.TrabajadorRepository;
import com.empresas.fullstackbackend.model.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class TrabajadorController {

    @Autowired
    private TrabajadorRepository trabajadorRepository;


    @PostMapping("/trabajador")
    Trabajador newTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @GetMapping("/trabajadores")
    List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    @GetMapping("/trabajador/{id}")
    Trabajador getTrabajadorById(@PathVariable Long id) {
        return trabajadorRepository.findById(id)
                .orElseThrow(() -> new TrabajadorNotFoundException(id));
    }

    @PutMapping("/trabajador/{id}")
    Trabajador updateTrabajador(@RequestBody Trabajador newTrabajador, @PathVariable Long id) {
        return trabajadorRepository.findById(id)
                .map(  trabajador -> {
                    trabajador.setRut(newTrabajador.getRut());
                    trabajador.setNombre (newTrabajador.getNombre());
                    trabajador.setApellidoPaterno(newTrabajador.getApellidoPaterno());
                    trabajador.setApellidoMaterno(newTrabajador.getApellidoMaterno());
                    trabajador.setDireccion(newTrabajador.getDireccion());
                    trabajador.setEmpresa(newTrabajador.getEmpresa());
                    return trabajadorRepository.save(trabajador);
                }).orElseThrow(() -> new TrabajadorNotFoundException(id));
    }

    @DeleteMapping("/trabajador/{id}")
    String deleteTrabajador(@PathVariable Long id){
        if(!trabajadorRepository.existsById(id)){
            throw new TrabajadorNotFoundException(id);
        }
        trabajadorRepository.deleteById(id);
        return  "Trabajador with id "+id+" has been deleted success.";
    }


}
