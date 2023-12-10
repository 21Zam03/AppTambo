<%-- 
    Document   : configuracionCuenta
    Created on : 29 may. 2023, 13:02:56
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi cuenta</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/miCuenta-estilo.css"/>
        <!--Libreria bootstrap-->
        <link rel="stylesheet" href="assets/Css/Bootstrap/bootstrap.min.css"/>
        <!--Estilo para el navegador-->
        <link rel="stylesheet" href="assets/Css/navegador-estilo.css"/>
        <!--Libreria Jquery -->
        <script src="assets/Js/Jquery/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <main>
            <%@include file="WEB-INF/fragments/menu.jspf"%>
            <div class="container-fluid">
                <div class="row justify-content-center fila-datos">
                    <div class="col-12 col-md-12 col-lg-6 col1">
                        <h1>Configuracion de cuenta</h1>
                        <h2>Datos de cliente</h2>
                        <label for="nombre">Nombre: </label>
                        <input type="text" id="nombre" value="${nombre}"><br>
                        <label for="dni">Dni: </label>
                        <input type="text" id="dni" value="${dni}"><br>
                        <label for="dni">Telefono: </label>
                        <input type="text" id="telefono" value="${telefono}"><br>
                        <label for="direccion">Direccion: </label>
                        <input type="text" id="direccion" value="${direccion}"><br>
                        <button>Guardar Cambios</button>
                        <h2 class="titulo-usuario">Datos de usuario</h2>
                        <label for="usuario">Usuario: </label>
                        <input type="text" id="usuario" value="${usuario}"><br>
                        <label for="contrasena">Contraseña: </label>
                        <input type="password" id="contrasena" value="${contrasena}"><br>
                        <label for="contrasena2">Nueva Contraseña: </label>
                        <input type="password" id="contrasena2"><br>
                        <button>Cambiar Contraseña</button>
                        <button class="boton-cerrar-sesion" onclick="cerrarSesion();">Cerrar Sesion</button>
                    </div>
                </div>
            </div>
        </main>
        <script src="assets/Js/miCuenta-script.js"></script>
    </body>
</html>
