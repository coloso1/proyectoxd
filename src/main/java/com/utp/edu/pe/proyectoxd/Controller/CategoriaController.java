package com.utp.edu.pe.proyectoxd.Controller;

import com.utp.edu.pe.proyectoxd.Model.Categoria;
import com.utp.edu.pe.proyectoxd.Service.ServiceCategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    private final ServiceCategoriaDao serviceCategoriaDao;

    @Autowired
    public CategoriaController(ServiceCategoriaDao serviceCategoriaDao) {
        this.serviceCategoriaDao = serviceCategoriaDao;
    }

    @GetMapping
    public List<Categoria> listar() {
        return serviceCategoriaDao.Listar();  // Devolverá una lista de categorías en formato JSON
    }

    @PostMapping
    public int insertar(@RequestBody Categoria categoria) {
        return serviceCategoriaDao.Insertar(categoria);  // Insertar una nueva categoría
    }

    @PutMapping("/{idCategoria}")
    public int actualizar(@PathVariable long idCategoria, @RequestBody Categoria categoria) {
        categoria.setId(idCategoria); // Establecer el ID de la categoría a actualizar
        return serviceCategoriaDao.Actualizar(categoria);
    }

    @DeleteMapping("/{idCategoria}")
    public int eliminar(@PathVariable long idCategoria) {
        return serviceCategoriaDao.Eliminar(idCategoria);  // Eliminar una categoría por ID
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
