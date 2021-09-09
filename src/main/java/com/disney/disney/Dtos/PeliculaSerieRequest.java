package com.disney.disney.Dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.File;
import java.time.LocalDateTime;
@Data
public class PeliculaSerieRequest {
    private String titulo;
    private File imagen;
    private LocalDateTime fechaCreacion;
    @Min(value = 1)
    @Max(value = 5)
    private int calificaciones;
}
