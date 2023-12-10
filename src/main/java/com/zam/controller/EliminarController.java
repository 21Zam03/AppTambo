/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.bean.Carrito;
import com.zam.dao.CarritoDao;
import com.zam.dao.ProductoDao;
import com.zam.dao.impl.CarritoDaoImpl;
import com.zam.dao.impl.ProductoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EliminarController", urlPatterns = {"/Eliminar"})
public class EliminarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        int idCliente = (int) session.getAttribute("idCliente");
        String nombre = request.getParameter("carrito");
        String codigo = request.getParameter("producto");
        int idProducto = Integer.parseInt(codigo);
        
        System.out.println(idCliente);
        System.out.println(nombre);
        System.out.println(idProducto);
        
        CarritoDao carritoDao = new CarritoDaoImpl();
        Carrito carrito_final = carritoDao.obtenerCarrito(idCliente, nombre);
        
        ProductoDao productoDao = new ProductoDaoImpl();
        productoDao.eliminarProductoLista(carrito_final.getIdCarrito(), idProducto);
        
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
