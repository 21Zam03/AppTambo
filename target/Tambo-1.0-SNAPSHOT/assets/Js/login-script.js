/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function validar() {
    var usuario = $('#usuario').val();
    var contrasena = $('#contrasena').val();
    $.ajax({
        url: "Login",
        type: "POST",
        data: {
            //Guardamos en las variables usuario y contrasena los valores que seran ingresado por el usuario
            usuario: usuario,
            contrasena: contrasena
        },
        success: function (response) {
            if (response.success) {
                window.location.href = "index.jsp";
            } else {
                console.log(response);
                var mensajeError = response.message;
                $("#mensaje").text(mensajeError);
            }
        }
    });
}

function crearCuenta() {
    window.location.href = "http://localhost:8080/Tambo/signUp.jsp";
}

