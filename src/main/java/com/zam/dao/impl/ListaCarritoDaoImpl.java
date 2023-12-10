/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Carrito;
import com.zam.bean.ListaCarrito;
import com.zam.bean.Producto;
import com.zam.dao.CarritoDao;
import com.zam.dao.ConexionDao;
import com.zam.dao.ListaCarritoDao;
import com.zam.dao.ProductoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaCarritoDaoImpl implements ListaCarritoDao {

    @Override
    public void crearListaCarrito(ListaCarrito listaCarrito) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            String sql ="insert into listacarrito (idCarrito, idProducto, cantidad, precio) values (?,?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, listaCarrito.getCarrito().getIdCarrito());
            ps.setInt(2, listaCarrito.getProducto().getIdProducto());
            ps.setInt(3, listaCarrito.getCantidad());
            ps.setDouble(4, listaCarrito.getPrecio());
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
    public void actualizarListaCarrito(int id, ListaCarrito listaCarrito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarListaCarrito(int id) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexionDao.getConexion();
            String sql ="delete from listacarrito where idCarrito = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
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
    public List<ListaCarrito> ObtenerListaCarrito(int idCarrito) {
        List<ListaCarrito> listaCarrito = new ArrayList<>();
        ConexionDao conexionDao = new ConexionDaoImpl();
        CarritoDao carritoDao = new CarritoDaoImpl();
        ProductoDao productoDao = new ProductoDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from listaCarrito where idCarrito = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaCarrito car = new ListaCarrito();
                Carrito carrito = carritoDao.obtenerCarrito(rs.getInt(2));
                Producto producto = productoDao.ObtenerProducto(rs.getInt(3));
                car.setIdListaCarrito(rs.getInt(1));
                car.setCarrito(carrito);
                car.setProducto(producto);
                car.setCantidad(rs.getInt(4));
                car.setPrecio(rs.getDouble(5));
                listaCarrito.add(car);
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
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        return listaCarrito;    
    }   
}
