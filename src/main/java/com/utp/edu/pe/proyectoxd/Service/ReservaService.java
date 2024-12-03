package com.utp.edu.pe.proyectoxd.Service;

import com.utp.edu.pe.proyectoxd.Dao.IReserva;
import com.utp.edu.pe.proyectoxd.Model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final IReserva reservaRepository;

    @Autowired
    public ReservaService(IReserva reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Método para listar todas las reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.Listar();
    }

    // Método para guardar una reserva
    public int insertarReserva(Reserva reserva) {
        return reservaRepository.Insertar(reserva);
    }

    // Método para actualizar una reserva existente
    public int actualizarReserva(Reserva reserva) {
        return reservaRepository.Actualizar(reserva);
    }

    // Método para eliminar una reserva
    public int eliminarReserva(long idReserva) {
        return reservaRepository.Eliminar(idReserva);
    }
}
