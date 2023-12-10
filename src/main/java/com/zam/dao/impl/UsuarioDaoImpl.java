/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.dao.impl;

import com.zam.bean.Usuario;
import com.zam.dao.ConexionDao;
import com.zam.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public void crearUsuario(Usuario usuario) {
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn  = null;
        PreparedStatement ps = null;
        try {
            String sql ="insert into usuario (nombre, correo, contrasena) values (?,?,?)";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
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
    public Usuario ObtenerUsuario(int id) {
        Usuario usuario = new Usuario();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from usuario where idUsuario = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setContrasena(rs.getString(4));;
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
        return usuario;
    }

    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="UPDATE usuario SET nombre = ?, correo = ?, contrasena = ? WHERE idUsuario = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, id);
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
    public void eliminarUsuario(int id) {
        try {
            ConexionDao conexionDao = new ConexionDaoImpl();
            Connection cn = conexionDao.getConexion();
            String sql ="DELETE usuario WHERE IdUsuario = ?";
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
    public Usuario obtenerUsuario(String nombre_usuario, String contrasena) {
        Usuario usuario = new Usuario();
        ConexionDao conexionDao = new ConexionDaoImpl();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql ="select * from usuario where nombre = ? and contrasena = ?";
            cn = conexionDao.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre_usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setContrasena(rs.getString(4));;
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
            if (cn != null) {
                try {
                    conexionDao.cerrarconexion(cn);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        return usuario;
    }
    
}
