/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Cliente;
import com.zam.bean.Venta;
import com.zam.dao.ClienteDao;
import com.zam.dao.ConexionDao;
import com.zam.dao.VentaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDaoImpl implements VentaDao {

    @Override
    public void crearVenta(Venta venta) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
         try {    
            String sql ="insert into venta (idCliente, fecha) values (?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            java.sql.Date fecha = new java.sql.Date(venta.getFecha().getTime());
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, fecha);
            int registro = ps.executeUpdate();
            if (registro > 0) {
                System.out.println("Se registro Correctamente");
            } else {
                System.out.println("No se pudo registrar");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);       
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
    public Venta ObtenerVenta(int id) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Venta venta = new Venta();
        ClienteDao clienteDao = new ClienteDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from venta where idVenta = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                venta.setCliente(cliente);
                venta.setFecha(rs.getDate(3));
            } else {
                System.out.println("No se pudo obtener la venta");
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
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
        }
        return venta;
    }

    @Override
    public void actualizarVenta(int id, Venta venta) {
        
    }

    @Override
    public void eliminarVenta(int id) {
        
    }    

    @Override
    public Venta obtenerUltimaVenta(int idCliente) {
        Venta venta = new Venta();
        ClienteDao clienteDao = new ClienteDaoImpl();
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="select * from venta where idCliente = ? ORDER BY idVenta DESC LIMIT 1;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                venta.setCliente(cliente);
                venta.setFecha(rs.getDate(3));
            } else {
                System.out.println("No se pudo obtener al cliente");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);
            conexionDao.cerrarResultSet(rs);
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        }
        return venta;
    }

    @Override
    public List<Venta> listaVenta(int idCliente) {
        List<Venta> listaVenta = new ArrayList<>();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteDao clienteDao = new ClienteDaoImpl();
        try {
            cn = conexionDao.getConexion();
            String sql = "select * from venta where idCliente = ?;";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt(1));
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                venta.setCliente(cliente);
                venta.setFecha(rs.getDate(3));
                listaVenta.add(venta);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
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
        return listaVenta;
    }
}
