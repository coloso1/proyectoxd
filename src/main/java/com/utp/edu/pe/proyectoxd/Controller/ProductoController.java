package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.Producto;
import com.utp.edu.pe.proyectoxd.Service.ServiceProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController // Cambiado de @Controller a @RestController
@RequestMapping("/Producto")
public class ProductoController {

    private final ServiceProductoDao serviceProductoDao;

    @Autowired
    public ProductoController(ServiceProductoDao serviceProductoDao) {
        this.serviceProductoDao = serviceProductoDao;
    }

    @GetMapping
    public List<Producto> Listar() {
        return serviceProductoDao.Listar();
    }

    @PostMapping
    public int Insertar(@RequestBody Producto producto) {
        return serviceProductoDao.Insertar(producto);
    }

    @PutMapping("/{IdProducto}")
    public int Actualizar(@PathVariable long IdProducto, @RequestBody Producto producto) {
        producto.setIdProducto(IdProducto); // Cambia setId por setIdProducto
        return serviceProductoDao.Actualizar(producto);
    }

    @DeleteMapping("/{IdProducto}")
    public int Eliminar(@PathVariable long IdProducto) {
        return serviceProductoDao.Eliminar(IdProducto);
    }
}
