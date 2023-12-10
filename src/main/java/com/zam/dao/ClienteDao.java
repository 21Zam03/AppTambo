/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Cliente;

public interface ClienteDao {
    
    public void crearCliente(Cliente cliente, int idUsuario);
    public Cliente ObtenerCliente(int id);
    public void actualizarCliente(int id, Cliente cliente);
    public void eliminarCliente(int id);
    public Cliente obtenerClienteId(int idUsuario); 
}
