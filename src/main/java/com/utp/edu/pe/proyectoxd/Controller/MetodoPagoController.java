package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.MetodoPago;
import com.utp.edu.pe.proyectoxd.Service.ServiceMetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MetodoPago")
public class MetodoPagoController {

    private final ServiceMetodoPago serviceMetodoPago;

    @Autowired
    public MetodoPagoController(ServiceMetodoPago serviceMetodoPago) {
        this.serviceMetodoPago = serviceMetodoPago;
    }

    @GetMapping
    public ResponseEntity<List<MetodoPago>> Listar() {
        List<MetodoPago> metodos = serviceMetodoPago.Listar();
        return ResponseEntity.ok(metodos);
    }

    @PostMapping
    public ResponseEntity<String> Insertar(@RequestBody MetodoPago metodoPago) {
        try {
            int result = serviceMetodoPago.Insertar(metodoPago);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Método de pago agregado con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo agregar el método de pago");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el método de pago");
        }
    }

    @PutMapping("/{IdMetodoPago}")
    public ResponseEntity<String> Actualizar(@PathVariable long IdMetodoPago, @RequestBody MetodoPago metodoPago) {
        try {
            metodoPago.setIdMetodoPago(IdMetodoPago);
            int result = serviceMetodoPago.Actualizar(metodoPago);
            if (result > 0) {
                return ResponseEntity.ok("Método de pago actualizado con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de pago no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el método de pago");
        }
    }

    @DeleteMapping("/{IdMetodoPago}")
    public ResponseEntity<String> Eliminar(@PathVariable long IdMetodoPago) {
        try {
            int result = serviceMetodoPago.Eliminar(IdMetodoPago);
            if (result > 0) {
                return ResponseEntity.ok("Método de pago eliminado con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Método de pago no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el método de pago");
        }
    }
}
