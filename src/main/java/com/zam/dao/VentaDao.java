/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Venta;
import java.util.List;

public interface VentaDao {
    
    public void crearVenta(Venta venta);
    public Venta ObtenerVenta(int id);
    public void actualizarVenta(int id, Venta venta);
    public void eliminarVenta(int id);
    public Venta obtenerUltimaVenta(int idCliente);
    public List<Venta> listaVenta(int idCliente);
    
}
