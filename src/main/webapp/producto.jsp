<%-- 
    Document   : producto
    Created on : 27 may. 2023, 11:39:53
    Author     : DELL
--%>

<%@page import="com.zam.bean.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Producto producto = (Producto) request.getAttribute("producto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/producto-estilo.css"/>
        <!--Libreria bootstrap-->
        <link rel="stylesheet" href="assets/Css/Bootstrap/bootstrap.min.css"/>
        <!--Estilo para el navegador-->
        <link rel="stylesheet" href="assets/Css/navegador-estilo.css"/>
        <!--Libreria Jquery -->
        <script src="assets/Js/Jquery/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <%@include file="WEB-INF/fragments/menu.jspf"%>
        <main>
            <div class="container-fluid contenedor-banner">
                <div class="row justify-content-center producto-fila1">
                    <div class="col-5 columna1">
                        <img src="assets/Img/Productos/${producto.foto}" alt="alt"/>
                        <input type="text" id="idProducto" value="${producto.idProducto}" hidden>
                    </div>
                    <div class="col-5 columna2">
                        <div class="producto-nombre">
                            <h2>${producto.nombre}</h2>
                        </div>
                        <div class="producto-precio">
                            <p class="linea">Precio: S/ ${producto.precio}</p>
                        </div>
                        <div class="producto-cantidad">
                            <label for="cantidad">Cantidad:</label>
                            <input type="number" id="cantidad" name="cantidad" min="1" value="1">
                        </div>
                        <div class="producto-info">
                            <label for="carritos">Seleccionar: </label>
                            <select name="opciones" id="carritos">
                                <option value="opcion1">----</option>
                                <option value="Crear Nueva">Crear Nueva</option>
                            </select>                            
                        </div>
                        <button class="boton1" id="btnAgregar" onclick="agregarProducto();">Agregar al carrito</button>
                        <button class="boton2" id="btnAgregarFavorito">Agregar a favoritos</button>
                    </div>
                </div>
            </div>
        </main>
        <script src="assets/Js/producto-scriptx.js"></script>
    </body>
</html>
