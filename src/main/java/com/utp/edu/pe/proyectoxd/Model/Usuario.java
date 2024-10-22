package com.utp.edu.pe.proyectoxd.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private long CodUsuario;
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String rol;

}
