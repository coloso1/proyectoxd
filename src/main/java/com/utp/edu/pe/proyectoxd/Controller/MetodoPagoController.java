package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.MetodoPago;
import com.utp.edu.pe.proyectoxd.Service.ServiceMetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // Cambiado a @RestController para manejar JSON
@RequestMapping("/MetodoPago")
public class MetodoPagoController {

    private final ServiceMetodoPago serviceMetodoPago;

    @Autowired
    public MetodoPagoController(ServiceMetodoPago serviceMetodoPago) {
        this.serviceMetodoPago = serviceMetodoPago;
    }

    @GetMapping
    public List<MetodoPago> Listar() {
        return serviceMetodoPago.Listar();
    }

    @PostMapping
    public int Insertar(@RequestBody MetodoPago metodoPago) {
        return serviceMetodoPago.Insertar(metodoPago);
    }

    @PutMapping("/{IdMetodoPago}")
    public int Actualizar(@PathVariable long IdMetodoPago, @RequestBody MetodoPago metodoPago) {
        metodoPago.setIdMetodoPago(IdMetodoPago); // Asegúrate de que el objeto MetodoPago tenga el ID correcto
        return serviceMetodoPago.Actualizar(metodoPago);
    }

    @DeleteMapping("/{IdMetodoPago}")
    public int Eliminar(@PathVariable long IdMetodoPago) {
        return serviceMetodoPago.Eliminar(IdMetodoPago);
    }
}
