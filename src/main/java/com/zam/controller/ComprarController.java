/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.zam.controller;

import com.zam.bean.Carrito;
import com.zam.bean.Cliente;
import com.zam.bean.ListaCarrito;
import com.zam.bean.Venta;
import com.zam.dao.CarritoDao;
import com.zam.dao.ClienteDao;
import com.zam.dao.DetalleVentaDao;
import com.zam.dao.ListaCarritoDao;
import com.zam.dao.VentaDao;
import com.zam.dao.impl.CarritoDaoImpl;
import com.zam.dao.impl.ClienteDaoImpl;
import com.zam.dao.impl.DetalleVentaDaoImpl;
import com.zam.dao.impl.ListaCarritoDaoImpl;
import com.zam.dao.impl.VentaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ComprarController", urlPatterns = {"/Comprar"})
public class ComprarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        int idCliente = (int) session.getAttribute("idCliente");
        
        String nombreCarrito = request.getParameter("carrito");
        
        CarritoDao carritoDao = new CarritoDaoImpl();
        Carrito carrito_final = carritoDao.obtenerCarrito(idCliente, nombreCarrito);
        
        ListaCarritoDao listaCarritoDao = new ListaCarritoDaoImpl();
        List<ListaCarrito> lista = listaCarritoDao.ObtenerListaCarrito(carrito_final.getIdCarrito());
        
        ClienteDao clienteDao = new ClienteDaoImpl();
        Cliente cliente = clienteDao.ObtenerCliente(idCliente);
        
        //Creamos la venta
        VentaDao ventaDao = new VentaDaoImpl();
        Venta venta = new Venta();       
        Date fechaActual = new Date();
        venta.setCliente(cliente);
        venta.setFecha(fechaActual);
        ventaDao.crearVenta(venta);
        
        //Creamos el detalle de venta
        venta = ventaDao.obtenerUltimaVenta(idCliente);
        
        DetalleVentaDao detalleVentaDao = new DetalleVentaDaoImpl();
        for (int i=0; i<lista.size(); i++) {
            detalleVentaDao.crearDetalleVenta(venta, lista.get(i).getProducto(), lista.get(i).getCantidad());
        }
        
        //Eliminamos la lista de carrito
        listaCarritoDao.eliminarListaCarrito(carrito_final.getIdCarrito());
        carritoDao.eliminarCarrito(carrito_final.getIdCarrito());
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
