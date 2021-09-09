package com.disney.disney.Entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class PeliculaSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private File imagen;
    private LocalDateTime fechaCreacion;
    @Min(value = 1)
    @Max(value = 5)
    private int calificacion;
    //personajes asociados
    @ManyToOne
    private Personaje personaje;
    @OneToMany(mappedBy = "peliculaSerie",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Personaje> personajes;
    @ManyToOne
    private Genero genero;
    @OneToMany(mappedBy = "peliculaSerie")
    private List<Genero> generos;
    public PeliculaSerie(String titulo, File imagen, LocalDateTime fechaCreacion, int calificaciones) {
    }
}
