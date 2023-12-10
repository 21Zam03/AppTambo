<%-- 
    Document   : productos
    Created on : 26 may. 2023, 21:45:06
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String categoria = (String) request.getAttribute("categoria");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${categoria}</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/productos-style.css"/>
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
            <div class="container-fluid contenedor">
                <div class="row fila1">
                    <div class="col-3 col-md-3 col-lg-3 columna1">
                        <img src="assets/Img/Icons/lupita.svg">
                    </div>
                    <div class="col-9 col-md-9 col-lg-9 columna2">
                        <input type="text" placeholder="Buscar productos en categoria">
                    </div>
                </div>
            </div>
            <div class="container-fluid contenedor2">
                <div class="row fila1">
                    <h1 id="titulo">${categoria}</h1>
                </div>
            </div>
        </main>
        <script src="assets/Js/productos-script.js"></script>
    </body>
</html>
