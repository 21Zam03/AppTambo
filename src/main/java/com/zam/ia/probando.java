/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zam.ia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zam.bean.Producto;
import com.zam.dao.IADao;
import com.zam.dao.impl.IADaoImpl;
import java.io.File;
import java.util.List;

public class probando {
    
    public static void main(String[] args) {
        IADao iADao = new IADaoImpl();
        //iADao.obtenerDatosUsuario(1);
        iADao.ejecutarScriptPython();
//        List<Producto> lista = iADao.obtenerProductosRecomendados();
//        for (int i=0; i<lista.size(); i++) {
//            System.out.println("Nombre: "+lista.get(i).getFoto());
//        }
//        List<Producto_format> listaObjetos = null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            File file = new File("C:/ZamProjects2023/Tambo/productos recomendados.json");
//            
//            // Lee el archivo JSON y conviértelo a una lista de objetos
//            listaObjetos = objectMapper.readValue(file, new TypeReference<List<Producto_format>>(){});
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i=0; i<listaObjetos.size(); i++) {
//            System.out.println("Producto "+(i+1));
//            System.out.println("Nombre: "+listaObjetos.get(i).getProducto());
//            System.out.println("Peso: "+listaObjetos.get(i).getPeso());
//        }
        
    }
}
