package com.disney.disney.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Data
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private File imagen;
    //peliculas y series asociadas
    @OneToMany(mappedBy = "genero")
    private List<PeliculaSerie> peliculaSeries;
    @ManyToOne
    private PeliculaSerie peliculaSerie;
}
