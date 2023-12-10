/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zam.bean.Producto;
import com.zam.dao.IADao;
import com.zam.dao.ProductoDao;
import com.zam.dao.impl.IADaoImpl;
import com.zam.dao.impl.ProductoDaoImpl;
import com.zam.ia.Producto_format;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VerController", urlPatterns = {"/Ver"})
public class VerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        int idCliente = (int) session.getAttribute("idCliente");
        
        IADao iADao = new IADaoImpl();
        iADao.obtenerDatosUsuario(idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        iADao.ejecutarScriptPython();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Producto> lista = iADao.obtenerProductosRecomendados();
        
        // Utilizar Jackson para serializar la lista de productos a formato JSON
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
