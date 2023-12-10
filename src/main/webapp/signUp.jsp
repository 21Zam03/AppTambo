<%-- 
    Document   : SignUp
    Created on : 11 may. 2023, 21:46:08
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crearme una cuenta</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/signUp-estilo.css"/>
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
                <div class="row justify-content-center sign-contenedor">
                    <div class="col-5 sign-columna1">
                        <img src="assets/Img/Icons/logo.png">
                        <label for="txtDni">Dni</label>
                        <input type="text" id="txtDni" placeholder="Dni" autocomplete="current-user">                       
                        <label for="txtNombre">Nombre Completo</label>
                        <input type="text" id="txtNombre" placeholder="Nombre completo" autocomplete="current-user">  
                        <label for="txtUsuario">Usuario</label>
                        <input type="text" id="txtUsuario" placeholder="Usuario" autocomplete="current-user">                      
                        <label for="txtCorreo">Correo Electronico</label>
                        <input type="email" id="txtCorreo" placeholder="Correo Electronico" autocomplete="current-user">                        
                        <label for="txtTelefono">Telefono</label>
                        <input type="text" id="txtTelefono" placeholder="Telefono" autocomplete="current-user">                       
                        <label for="txtDireccion">Direccion</label>
                        <input type="text" id="txtDireccion" placeholder="Direccion" autocomplete="current-user">                        
                        <label for="txtFecha">Fecha de nacimiento</label>
                        <input type="date" id="txtFecha" placeholder="Nombre completo" autocomplete="current-user">                      
                        <div class="genero-lista">
                            <label for="sltGenero">Genero</label>
                            <select id="sltGenero">
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                                <option value="No definido">No definido</option>
                            </select>
                        </div>
                        <label for="txtContrasena1">Contraseña</label>
                        <input type="password" id="txtContrasena1" placeholder="Contraseña" autocomplete="current-user">
                        <p id="mensaje1">----------------------</p>
                        <input type="password" id="txtContrasena2" placeholder="Vuelva escribir su contraseña" autocomplete="current-user" disabled>
                        <p id="mensaje2">----------------------</p>
                        <div class="botones">
                            <button id="boton-crearCuenta1" class="boton-create" disabled>Crear cuenta</button>
                        </div>
                        <p class="p-cuentaNueva"><a href="login.jsp">¿Ya cuenta con una cuenta?</a></p>
                    </div>
                    <div class="col-5 sign-columna2">
                        <img src="assets/Img/Icons/portada.jpg" alt="??">
                    </div>
                </div>
            </div>
        </main>
        <script src="assets/Js/signUp-scriptx.js"></script>
    </body>
</html>
