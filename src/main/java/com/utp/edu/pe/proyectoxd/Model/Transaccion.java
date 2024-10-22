package com.utp.edu.pe.proyectoxd.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    private long CodTransaccion;
    private Timestamp fechaHora;
    private float monto;
    private String estado;
    private long CodUsuario;

}
