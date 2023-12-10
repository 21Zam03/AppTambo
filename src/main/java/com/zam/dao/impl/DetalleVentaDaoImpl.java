/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.DetalleVenta;
import com.zam.bean.Producto;
import com.zam.bean.Venta;
import com.zam.dao.ConexionDao;
import com.zam.dao.DetalleVentaDao;
import com.zam.dao.ProductoDao;
import com.zam.dao.VentaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDaoImpl implements DetalleVentaDao {

    @Override
    public void crearDetalleVenta(Venta venta, Producto producto, int cantidad) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            String sql ="insert into detalleventa (idVenta, idProducto, cantidad, precio) values (?,?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, venta.getIdVenta());
            ps.setInt(2, producto.getIdProducto());
            ps.setInt(3, cantidad);
            ps.setDouble(4, producto.getPrecio());
            int registro = ps.executeUpdate();
//            if (registro > 0) {
//                System.out.println("Se registro Correctamente");
//            } else {
//                System.out.println("No se pudo registrar");
//            }      
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        } finally {    
            if (ps != null) {
                try {
                    conexionDao.cerrarPreparedStatement(ps);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }           
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(int idProducto, int idVenta) {
        DetalleVenta detalleVenta = new DetalleVenta();
        VentaDao ventaDao = new VentaDaoImpl();
        ProductoDao productoDao = new ProductoDaoImpl();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from detalleventa where idProducto = ? and idVenta = ?;";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idVenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalleVenta.setIdDetalleVenta(rs.getInt(1));
                Venta venta = ventaDao.ObtenerVenta(rs.getInt(2));
                detalleVenta.setVenta(venta);
                Producto producto = productoDao.ObtenerProducto(rs.getInt(3));
                detalleVenta.setProducto(producto);
                detalleVenta.setCantidad(rs.getInt(4));
                detalleVenta.setPrecio(rs.getDouble(5));
            }
            if (detalleVenta.getCantidad() == null) {
                detalleVenta.setCantidad(0);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    conexionDao.cerrarResultSet(rs);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }     
            if (ps != null) {
                try {
                    conexionDao.cerrarPreparedStatement(ps);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        return detalleVenta;
    }    
}
