package com.disney.disney.Dtos;
import com.disney.disney.Entity.PeliculaSerie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class PersonajeRequest {
    private String userName;
    private String pass;
    private String nombre;
    private Integer edad;
    private BigDecimal peso;
    private String historia;
    private File imagen;
    private PeliculaSerie peliculaSerie;
    private List<PeliculaSerie> peliculaSeries;

    public PersonajeRequest(Long id, String userName, String pass, String nombre, Integer edad, BigDecimal peso, String historia, File imagen, PeliculaSerie peliculaSerie, List<PeliculaSerie> peliculaSeries) {
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
}
