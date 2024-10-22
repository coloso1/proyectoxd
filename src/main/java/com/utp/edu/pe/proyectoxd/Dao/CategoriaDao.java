package com.utp.edu.pe.proyectoxd.Dao;

import com.utp.edu.pe.proyectoxd.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaDao implements ICategoria {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoriaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Categoria> Listar() {
        String SQL = "SELECT * FROM Categoria WHERE Estado = 1"; // Asegurando que solo se listan categorías activas
        return jdbcTemplate.query(SQL, new CategoriaRowMapper());
    }

    @Override
    public int Insertar(Categoria objeto) {
        String SQL = "INSERT INTO Categoria (nombre, descripcion) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getDescripcion());
    }

    @Override
    public int Actualizar(Categoria objeto) {
        String SQL = "UPDATE Categoria SET nombre = ?, descripcion = ? WHERE id = ? AND Estado = 1";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getDescripcion(), objeto.getId());
    }

    @Override
    public int Eliminar(long idCategoria) {
        String SQL = "UPDATE Categoria SET Estado = 0 WHERE id = ? AND Estado = 1";
        return jdbcTemplate.update(SQL, idCategoria); // Asegurando que se actualiza el estado correcto
    }

    private static class CategoriaRowMapper implements RowMapper<Categoria> {
        @Override
        public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Categoria(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
            );
        }
    }
}
