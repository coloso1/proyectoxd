package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioValoracion {
    private long CodComentarioEvaluacion;
    private long Producto;
    private long CodUsuario;
    private String texto;
    private int calificacion;
}
