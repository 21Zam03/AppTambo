/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Carrito;
import com.zam.bean.Cliente;
import com.zam.dao.CarritoDao;
import com.zam.dao.ClienteDao;
import com.zam.dao.ConexionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritoDaoImpl implements CarritoDao {

    @Override
    public void crearCarrito(Carrito carrito) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into carrito (idCliente, fecha, nombre) values (?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            java.sql.Date fecha = new java.sql.Date(carrito.getFecha().getTime());
            ps.setInt(1, carrito.getCliente().getIdCliente());
            ps.setDate(2, fecha);
            ps.setString(3, carrito.getNombre());
            int registro = ps.executeUpdate();
//            if (registro > 0) {
//                System.out.println("Se registro Correctamente");
//            } else {
//                System.out.println("No se pudo registrar");
//            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
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
    public Carrito obtenerCarrito(int idCliente, String nombre, Cliente cliente) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Carrito carrito = new Carrito();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from carrito where idCliente = ? and nombre = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setCliente(cliente);
                carrito.setFecha(rs.getDate(3));
                carrito.setNombre(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error1: " + ex.getMessage());
            System.out.println("Error:" + carrito);
            System.out.println("idCliente: " + idCliente);
            System.out.println("Nombre: " + nombre);
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
        return carrito;
    }

    @Override
    public void actualizarCarrito(int id, Carrito carrito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarCarrito(int id) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexionDao.getConexion();
            String sql ="delete from carrito where idCarrito = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();
//            if (registro > 0) {
//                System.out.println("Se elimino el producto de la lista");
//            } else {
//                System.out.println("No se pudo eliminar el producto de la lista");
//            }
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
    public Carrito obtenerCarrito(int idCarrito) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        ClienteDao clienteDao = new ClienteDaoImpl();
        Carrito carrito = new Carrito();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from carrito where idCarrito = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setCliente(cliente);
                carrito.setFecha(rs.getDate(3));
                carrito.setNombre(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error1: " + ex.getMessage());
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
        return carrito;
    }

    @Override
    public List<Carrito> listarCarritos(Cliente cliente) {
        List<Carrito> listaCarrito = new ArrayList<>();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from carrito where idCliente = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            rs = ps.executeQuery();
            while (rs.next()) {
                Carrito carrito = new Carrito();
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setCliente(cliente);
                carrito.setFecha(rs.getDate(3));
                carrito.setNombre(rs.getString(4));
                listaCarrito.add(carrito);
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
        return listaCarrito;
    }

    @Override
    public Carrito obtenerCarrito(String nombre) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        ClienteDao clienteDao = new ClienteDaoImpl();
        Carrito carrito = new Carrito();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from carrito where nombre = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setCliente(cliente);
                carrito.setFecha(rs.getDate(3));
                carrito.setNombre(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error1: " + ex.getMessage());
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
        return carrito;
    }

    @Override
    public Carrito obtenerCarrito(int idCliente, String nombre) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        ClienteDao clienteDao = new ClienteDaoImpl();
        Carrito carrito = new Carrito();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from carrito where idCliente = ? and nombre = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteDao.ObtenerCliente(rs.getInt(2));
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setCliente(cliente);
                carrito.setFecha(rs.getDate(3));
                carrito.setNombre(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error1: " + ex.getMessage());
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
        return carrito;
    }

}
