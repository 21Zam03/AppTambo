<%-- 
    Document   : categorias
    Created on : 8 may. 2023, 17:22:51
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/categorias-style.css"/>
        <!--Libreria bootstrap-->
        <link rel="stylesheet" href="assets/Css/Bootstrap/bootstrap.min.css"/>
        <!--Estilo para el navegador-->
        <link rel="stylesheet" href="assets/Css/navegador-estilo.css"/>
        <!--Libreria Jquery -->
        <script src="assets/Js/Jquery/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <%@include file="WEB-INF/fragments/menu.jspf"%>
        <div class="contenedor">
            <div class="tabla">
                <h2>Abarrotes</h2>
                <p>Los mejores abarrotes solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Abarrotes" class="boton" id="abarrotes" onclick="clickAbarrotes()">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla hover">
                <h2>Embutidos</h2>
                <p>Los mejores precios en embutidos solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Embutidos" class="boton" id="embutidos" onclick="">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla">
                <h2>Snacks</h2>
                <p>Los mejores ofertas en snaks solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Snacks" class="boton">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
        </div>
        <div class="contenedor">
            <div class="tabla">
                <h2>Hogar y limpieza</h2>
                <p>Los mejores abarrotes solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Hogar y limpieza" class="boton" id="abarrotes" onclick="clickAbarrotes()">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla hover">
                <h2>Cuidado Personal</h2>
                <p>Los mejores precios en embutidos solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Cuidado Personal" class="boton" id="embutidos" onclick="">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla">
                <h2>Preservativos</h2>
                <p>Los mejores ofertas en snaks solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Preservativos" class="boton">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
        </div>
        <div class="contenedor">
            <div class="tabla">
                <h2>Bebidas alcoholicas</h2>
                <p>Los mejores abarrotes solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Bebidas alcoholicas" class="boton" id="abarrotes" onclick="clickAbarrotes()">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla hover">
                <h2>Bebidas no alcoholicas</h2>
                <p>Los mejores precios en embutidos solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Bebidas no alcoholicas" class="boton" id="embutidos" onclick="">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
            <div class="tabla">
                <h2>Helados</h2>
                <p>Los mejores ofertas en snaks solo en tambo! aprovecha ya!</p>
                <a href="Categoria?categoria=Helados" class="boton">Ir a ver</a>
                <img src="assets/Img/Icons/logo.png">
            </div>
        </div>
    </body>
</html>
