package com.zam.ia;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zam.bean.Cliente;
import com.zam.bean.DetalleVenta;
import com.zam.bean.Producto;
import com.zam.bean.Venta;
import com.zam.dao.ClienteDao;
import com.zam.dao.DetalleVentaDao;
import com.zam.dao.ProductoDao;
import com.zam.dao.VentaDao;
import com.zam.dao.impl.ClienteDaoImpl;
import com.zam.dao.impl.DetalleVentaDaoImpl;
import com.zam.dao.impl.ProductoDaoImpl;
import com.zam.dao.impl.VentaDaoImpl;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prueba {
    public static void main(String[] args) { 
        DetalleVentaDao detalleVentaDao = new DetalleVentaDaoImpl();
        ClienteDao clienteDao = new ClienteDaoImpl();
        ProductoDao productoDao = new ProductoDaoImpl();
        VentaDao ventaDao = new VentaDaoImpl();
        
        List<Producto> listaProductos = productoDao.listarProducto();
        
        Cliente cliente = clienteDao.ObtenerCliente(1);
        List<Array> listaVector = new ArrayList<>();
          
        
        /////////////////////////////////////////////////////////////////
        double precio;
        double desviacion_estandar = 164.14;
        double media = 12.255;
        List<Venta> listaVenta = ventaDao.listaVenta(1);
        for (int i = 0; i < listaProductos.size(); i++) {
            Array vector = new Array();

            //Numero de compras
            double n_compras = 0;
            double resultado = 0;
            for (int j = 0; j < listaVenta.size(); j++) {
                DetalleVenta detalleVenta = detalleVentaDao.obtenerDetalleVenta(listaProductos.get(i).getIdProducto(), listaVenta.get(j).getIdVenta());
                n_compras += detalleVenta.getCantidad();                
            }
            //resultado = n_compras / 100;
            resultado = n_compras;
            vector.setNumero_compras(resultado);
            
            /*
            //Precio
            precio = listaProductos.get(i).getPrecio();
            double valor_estanderizado = (precio - media) / desviacion_estandar;
            vector.setPrecio(valor_estanderizado);
            */
            //Categoria
            int[] array = new int[9];
            switch (listaProductos.get(i).getCategoria()) {
                case "Abarrotes" -> {
                    array[0] = 1;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Embutidos" -> {
                    array[0] = 0;
                    array[1] = 1;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Snacks" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 1;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Hogar y limpieza" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 1;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Cuidado personal" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 1;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Preservativos" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 1;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Bebidas Alcoholicas" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 1;
                    array[7] = 0;
                    array[8] = 0;
                }
                case "Bebidas no Alcoholicas" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 1;
                    array[8] = 0;
                }
                case "Helados" -> {
                    array[0] = 0;
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 0;
                    array[4] = 0;
                    array[5] = 0;
                    array[6] = 0;
                    array[7] = 0;
                    array[8] = 1;
                }
            }
            vector.setCategoria(array);
            vector.setNombre(listaProductos.get(i).getNombre());
            listaVector.add(vector);
        }
        
        List<Array> lista_nueva = listaVector.stream().filter(p-> p.getNumero_compras() > 0).collect(Collectors.toList());    
        
//        for (int i = 0; i < lista_nueva.size(); i++) {
//            System.out.println("Vector " + (i + 1) + ":");
//            System.out.println("Nombre: " + lista_nueva.get(i).getNombre());
//            System.out.println("Numero de compras: " + lista_nueva.get(i).getNumero_compras());            
//            System.out.println("Categoria: " + lista_nueva.get(i).getCategoria()[0]);
//            System.out.println("");
//        }
// 
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json;
//        try {
//            json = objectMapper.writeValueAsString(lista_nueva);
//            
//            // Guardar la cadena JSON en un archivo
//            FileWriter fileWriter = new FileWriter(cliente.getNombre()+" - productos.json", StandardCharsets.UTF_8);
//            fileWriter.write(json);
//            fileWriter.close();
//            System.out.println("El archivo JSON se ha creado correctamente.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
//        String ruta = "C:/ZamProjects2023/Tambo/src/main/java/com/zam/ia/algor_mach_lear.py";
//        try {
//            ProcessBuilder pb = new ProcessBuilder("py", ruta);
//            Process process = pb.start();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            int exitCode = process.waitFor();
//            System.out.println("Script ejecutado. Código de salida: " + exitCode);
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
        
         
        ObjectMapper objectMapper2 = new ObjectMapper();
        String json2;
        try {
            json2 = objectMapper2.writeValueAsString(listaVector);
            
            // Guardar la cadena JSON en un archivo
            FileWriter fileWriter = new FileWriter("Productos.json", StandardCharsets.UTF_8);
            fileWriter.write(json2);
            fileWriter.close();
            System.out.println("El archivo JSON se ha creado correctamente.");
        } catch (IOException e) {
        
            e.printStackTrace();
        }
    }
}
