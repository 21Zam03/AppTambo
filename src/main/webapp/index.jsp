<%-- 
    Document   : index
    Created on : 6 may. 2023, 15:30:58
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <!--Icono para la ventana de la pagina web-->
        <link rel="icon" type="image/png" href="assets/Img/Icons/icono-cabecera.png">
        <!--Estilo unico para este archivo html-->
        <link rel="stylesheet" href="assets/Css/index-estilo.css"/>
        <!--Estilo unico para el slide-->
        <link rel="stylesheet" href="assets/Css/slide-estilo.css"/>
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
                <div class="row fila1">
                    <div id="slides">
                        <input checked type="radio" name="slider" id="slide1" class="set" />
                        <input type="radio" name="slider" id="slide2" class="set" />
                        <input type="radio" name="slider" id="slide3" class="set" />
                        <input type="radio" name="slider" id="slide4" class="set" />

                        <div class="mask">
                            <div class="overflow">
                                <div class="slide">
                                    <img src="assets/Img/Slides/slide1.jpg" alt="image"/>
                                </div>
                                <div class="slide">
                                    <img src="assets/Img/Slides/slide2.jpg" alt="image" />
                                </div>
                                <div class="slide">
                                    <img src="assets/Img/Slides/slide3.jpg" alt="image"/>
                                </div>
                                <div class="slide">
                                    <img src="assets/Img/Slides/slide4.jpg" alt="image"/>
                                </div>
                            </div>
                        </div>
                        <div id="controls" onclick="">
                            <label for="slide1"></label>
                            <label for="slide2"></label>
                            <label for="slide3"></label>
                            <label for="slide4"></label>
                        </div>
                    </div>
                </div>
                <%if (usuario != null) { %>
                    <div class="row justify-content-center fila2">
                        <div class="col-12 col-md-12 col-lg-3 col-sugerencia"></div>
                        <div class="col-12 col-md-12 col-lg-3 col-sugerencia"><button onclick="verRecomendaciones()">Ver Recomendaciones</button></div>
                        <div class="col-12 col-md-12 col-lg-3 col-sugerencia"></div>
                    </div>
                    <div class="row fila3"></div>
                <%} else {%>
                    <div class="row justify-content-center fila2">
                        <div><h1>------------</h1></div>
                    </div>
                <%}%>
            </div>
        </main>
        <script src="assets/Js/index-script.js"></script>
    </body>
</html>
