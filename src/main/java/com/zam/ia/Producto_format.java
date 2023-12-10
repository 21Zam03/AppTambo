/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.ia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Producto_format {
    @JsonProperty("Producto")
    private String Producto;
    @JsonProperty("Peso")
    private double Peso;
    
}
