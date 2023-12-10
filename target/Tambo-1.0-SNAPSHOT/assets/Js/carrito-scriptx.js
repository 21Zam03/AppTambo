/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$.ajax({
    url: "ListaCar",
    type: "GET",
    success: function (result) {
        var selector = $('#carritos');
        result.forEach(function (element) {
            selector.append('<option value="' + element.nombre + '">' + element.nombre + '</option>');
        });
    }
});

$('#carritos').change(function () {
    if ($('.boton-x').length > 0) {
        $('.fila-p .col1').remove();
        $('.total .col1').remove();
    }
    $.ajax({
        url: "Carrito",
        type: "GET",
        data: {
            carrito: $('#carritos').val()
        },
        success: function (result) {
            console.log(result);
            //Obtenemos la clase fila3 y lo guardamos en la variable fila
            var fila = $('.fila-p');
            var fila2 = $('.total');
            //El result nos devolvera un Json con una lista de productos lo cual utilizaremos un forEach para recorrerlo
            var resultado_total = 0;
            var resultado_total_aproximado = 0;
            result.forEach(function (element) {
                var num1 = element.precio;
                var num2 = element.cantidad;
                var resultado = num1 * num2;
                var resultado_aproximado = Number(resultado.toFixed(2));
                //Utilizamos el metodo append para agregar un div con la clse cuadro a la variable fila          
                fila.append('<div class="col-12 col-md-12 col-lg-2 col1"><img src="assets/Img/Productos/' + element.producto.foto + '"></div>');
                fila.append('<div class="col-12 col-md-12 col-lg-2 col1"><p>' + element.producto.nombre + '</p></div>');
                fila.append('<div class="col-12 col-md-12 col-lg-2 col1"><p>S/ ' + element.precio + '</p></div>');
                fila.append('<div class="col-12 col-md-12 col-lg-2 col1"><input type="number" id="cantidad" name="cantidad" min="1" value="' + element.cantidad + '"></div>');
                fila.append('<div class="col-12 col-md-12 col-lg-2 col1"><p>S/ ' + resultado_aproximado + '</p></div>');
                fila.append('<div class="col-12 col-md-12 col-lg-1 col1"><input class="codigo" type="text" value="' + element.producto.idProducto + '" hidden><button class="boton-x" onclick="eliminarProducto(this)">X</button></div>');
                resultado_total += resultado;
                resultado_total_aproximado = Number(resultado_total.toFixed(2));
            });
            fila2.append('<div class="col-12 col-md-12 col-lg-2 col1"></div>');
            fila2.append('<div class="col-12 col-md-12 col-lg-2 col1"><P>Total a pagar: S/ ' + resultado_total_aproximado + '</P></div>');
            fila2.append('<div class="col-12 col-md-12 col-lg-2 col1"></div>');
            fila2.append('<div class="col-12 col-md-12 col-lg-2 col1"><button onclick="comprar()">Comprar</button></div>');
            fila2.append('<div class="col-12 col-md-12 col-lg-2 col1"></div>');
            fila2.append('<div class="col-12 col-md-12 col-lg-1 col1"></div>');
        }
    });
});

function eliminarProducto(button) {
    var div = $(button).parent(".col1");
    var input = div.find(".codigo");
    var codigo = input.val();   
    var carrito = $('#carritos').val();
    $.ajax({
        url: "Eliminar",
        type: "POST",
        data: {
            producto: codigo,
            carrito: carrito
        },
        success: function (result) {
            alert("Se elimino el producto de la lista con exito");
            location.reload();
        }
    });
}

function comprar() {;   
    var carrito = $('#carritos').val();
    $.ajax({
        url: "Comprar",
        type: "POST",
        data: {
            carrito: carrito
        },
        success: function (result) {
            alert("Se realizo la compra con exito");
            location.reload();
        }
    });
}
