package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombreEmp;
        String nombreDep;

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement stmt = conn.createStatement()) {
                    String sql = "SELECT empleado.nombre, departamento.nombre " +
                            "FROM empleado JOIN departamento USING(dep_id)";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        nombreEmp = rs.getString(1);
                        nombreDep = rs.getString(2);
                        System.out.println("Nombre: " + nombreEmp);
                        System.out.println("        Nombre: " + nombreDep);
                    }

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}