/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.DetalleVenta;
import com.zam.bean.Producto;
import com.zam.bean.Venta;
import java.util.List;

public interface DetalleVentaDao {
    
    public void crearDetalleVenta(Venta venta, Producto producto, int cantidad);
    public DetalleVenta obtenerDetalleVenta(int idProducto, int idVenta);
}
