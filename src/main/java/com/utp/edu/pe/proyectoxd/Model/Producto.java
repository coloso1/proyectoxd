package com.utp.edu.pe.proyectoxd.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @NotNull
    private long IdProducto;
    @NotNull
    private Boolean Estado;
    @NotNull
    private Long IdCategoria;
    @NotNull
    private String Nombre;
    @NotNull
    private Float Precio;
    @NotNull
    private String Descripcion;
    @NotNull // Asegúrate de que el stock no pueda ser nulo
    private Integer Stock; // Agregar campo Stock
}
