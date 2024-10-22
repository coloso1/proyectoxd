package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {
    private long IdMetodoPago;  // Cambié a minúscula para seguir las convenciones de nombres en Java
    private String nombre;
    private String descripcion;


}
