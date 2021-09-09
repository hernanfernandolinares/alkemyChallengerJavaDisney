package com.disney.disney.Controller;

import com.disney.disney.Dtos.PersonajeRequest;
import com.disney.disney.Entity.Personaje;
import com.disney.disney.Repository.PersonajeRepository;
import com.disney.disney.Service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/characters")
public class PersonajeController {
    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {

        this.personajeService = personajeService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody PersonajeRequest nuevo) {
        return new ResponseEntity<>(personajeService.save(nuevo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(required = false)Integer edad,
            @RequestParam(required = false)String nombre){
        if(edad!=null){
            return personajeService.findByEdad(edad);
        }
        if (nombre!=null){
            return personajeService.findByNombre(nombre);
        }
        return personajeService.findAll();



    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")Long id) {
        return personajeService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")Long id){
        return personajeService.deleteById(id);
    }

    @PutMapping(value ={"/{id}"})
    @ResponseBody
    public ResponseEntity<?> updateById(@RequestBody PersonajeRequest personaje,
                                        @PathVariable("id")Long id){
        return personajeService.updateById(id, personaje);
    }

}
