/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$.ajax({
    url: "ListaCar",
    type: "GET",
    success: function (result) {
        console.log(result);
        var selector = $('#carritos');
        result.forEach(function (element) {
            selector.append('<option value="' + element.nombre + '">' + element.nombre + '</option>');
        });
    }
});

$('#carritos').change(function () {
    var selector = $(this).val();
    if (selector === 'Crear Nueva') {
        if ($('#nombre-carrito').length > 0) {
            console.log("ya existe");
        } else {
            var div = $('.producto-info');
            div.append('<label for="nombre-carrito" id="lbl">Nombre:</label><input type="text" id="nombre-carrito">');
        }
    } else {
        $('#nombre-carrito').remove();
        $('#lbl').remove();
    }
});

function agregarProducto() {
    var idProducto = $('.columna1 #idProducto').val();
    var cantidad = $('#cantidad').val();
    var carrito = $('#carritos').val();
    var nombre = $('#nombre-carrito').val();
    $.ajax({
        url: "Agregar",
        type: "POST",
        data: {
            idProducto: idProducto,
            cantidad: cantidad,
            carrito: carrito,
            nombre: nombre
        },
        success: function (result) {
            window.location.href = "http://localhost:8080/Tambo/categorias.jsp";
            alert("Se agrego el producto al carrito de ventas!");
        }
    });
}

function irAcarrito() {
    $.ajax({
        url: "Agregar",
        type: "POST",
        data: {
            valor: "2"
        },
        success: function (result) {
            console.log(result);
//        //Obtenemos la clase fila3 y lo guardamos en la variable fila
//        var fila = $('.contenedor2 .fila1');
//        //El result nos devolvera un Json con una lista de productos lo cual utilizaremos un forEach para recorrerlo
//        result.forEach(function(element) {        
//            //Utilizamos el metodo append para agregar un div con la clse cuadro a la variable fila
//            fila.append('<div class="cuadro"><a href="Producto?codigo='+element.idProducto+'"><img src="assets/Img/Productos/'+element.foto+'" alt="alt"/></a><h2>'+element.nombre+'</h2><p>S/ '+element.precio+'</p></div>');           
//        });
//        //Finalmente de la clase cuadro creado, le agregamos una nueva clase de bootstrap
//        $('.cuadro').addClass('col-6 col-md-3 col-lg-3');
        }
    });
}


