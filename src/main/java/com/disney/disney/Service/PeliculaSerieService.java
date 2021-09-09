package com.disney.disney.Service;

import com.disney.disney.Dtos.PeliculaSerieRequest;
import com.disney.disney.Dtos.PersonajeRequest;
import com.disney.disney.Entity.PeliculaSerie;
import com.disney.disney.Entity.Personaje;
import com.disney.disney.Repository.PeliculaSerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PeliculaSerieService {
    private final PeliculaSerieRepository peliculaSerieRepository;

    public PeliculaSerieService(PeliculaSerieRepository peliculaSerieRepository) {
        this.peliculaSerieRepository = peliculaSerieRepository;
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(peliculaSerieRepository.findAll());
    }
    public ResponseEntity<?> crearPeliculaSerie(PeliculaSerieRequest request){
        var peli = peliculaSerieRepository.save(
                new PeliculaSerie(
                        request.getTitulo(),
                        request.getImagen(),
                        request.getFechaCreacion(),
                        request.getCalificaciones()
                )
        );
        return new ResponseEntity<>(peli, HttpStatus.CREATED);
    }
    public ResponseEntity<?> updateById(Long id, PeliculaSerieRequest request){
        var peli = findPeliculaserie(id);
        if(peli!=null){
            if(request.getTitulo()!=null){
                peli.setTitulo(request.getTitulo());
            }
            if(request.getImagen()!=null){
                peli.setImagen(request.getImagen());
            }
            if(request.getFechaCreacion()!=null){
                peli.setFechaCreacion(request.getFechaCreacion());
            }
            if(request.getCalificaciones()==1||request.getCalificaciones()==2||request.getCalificaciones()==3
                    ||request.getCalificaciones()==4||request.getCalificaciones()==5){
                peli.setCalificacion(request.getCalificaciones());
            }
            return ResponseEntity.ok(peliculaSerieRepository.save(peli));
        }
        return new ResponseEntity<>("El personaje un existe",HttpStatus.NOT_FOUND);
    }

    private PeliculaSerie findPeliculaserie(Long id) {
        return peliculaSerieRepository.findById(id).orElse(null);

    }
}