<%-- 
    Document   : signUp
    Created on : 11 may. 2023, 17:34:45
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/login-estilo.css"/>
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
                <div class="row justify-content-center formulario">
                    <div class="col-4 login-columna1">
                        <img src="assets/Img/Icons/logo.png">
                        <input type="text" id="usuario" placeholder="Ingrese su usuario" autocomplete="current-user">
                        <input type="password" id="contrasena" placeholder="Ingrese su contraseña" autocomplete="current-password">
                        <p id="mensaje">----------------------</p>
                        <div class="botones">
                            <button class="boton-create" onclick="crearCuenta();">Crearme una cuenta</button>
                            <button class="boton-login" onclick="validar();">Iniciar Sesión</button>
                        </div>
                    </div>
                    <div class="col-4 login-columna2">
                        <img src="assets/Img/Icons/tambo_login.jpg" alt="??">
                    </div>
                </div>
            </div>
        </main>
        <script src="assets/Js/login-script.js"></script>
    </body>
</html>
