/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Usuario;

public interface UsuarioDao {
    
    public void crearUsuario(Usuario usuario);
    public Usuario ObtenerUsuario(int id);
    public void actualizarUsuario(int id, Usuario usuario);
    public void eliminarUsuario(int id);
    public Usuario obtenerUsuario(String nombre_usuario, String contrasena);
    
}
