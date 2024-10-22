package com.utp.edu.pe.proyectoxd.Dao;

import com.utp.edu.pe.proyectoxd.Model.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MetodoPagoDao implements IMetododePago { // Asegúrate de que el nombre de la interfaz sea correcto

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MetodoPagoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MetodoPago> Listar() {
        String SQL = "SELECT * FROM MetodoPago WHERE Estado = 1"; // Asegurando que solo se listan métodos de pago activos
        return jdbcTemplate.query(SQL, new MetodoPagoRowMapper());
    }

    @Override
    public int Insertar(MetodoPago objeto) {
        String SQL = "INSERT INTO MetodoPago (nombre, descripcion) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getDescripcion());
    }

    @Override
    public int Actualizar(MetodoPago objeto) {
        String SQL = "UPDATE MetodoPago SET nombre = ?, descripcion = ? WHERE IdMetodoPago = ? AND Estado = 1";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getDescripcion(), objeto.getIdMetodoPago());
    }

    @Override
    public int Eliminar(long IdMetodoPago) {
        String SQL = "UPDATE MetodoPago SET Estado = 0 WHERE IdMetodoPago = ? AND Estado = 1"; // Asegurando que se actualiza el estado correcto
        return jdbcTemplate.update(SQL, IdMetodoPago);
    }

    private static class MetodoPagoRowMapper implements RowMapper<MetodoPago> {
        @Override
        public MetodoPago mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MetodoPago(
                    rs.getLong("IdMetodoPago"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
            );
        }
    }
}
