package com.disney.disney.Service;

import com.disney.disney.Dtos.PersonajeRequest;
import com.disney.disney.Entity.Personaje;
import com.disney.disney.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PersonajeService {
    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(personajeRepository.findAll());
    }

    public ResponseEntity<?> deleteById(Long id){
         var personaje= findById(id);
         if (personaje!=null){
             personajeRepository.deleteById(id);
             return ResponseEntity.ok(personaje);
         }else{
             return new ResponseEntity<>("personaje no encontrado", HttpStatus.NOT_FOUND);
         }
    }
    public Personaje findPersonaje(Long id){
        return personajeRepository.findById(id).orElse(null);
    }
    public ResponseEntity<?> findById(Long id){
        var personaje= findPersonaje(id);
        if(personaje!=null){
            return ResponseEntity.ok(personaje);
        }else{
            return new ResponseEntity<>("personaje no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> updateById(Long id, PersonajeRequest request){
        var personaje = findPersonaje(id);
        if(personaje!=null){
            if(request.getNombre()!=null){
                personaje.setNombre(request.getNombre());
            }
            if(request.getEdad()!=null){
                personaje.setEdad(request.getEdad());
            }
            if (request.getHistoria()!=null){
                personaje.setHistoria(request.getHistoria());
            }
            if(request.getImagen()!=null){
                personaje.setImagen(request.getImagen());
            }
            if (request.getPeso()!=null){
                personaje.setPeso(request.getPeso());
            }
            if(request.getUserName()!=null){
                personaje.setUserName(request.getUserName());
            }
            if(request.getPass()!=null){
                personaje.setPass(request.getPass());
            }
            return ResponseEntity.ok(personajeRepository.save(personaje));
        }
        return new ResponseEntity<>("El personaje un existe",HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> save(PersonajeRequest request){
      var personaje = personajeRepository.save(
              new Personaje(
                      request.getUserName(),
                      request.getNombre(),
                      request.getPass(),
                      request.getEdad(),
                      request.getPeso(),
                      request.getHistoria(),
                      request.getImagen()
              )
      );
      return new ResponseEntity<>(personaje, HttpStatus.CREATED);
    }

    public ResponseEntity<?> findByNombre(
            @RequestParam(name="nombre")String nombre){
                if(nombre!=null){
                    return new ResponseEntity<>(personajeRepository.findByNombreContaining(nombre),HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("el personaje buscando no existe",HttpStatus.NOT_FOUND);
                }
    }
    public ResponseEntity<?> findByEdad(
            @RequestParam(name="edad")Integer edad){
        if(edad!=null){
            return new ResponseEntity<>(personajeRepository.findByEdad(edad),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("el personaje buscando no existe",HttpStatus.NOT_FOUND);
        }
}


}



