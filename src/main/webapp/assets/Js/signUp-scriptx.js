/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {
    $('#txtContrasena1').keyup(function () {
        var inputVal = $(this).val();
        if (inputVal.length < 10) {
            if (inputVal.length <= 0) {
                $('#mensaje1').text('----------------------');
                $('#mensaje1').css('color', 'white');
                $('#txtContrasena2').val('');
                $('#txtContrasena2').prop('disabled', true);
            } else {
                $('#mensaje1').text('El input debe tener al menos 5 caracteres');
                $('#mensaje1').css('color', 'red');
                $('#txtContrasena2').val('');
                $('#txtContrasena2').prop('disabled', true);
                $('#boton-crearCuenta1').prop('disabled', true);
            }
        } else {
            $('#mensaje1').text('Contraseña adecuada ✔');
            $('#mensaje1').css('color', 'white');
            $('#txtContrasena2').val('');
            $('#txtContrasena2').prop('disabled', false);
        }
    });
});

$(document).ready(function () {
    $('#txtContrasena2').keyup(function () {
        var inputVal = $(this).val();
        if (inputVal === $('#txtContrasena1').val()) {
            $('#mensaje2').text('Las contraseñas coinciden ✔');
            $('#mensaje2').css('color', 'white');
            $('#boton-crearCuenta1').prop('disabled', false);
        } else {
            if (inputVal === '') {
                $('#mensaje2').text('----------------------');
                $('#mensaje2').css('color', 'white');
            } else {
                $('#mensaje2').text('Las contraseñas no coinciden!');
                $('#mensaje2').css('color', 'red');
                $('#boton-crearCuenta1').prop('disabled', true);
            }
        }
    });
});

$(document).ready(function () {
    $('#boton-crearCuenta1').click(function () {
        $.ajax({
            url: "SignUp",
            type: "POST",
            data: {
                nombre_usuario: $('#txtUsuario').val(),
                correo: $('#txtCorreo').val(),
                contrasena: $('#txtContrasena1').val(),
                dni: $('#txtDni').val(),
                nombre_completo: $('#txtNombre').val(),
                telefono: $('#txtTelefono').val(),
                direccion: $('#txtDireccion').val()
            },
            success: function (result) {
                alert("Felicitaciones ha creado su cuenta con exito");
            }
        });
    });
});



