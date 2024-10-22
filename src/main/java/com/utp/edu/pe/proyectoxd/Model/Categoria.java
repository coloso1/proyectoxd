package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private Long id;             // Identificador de la categoría
    private String nombre;       // Nombre de la categoría
    private String descripcion;  // Descripción de la categoría
}
