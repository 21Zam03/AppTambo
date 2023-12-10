/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Cliente;
import com.zam.bean.Usuario;
import com.zam.dao.ClienteDao;
import com.zam.dao.ConexionDao;
import com.zam.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void crearCliente(Cliente cliente, int idUsuario) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            String sql ="insert into cliente (dni, nombre, telefono, direccion, idUsuario) values (?,?,?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, idUsuario);
            int registro = ps.executeUpdate();
            if (registro > 0) {
                System.out.println("Se registro Correctamente");
            } else {
                System.out.println("No se pudo registrar");
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
    public Cliente ObtenerCliente(int id) {
        Cliente cliente = new Cliente();
        ConexionDao conexionDao = new ConexionDaoImpl();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from cliente where idCliente = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                int id_Usuario = rs.getInt(6);
                Usuario usuario = usuarioDao.ObtenerUsuario(id_Usuario);
                cliente.setUsuario(usuario);
            } else {
                System.out.println("No se pudo obtener al cliente");
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
        return cliente;
    }

    @Override
    public void actualizarCliente(int id, Cliente cliente) {
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="UPDATE cliente SET dni = ?, nombre = ?, telefono = ?, direccion = ? WHERE idCliente = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, id);
            int actualizacion = ps.executeUpdate();
            if (actualizacion > 0) {
                System.out.println("Se actualizaron los datos correctamente");
            } else {
                System.out.println("No se pudo actualizar los datos");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);         
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int id) {
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="DELETE cliente WHERE IdCliente = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizacion = ps.executeUpdate();
            if (actualizacion > 0) {
                System.out.println("Se elimino los datos correctamente");
            } else {
                System.out.println("No se pudo eliminar los datos");
            }
            conexionDao.cerrarconexion(cn);
            conexionDao.cerrarPreparedStatement(ps);         
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerClienteId(int idUsuario) {
        Cliente cliente = new Cliente();
        ConexionDao conexionDao = new ConexionDaoImpl();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from cliente where idUsuario = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                int id_Usuario = rs.getInt(6);
                Usuario usuario = usuarioDao.ObtenerUsuario(id_Usuario);
                cliente.setUsuario(usuario);
            } else {
                System.out.println("No se pudo obtener al cliente");
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
        return cliente;
    }
     
}
