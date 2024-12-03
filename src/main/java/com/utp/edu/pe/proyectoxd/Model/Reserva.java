package com.utp.edu.pe.proyectoxd.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único

    @NotNull
    private String nombre;  // Nombre del cliente

    @NotNull
    private String correoElectronico;  // Correo electrónico del cliente

    @NotNull
    private String telefono;  // Teléfono del cliente

    @NotNull
    private LocalDate fecha;  // Fecha de la reserva

    @NotNull
    private LocalTime hora;  // Hora de la reserva

    @NotNull
    private int numPersonas;  // Número de personas para la reserva

}
