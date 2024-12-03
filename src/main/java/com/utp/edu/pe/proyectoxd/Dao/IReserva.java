package com.utp.edu.pe.proyectoxd.Dao;

import com.utp.edu.pe.proyectoxd.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReserva {

    // Método para listar todas las reservas
    List<Reserva> Listar();

    // Método para insertar una nueva reserva
    int Insertar(Reserva reserva);

    // Método para actualizar una reserva existente
    int Actualizar(Reserva reserva);

    // Método para eliminar una reserva por su ID
    int Eliminar(long idReserva);
}
