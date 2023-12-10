/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import lombok.Data;

@Data
public class Producto {
    
    private Integer idProducto;
    private String nombre;
    private Double precio;
    private String categoria;
    private String foto;
    private String marca;
}
