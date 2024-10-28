package com.utp.edu.pe.proyectoxd.Dao;

import com.utp.edu.pe.proyectoxd.Model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoDao implements IProducto {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Producto> Listar() {
        String SQL = "SELECT * FROM Producto WHERE Estado = 1"; // Asegurando que solo se listan productos activos
        return jdbcTemplate.query(SQL, new ProductoRowMapper());
    }

    @Override
    public int Insertar(Producto objeto) {
        // Agregar el campo Stock en la consulta SQL
        String SQL = "INSERT INTO Producto (IdCategoria, nombre, precio, descripcion, stock) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, objeto.getIdCategoria(), objeto.getNombre(), objeto.getPrecio(), objeto.getDescripcion(), objeto.getStock());
    }

    @Override
    public int Actualizar(Producto objeto) {
        // Asegúrate de actualizar también el Stock
        String SQL = "UPDATE Producto SET IdCategoria = ?, nombre = ?, precio = ?, descripcion = ?, stock = ? WHERE IdProducto = ? AND Estado = 1";
        return jdbcTemplate.update(SQL, objeto.getIdCategoria(), objeto.getNombre(), objeto.getPrecio(), objeto.getDescripcion(), objeto.getStock(), objeto.getIdProducto());
    }

    @Override
    public int Eliminar(long IdProducto) {
        String SQL = "UPDATE Producto SET Estado = 0 WHERE IdProducto = ? AND Estado = 1"; // Asegurando que se actualiza el estado correcto
        return jdbcTemplate.update(SQL, IdProducto);
    }

    private static class ProductoRowMapper implements RowMapper<Producto> {
        @Override
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Producto(
                    rs.getLong("IdProducto"),
                    rs.getBoolean("Estado"),
                    rs.getLong("IdCategoria"),
                    rs.getString("nombre"),
                    rs.getFloat("precio"),
                    rs.getString("descripcion"),
                    rs.getInt("stock") // Agregar el mapeo del Stock
            );
        }
    }
}
