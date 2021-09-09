package com.disney.disney.Repository;

import com.disney.disney.Entity.Personaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
    Iterable<?> findByNombreContaining(String nombre);
    Iterable<?> findByEdad(Integer edad);

}
