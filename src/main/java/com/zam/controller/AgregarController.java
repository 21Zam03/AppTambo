/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.bean.Carrito;
import com.zam.bean.Cliente;
import com.zam.bean.ListaCarrito;
import com.zam.bean.Producto;
import com.zam.dao.CarritoDao;
import com.zam.dao.ClienteDao;
import com.zam.dao.ListaCarritoDao;
import com.zam.dao.ProductoDao;
import com.zam.dao.impl.CarritoDaoImpl;
import com.zam.dao.impl.ClienteDaoImpl;
import com.zam.dao.impl.ListaCarritoDaoImpl;
import com.zam.dao.impl.ProductoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgregarController", urlPatterns = {"/Agregar"})
public class AgregarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        int idClienten = (int) session.getAttribute("idCliente");

        //Obtenemos el producto
        String idProducto = request.getParameter("idProducto");
        String cantidad = request.getParameter("cantidad");
        Integer cod = Integer.valueOf(idProducto);
        Integer cant = Integer.valueOf(cantidad);
        ProductoDao proDao = new ProductoDaoImpl();
        Producto producto = proDao.ObtenerProducto(cod);

        CarritoDao carritoDao = new CarritoDaoImpl();
        ClienteDao clienteDao = new ClienteDaoImpl();
        
        String nombren = request.getParameter("nombre");
        if (nombren == null) {
            String nombre_carrito = request.getParameter("carrito");
            
            //Agregamos el producto al carrito de ventas
            Cliente cliente1 = clienteDao.ObtenerCliente(idClienten);
            ListaCarritoDao listaCarritoDao = new ListaCarritoDaoImpl();
            Carrito carrito_actualizado = carritoDao.obtenerCarrito(idClienten, nombre_carrito, cliente1);

            ListaCarrito listaCarrito = new ListaCarrito();
            listaCarrito.setCarrito(carrito_actualizado);
            listaCarrito.setProducto(producto);
            listaCarrito.setCantidad(cant);
            listaCarrito.setPrecio(producto.getPrecio());

            listaCarritoDao.crearListaCarrito(listaCarrito);
            response.sendRedirect("categorias.jsp");
            
        } else {
            //Crearmos el carrito
            Carrito carrito = new Carrito();
            Cliente cliente1 = clienteDao.ObtenerCliente(idClienten);
            carrito.setCliente(cliente1);
            Date fechaActual = new Date();
            carrito.setFecha(fechaActual);
            carrito.setNombre(nombren);
            carritoDao.crearCarrito(carrito);

            //Agregamos el producto al carrito de ventas
            ListaCarritoDao listaCarritoDao = new ListaCarritoDaoImpl();
            Carrito carrito_actualizado = carritoDao.obtenerCarrito(idClienten, nombren, cliente1);

            ListaCarrito listaCarrito = new ListaCarrito();
            listaCarrito.setCarrito(carrito_actualizado);
            listaCarrito.setProducto(producto);
            listaCarrito.setCantidad(cant);
            listaCarrito.setPrecio(producto.getPrecio());

            listaCarritoDao.crearListaCarrito(listaCarrito);
            response.sendRedirect("categorias.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
