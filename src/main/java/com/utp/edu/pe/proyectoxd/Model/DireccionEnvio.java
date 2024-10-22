package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionEnvio {
    private long CodDireccionEnvio;
    private long CodUsuario;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
}
