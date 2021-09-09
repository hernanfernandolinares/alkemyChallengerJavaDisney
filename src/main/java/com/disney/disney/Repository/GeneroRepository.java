package com.disney.disney.Repository;

import com.disney.disney.Entity.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {
}
