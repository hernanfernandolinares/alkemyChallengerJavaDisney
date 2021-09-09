package com.disney.disney.Entity;

import com.disney.disney.Dtos.PersonajeRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String pass;
    private String nombre;
    private Integer edad;
    private BigDecimal peso;
    private String historia;
    private File imagen;
    @ManyToOne
    @JsonIgnore
    private PeliculaSerie peliculaSerie;
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<PeliculaSerie> peliculaSeries;

    public Personaje(Long id, String userName, String pass, String nombre, Integer edad, BigDecimal peso, String historia, File imagen, PeliculaSerie peliculaSerie, List<PeliculaSerie> peliculaSeries) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.imagen = imagen;
        this.peliculaSerie = peliculaSerie;
        this.peliculaSeries = peliculaSeries;
    }

    public Personaje(String userName, String nombre, String pass, Integer edad, BigDecimal peso, String historia, File imagen) {
        this.userName = userName;
        this.pass = pass;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.imagen = imagen;
    }
    public Personaje(){

    }

}
