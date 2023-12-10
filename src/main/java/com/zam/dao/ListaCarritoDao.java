/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Carrito;
import com.zam.bean.ListaCarrito;
import com.zam.bean.Producto;
import java.util.List;

public interface ListaCarritoDao {
    
    public void crearListaCarrito(ListaCarrito listaCarrito);
    public List<ListaCarrito>ObtenerListaCarrito(int idCarrito);
    public void actualizarListaCarrito(int id, ListaCarrito listaCarrito);
    public void eliminarListaCarrito(int id);
    
}
