/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zam.dao;

import com.zam.bean.Producto;
import com.zam.ia.Producto_format;
import java.util.List;

public interface IADao {
    
    public void obtenerDatosUsuario(int idCliente);
    public void ejecutarScriptPython();
    public List<Producto> obtenerProductosRecomendados();
    
}
