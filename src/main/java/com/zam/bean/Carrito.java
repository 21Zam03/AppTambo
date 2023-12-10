/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import java.util.Date;
import lombok.Data;

@Data
public class Carrito {
    
    private Integer idCarrito;
    private Cliente cliente;
    private String nombre;
    private Date fecha;
    
}
