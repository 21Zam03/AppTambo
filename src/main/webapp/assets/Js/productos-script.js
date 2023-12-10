/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$.ajax({
    url: "Imagenes",
    type: "GET",
    data: {
        categoria: $('#titulo').text()
    },
    success: function(result) {
        console.log(result);
        //Obtenemos la clase fila3 y lo guardamos en la variable fila
        var fila = $('.contenedor2 .fila1');
        //El result nos devolvera un Json con una lista de productos lo cual utilizaremos un forEach para recorrerlo
        result.forEach(function(element) {        
            //Utilizamos el metodo append para agregar un div con la clse cuadro a la variable fila
            fila.append('<div class="cuadro"><a href="Producto?codigo='+element.idProducto+'"><img src="assets/Img/Productos/'+element.foto+'" alt="alt"/></a><h2>'+element.nombre+'</h2><p>S/ '+element.precio+'</p></div>');           
        });
        //Finalmente de la clase cuadro creado, le agregamos una nueva clase de bootstrap
        $('.cuadro').addClass('col-6 col-md-3 col-lg-3');
   }
});

