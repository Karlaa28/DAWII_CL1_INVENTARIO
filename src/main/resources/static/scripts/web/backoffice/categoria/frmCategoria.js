$(document).on("click", "#btnagregar", function(){
    $("#categorianombre").val("");
    $("#comentario").val("");
    $("#chkestado").prop("checked", false);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#categorianombre").val($(this).attr("data-categorianombre"));
    $("#comentario").val($(this).attr("data-comentario"));
    $("#chkestado").val($(this).attr("data-chkestado"));
    listarCategorias();
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
        url: "/categorias/guardar",
        contentType: "application/json",
        data: JSON.stringify({
               nombre: $("#categorianombre").val(),
               comentario: $("#comentario").val(),
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


function listarCategorias(){
    $.ajax({
        type: "GET",
        url: "/categorias/listar",
        dataType: "json",
        success: function(resultado){
            $("#tbarticulos > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tbarticulos > tbody").append("<tr>"+
                    "<td>"+value.idCategoria+"</td>"+
                    "<td>"+value.nombre+"</td>"+
                     "<td>"+value.comentario+"</td>"+
                     "<td>"+value.fechacreacion+"</td>"+
                    "<td>"+value.fechaactualizacion+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idCategoria='"+value.idCategoria+"'"+
                                     "data-nombre='"+value.nombre+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}