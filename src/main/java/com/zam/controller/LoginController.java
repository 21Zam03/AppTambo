/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.bean.Cliente;
import com.zam.bean.Usuario;
import com.zam.dao.ClienteDao;
import com.zam.dao.UsuarioDao;
import com.zam.dao.impl.ClienteDaoImpl;
import com.zam.dao.impl.UsuarioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario user = usuarioDao.obtenerUsuario(usuario, contrasena);
        
        if (user.getIdUsuario() != null) {
            ClienteDao clienteDao = new ClienteDaoImpl();
            Cliente cliente = clienteDao.obtenerClienteId(user.getIdUsuario());
            HttpSession session = request.getSession();
            session.setAttribute("dni", cliente.getDni());
            session.setAttribute("nombre", cliente.getNombre());
            session.setAttribute("telefono", cliente.getTelefono());
            session.setAttribute("direccion", cliente.getDireccion());
            session.setAttribute("usuario", user.getNombre());
            session.setAttribute("contrasena", user.getContrasena());
            session.setAttribute("correo", user.getCorreo());
            session.setAttribute("idCliente", cliente.getIdCliente());
            
            // Crear una respuesta JSON indicando el éxito
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", true);
            
            // Enviar la respuesta JSON al cliente
            response.getWriter().write(jsonResponse.toString());          
        } else {
            // Crear una respuesta JSON indicando el error
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", false);
            jsonResponse.put("message", "Usuario o contraseña incorrecta");
            
            // Enviar la respuesta JSON al cliente
            response.getWriter().write(jsonResponse.toString());
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
