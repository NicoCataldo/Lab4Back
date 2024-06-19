package com.example.TP1LAB4.Gestor;

import org.hibernate.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChartManager {
    String urlConexion = "jdbc:mysql://localhost:3306/TPReact";
    String usuario = "root";
    String clave = "123456789";


    public ResultSet getDatosChartByMonthAndYear() {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(urlConexion, usuario, clave);

            Statement s = conexion.createStatement();

            // Consulta para agrupar pedidos por mes y año
            rs = s.executeQuery(
                    "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes_anio, COUNT(*) AS cantidad_pedidos " +
                            "FROM Pedido " +
                            "GROUP BY mes_anio " +
                            "ORDER BY mes_anio"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getDatosChartByInstrumento() {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(urlConexion, usuario, clave);

            Statement s = conexion.createStatement();

            // Consulta para agrupar pedidos por instrumento
            rs = s.executeQuery(
                    "SELECT i.instrumento, COUNT(*) AS cantidad_pedidos " +
                            "FROM Pedido p " +
                            "JOIN detalle_pedido d ON p.Detalle_id = d.id " +
                            "JOIN Instrumento i ON d.Id = i.id " +
                            "GROUP BY i.instrumento " +
                            "ORDER BY cantidad_pedidos DESC"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }




}
