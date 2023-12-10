/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.bean;

import lombok.Data;

@Data
public class Cliente {
    
    private Integer idCliente;
    private Usuario usuario;
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;
    
}
