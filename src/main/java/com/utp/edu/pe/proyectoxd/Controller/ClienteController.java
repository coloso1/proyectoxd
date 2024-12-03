package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.Cliente;
import com.utp.edu.pe.proyectoxd.Service.ServicesClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    private final ServicesClienteDao servicesClienteDao;

    @Autowired
    public ClienteController(ServicesClienteDao servicesClienteDao) {
        this.servicesClienteDao = servicesClienteDao;
    }

    @GetMapping
    public List<Cliente> Listar() {
        return servicesClienteDao.Listar();
    }

    @PostMapping
    public int Insertar(@RequestBody Cliente cliente) {
        return servicesClienteDao.Insertar(cliente);
    }

    @PutMapping("/{id}")
    public int Actualizar(@PathVariable("id") long IdCliente, @RequestBody Cliente cliente) {
        return servicesClienteDao.Actualizar(cliente);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable("id") long IdCliente) {
        return servicesClienteDao.Eliminar(IdCliente);
    }
}
