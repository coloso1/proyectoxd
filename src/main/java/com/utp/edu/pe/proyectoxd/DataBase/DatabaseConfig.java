package com.utp.edu.pe.proyectoxd.DataBase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/restaurante2");
        dataSource.setUsername("root");
        dataSource.setPassword("995674597");

        // Probar la conexión a la base de datos
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("¡Conexión a la base de datos exitosa!");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return dataSource;
    }
}
