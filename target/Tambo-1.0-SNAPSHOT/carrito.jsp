<%-- 
    Document   : compras
    Created on : 28 may. 2023, 11:15:34
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/carrito-estilo.css"/>
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
            <div class="container-fluid">
                <div class="row justify-content-center fila-titulo">
                    <div class="col-12 col-md-12 col-lg-12 col1">
                        <div class="logo-contenedor">
                            <img src="assets/Img/Icons/logo.png">
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center encabezado">
                    <div class="col-12 col-md-12 col-lg-2 col1">
                        <label for="carritos" id="lbl">Seleccionar: </label><br>
                        <select id="carritos">
                            <option value="opcion1">----</option>
                        </select>
                    </div>
                    <div class="col-12 col-md-12 col-lg-2 col1">
                        <p>Nombre</p>
                    </div>
                    <div class="col-12 col-md-12 col-lg-2 col1">
                        <p>Precio</p>
                    </div>
                    <div class="col-12 col-md-12 col-lg-2 col1">
                        <p>Cantidad</p>
                    </div>
                    <div class="col-12 col-md-12 col-lg-2 col1">
                        <p>Total</p>
                    </div>
                    <div class="col-12 col-md-12 col-lg-1 col1">

                    </div>
                </div>
                <div class="row justify-content-center fila-p">
                </div>
                <div class="row justify-content-center total">
                </div>
            </div>
        </main>
        <script src="assets/Js/carrito-scriptx.js"></script>
    </body>
</html>
