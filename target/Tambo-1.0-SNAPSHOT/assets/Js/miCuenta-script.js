/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function cerrarSesion() {
    $.ajax({
        url: "Cerrar",
        type: "POST",
        success: function (response) {
            window.location.href = "login.jsp";
        }
    });
}

