/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Carrito;
import com.zam.bean.Cliente;
import java.util.List;

public interface CarritoDao {
    
    public void crearCarrito(Carrito carrito);
    public Carrito obtenerCarrito(int idCliente, String nombre, Cliente cliente);
    public Carrito obtenerCarrito(int idCarrito);
    public void actualizarCarrito(int id, Carrito carrito);
    public void eliminarCarrito(int id);
    public List<Carrito> listarCarritos(Cliente cliente);
    public Carrito obtenerCarrito(String nombre);
    public Carrito obtenerCarrito(int idCliente, String nombre);
    
}
