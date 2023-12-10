/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import lombok.Data;

@Data
public class ListaCarrito {
    
    private Integer idListaCarrito;
    private Carrito carrito;
    private Producto producto;
    private Integer cantidad;
    private Double precio;
    
}
