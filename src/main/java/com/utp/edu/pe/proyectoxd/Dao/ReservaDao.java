package com.utp.edu.pe.proyectoxd.Dao;

import com.utp.edu.pe.proyectoxd.Model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservaDao implements IReserva {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reserva> Listar() {
        String SQL = "SELECT * FROM reservas"; // Selecciona todas las reservas
        return jdbcTemplate.query(SQL, new ReservaRowMapper());
    }

    @Override
    public int Insertar(Reserva reserva) {
        String SQL = "INSERT INTO reservas (nombre, correo_electronico, telefono, fecha, hora, num_personas) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, reserva.getNombre(), reserva.getCorreoElectronico(),
                reserva.getTelefono(), reserva.getFecha(),
                reserva.getHora(), reserva.getNumPersonas());
    }

    @Override
    public int Actualizar(Reserva reserva) {
        String SQL = "UPDATE reservas SET nombre = ?, correo_electronico = ?, telefono = ?, fecha = ?, " +
                "hora = ?, num_personas = ? WHERE id = ?";
        return jdbcTemplate.update(SQL, reserva.getNombre(), reserva.getCorreoElectronico(),
                reserva.getTelefono(), reserva.getFecha(),
                reserva.getHora(), reserva.getNumPersonas(),
                reserva.getId());
    }

    @Override
    public int Eliminar(long idReserva) {
        String SQL = "DELETE FROM reservas WHERE id = ?";
        return jdbcTemplate.update(SQL, idReserva);
    }

    private static class ReservaRowMapper implements RowMapper<Reserva> {
        @Override
        public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Reserva(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("correo_electronico"),
                    rs.getString("telefono"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getTime("hora").toLocalTime(),
                    rs.getInt("num_personas")
                    // No mapeamos 'creado_en' porque no está en la entidad
            );
        }
    }
}
