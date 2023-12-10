/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.dao.ConexionDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDaoImpl implements ConexionDao {

    private static final String usuario = "root";
    private static final String password = "josesamuel";
    private static final String bd = "tambobd";
    private static final String port = "3306";
    private static final String url = "jdbc:mysql://localhost:" + port + "/" + bd + "?serverTimezone=UTC";

    private static ConexionDao conexionDao;
    private static Connection cn;

    @Override
    public ConexionDao getInstance() {
        if (conexionDao == null) {
            conexionDao = new ConexionDaoImpl();
            System.out.println("INGRESO A LA CRACION DE LA INSTANCIA");
        } else {
            System.out.println("LA INSTANCIA YA EXISTE");
        }
        return conexionDao;
    }

    @Override
    public Connection getConexion() {
        if (cn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                cn = DriverManager.getConnection(url, usuario, password);
            } catch (Exception ex) {
                ex.printStackTrace();
                cn = null;
            }
            System.out.println("CREANDO CONEXION");
        } else {
            System.out.println("LA CONEXION YA EXISTE");
        }
        return cn;
    }

    @Override
    public void cerrarconexion(Connection cn) {
        try {
            cn.close();
            this.cn = null;
            System.out.println("CERRANDO CONEXION");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void cerrarResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("CERRANDO RESULSET");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void cerrarPreparedStatement(PreparedStatement ps) {
        try {
            ps.close();
            System.out.println("CERRANDO PREPARED STATEMENT");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
