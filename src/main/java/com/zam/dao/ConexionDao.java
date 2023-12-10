/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConexionDao {
    
    public ConexionDao getInstance();
    public Connection getConexion();
    public void cerrarconexion(Connection cn);
    public void cerrarResultSet(ResultSet rs);
    public void cerrarPreparedStatement(PreparedStatement ps);
    
}
