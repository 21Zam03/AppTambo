/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import lombok.Data;

@Data
public class DetalleVenta {
    
    private Integer idDetalleVenta;
    private Venta venta;
    private Producto producto;
    private Integer cantidad;
    private Double precio;
    
}
