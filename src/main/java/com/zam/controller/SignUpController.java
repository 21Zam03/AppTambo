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

@WebServlet(name = "SignUpController", urlPatterns = {"/SignUp"})
public class SignUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre_usuario = request.getParameter("nombre_usuario");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre_usuario);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarioDao.crearUsuario(usuario);
        
        String dni = request.getParameter("dni");
        String nombre_completo = request.getParameter("nombre_completo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        Cliente cliente = new Cliente();
        cliente.setDni(dni);
        cliente.setNombre(nombre_completo);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        Usuario user = usuarioDao.obtenerUsuario(nombre_usuario, contrasena);
        
        ClienteDao clienteDao = new ClienteDaoImpl();
        clienteDao.crearCliente(cliente, user.getIdUsuario());
        
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
