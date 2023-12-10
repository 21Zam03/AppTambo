/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Producto;
import com.zam.dao.ConexionDao;
import com.zam.dao.ProductoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {

    @Override
    public void crearProducto(Producto producto) {

    }

    @Override
    public Producto ObtenerProducto(int id) {
        Producto producto = new Producto();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from producto where idProducto = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getString(5));
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
        }
        return producto;
    }

    @Override
    public void actualizarProducto(int id, Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> listarProducto() {
        List<Producto> listaProducto = new ArrayList<>();
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql = "select * from producto";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getString(5));
                listaProducto.add(producto);
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);
            conexionDao.cerrarResultSet(rs);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaProducto;
    }

    @Override
    public List<Producto> listarProductoCategoria(String categoria) {
        List<Producto> listaProducto = new ArrayList<>();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = conexionDao.getConexion();
            String sql = "select * from producto where categoria = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, categoria);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getString(5));
                listaProducto.add(producto);
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
        return listaProducto;
    }

    @Override
    public void eliminarProductoLista(int idCarrito, int idProducto) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexionDao.getConexion();
            String sql ="delete from listacarrito where idCarrito = ? and idProducto = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            ps.setInt(2, idProducto);
            int registro = ps.executeUpdate();
            if (registro > 0) {
                System.out.println("Se elimino el producto de la lista");
            } else {
                System.out.println("No se pudo eliminar el producto de la lista");
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
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
    public List<Producto> obtnenerProductoList(String [] nombres) {
        List<Producto> listaProducto = new ArrayList<>();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = conexionDao.getConexion();
            String sql = "select * from producto where categoria in (?, ?, ?, ?, ?, ?);";
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombres[0]);
            ps.setString(2, nombres[1]);
            ps.setString(3, nombres[2]);
            ps.setString(4, nombres[3]);
            ps.setString(5, nombres[4]);
            ps.setString(6, nombres[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getString(5));
                listaProducto.add(producto);
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
        return listaProducto;
    }

    @Override
    public Producto obtenerProductoNombre(String nombre) {
        Producto producto = new Producto();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from producto where nombre = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getString(5));
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
        }
        return producto;
    }
}
