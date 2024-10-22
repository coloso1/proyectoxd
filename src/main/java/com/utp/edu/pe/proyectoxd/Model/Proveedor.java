package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.security.interfaces.DSAKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
private  long CodProveedor;
private String nombre;
private String direccion;
private String contacto;

}
