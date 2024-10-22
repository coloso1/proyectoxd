package com.utp.edu.pe.proyectoxd.Service;

import com.utp.edu.pe.proyectoxd.Dao.CategoriaDao;
import com.utp.edu.pe.proyectoxd.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoriaDao {

    @Autowired
    private CategoriaDao rCategoria; // Cambiado a un nombre más descriptivo

    public List<Categoria> Listar() { // Seguir la convención de nombres en mayúsculas
        return rCategoria.Listar();
    }

    public int Insertar(Categoria categoria) {
        return rCategoria.Insertar(categoria);
    }

    public int Actualizar(Categoria categoria) {
        return rCategoria.Actualizar(categoria);
    }

    public int Eliminar(long idCategoria) {
        return rCategoria.Eliminar(idCategoria);
    }
}
