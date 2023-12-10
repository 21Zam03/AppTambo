/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Producto;
import java.util.List;

public interface ProductoDao {
    
    public void crearProducto(Producto producto);
    public Producto ObtenerProducto(int id);
    public List<Producto> listarProducto();
    public void actualizarProducto(int id, Producto producto);
    public void eliminarProducto(int id);
    public List<Producto> listarProductoCategoria(String categoria);
    public void eliminarProductoLista(int idCarrito, int idProducto);
    public List<Producto> obtnenerProductoList(String [] nombres);
    public Producto obtenerProductoNombre(String nombre);
}
