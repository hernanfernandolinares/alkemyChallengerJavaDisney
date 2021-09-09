package com.disney.disney.Repository;

import com.disney.disney.Entity.PeliculaSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadPoolExecutor;
@Repository
public interface PeliculaSerieRepository extends CrudRepository<PeliculaSerie, Long> {

}



