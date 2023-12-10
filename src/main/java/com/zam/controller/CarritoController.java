/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zam.bean.Carrito;
import com.zam.bean.ListaCarrito;
import com.zam.dao.CarritoDao;
import com.zam.dao.ListaCarritoDao;
import com.zam.dao.impl.CarritoDaoImpl;
import com.zam.dao.impl.ListaCarritoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarritoController", urlPatterns = {"/Carrito"})
public class CarritoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String carrito_nombre = request.getParameter("carrito");
        CarritoDao carritoDao = new CarritoDaoImpl();
        Carrito carrito = carritoDao.obtenerCarrito(carrito_nombre);
        
        ListaCarritoDao listaCarritoDao = new ListaCarritoDaoImpl();
        
        List<ListaCarrito> lista = listaCarritoDao.ObtenerListaCarrito(carrito.getIdCarrito());
        
         //Utilizar Jackson para serializar la lista de productos a formato JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonProductos = mapper.writeValueAsString(lista);
        
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonProductos);
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
