$(document).on("click", "#btnagregar", function(){
    $("#txtnomproducto").val("");
    $("#txtpreciounit").val("");
    $("#hddcodprod").val("0");
    $("#cbocategoria").empty();
    $("#cboproveedor").empty();
    $("#switchproducto" ).show();
    $("#chkdescontinuado").prop("checked", false);
    listarCategorias(0,0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproducto").val($(this).attr("data-prodname"));
    $("#txtpreciounit").val($(this).attr("data-produnit"));
    $("#hddcodprod").val($(this).attr("data-prodcod"));
    $("#cbocategoria").empty();
    $("#cboproveedor").empty();

    listarCategorias($(this).attr("data-prodcateg"), $(this).attr("data-prodprov"));
    $("#switchproducto" ).show();
    console.log($(this).attr("data-descontinuado"));
    if($(this).attr("data-descontinuado") === "true"){
        $("#chkdescontinuado").prop("checked", true);
    }else
        $("#chkdescontinuado").prop("checked", false);
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){

    $.ajax({
        type: "POST",
        url: "/articulos/guardar",
        contentType: "application/json",
        data: JSON.stringify({
               nombre: $("#articulonombre").val(),
               preciounitario: $("#preciounitario").val(),
               precioventa: $("#precioventa").val(),
               idcategoria:Number($("#cbocategoria").val()),
               descripcion: $("#descripcion").val(),
               codigo: $("#codigo").val(),
               estado: $('#chkestado').prop('checked')?1:0
               }),
        success: function(resultado){
            if(resultado.respuesta){
                listarArticulos();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCategorias(idcategoria){
    $.ajax({
        type: "GET",
        url: "/categorias/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategoria").append(
                    `<option value="${value.idcategoria}">${value.nombre}</option>`
                )
            });
            if(idcategoria > 0){
                $("#cbocategoria").val(idcategoria);
            }

        }
    });
}

function listarArticulos(){
    $.ajax({
        type: "GET",
        url: "/product/listar",
        dataType: "json",
        success: function(resultado){
            $("#tbarticulos > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tbarticulos > tbody").append("<tr>"+
                    "<td>"+value.idarticulo+"</td>"+
                    "<td>"+value.categoria.nombre+"</td>"+
                     "<td>"+value.codigo+"</td>"+
                     "<td>"+value.imagenurl+"</td>"+
                    "<td>"+value.nombre+"</td>"+
                    "<td>"+value.precioventa+"</td>"+
                     "<td>"+value.descripcion+"</td>"+
                     "<td>"+value.fechacreacion+"</td>"+
                     "<td>"+value.fechaactualizacion+"</td>"+
                     "<td>"+value.estado+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idarticulo='"+value.idarticulo+"'"+
                                     "data-codigo='"+value.codigo+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}