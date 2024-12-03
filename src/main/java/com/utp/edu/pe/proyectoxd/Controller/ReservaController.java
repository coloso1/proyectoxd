package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.Reserva;
import com.utp.edu.pe.proyectoxd.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Cambiado de @Controller a @RestController
@RequestMapping("reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Método para listar todas las reservas
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas(); // Invoca el método correcto del servicio
    }

    // Método para insertar una nueva reserva
    @PostMapping
    public int insertarReserva(@RequestParam Reserva reserva) {
        return reservaService.insertarReserva(reserva); // Invoca el método correcto del servicio
    }

    // Método para actualizar una reserva existente
    @PutMapping("/{idReserva}")
    public int actualizarReserva(@PathVariable long idReserva, @RequestBody Reserva reserva) {
        reserva.setId(idReserva); // Asegura que el ID correcto sea asignado
        return reservaService.actualizarReserva(reserva); // Invoca el método correcto del servicio
    }

    // Método para eliminar una reserva por su ID
    @DeleteMapping("/{idReserva}")
    public int eliminarReserva(@PathVariable long idReserva) {
        return reservaService.eliminarReserva(idReserva); // Invoca el método correcto del servicio
    }
}
