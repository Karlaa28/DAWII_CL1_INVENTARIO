function listarCboRoles(idrol) {
    $.ajax({
        type: "GET",
        url: "/rol/listar", // Ajusta la URL según tu estructura de rutas
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cborol").append(
                    `<option value="${value.idrol}">${value.nombrerol}</option>`
                );
            });
            if (idrol > 0) {
                $("#cborol").val(idrol);
            }
        },
        error: function() {
            console.error("Error al obtener la lista de roles");
        }
    });
}

// Llamada a la función al hacer clic en el botón de agregar usuario
$(document).on("click", "#btnAgregar", function(){
    // Limpiar campos y listar roles
    $("#txtusuario").val("");
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txttelefono").val("");
    $("#txtcorreo").val("");
    $("#txtcomentario").val("");
    $("#cborol").empty();
    $("#chkestado").prop("checked", true);
    $("#hddcodusuario").val("0");

    listarCboRoles(0); // Llamar con idrol 0 al agregar un nuevo usuario

    // Mostrar el modal de Usuario
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/usuario/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idusuario: $("#hddcodusuario").val(),
            usuario: $("#txtusuario").val(),
            nombre: $("#txtnombre").val(),
            apellido: $("#txtapellido").val(),
            telefono: $("#txttelefono").val(),
            correo: $("#txtcorreo").val(),
            comentario: $("#txtcomentario").val(),
            estado: $('#chkestado').prop('checked'),
            idrol: $("#cborol").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarUsuarios();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtusuario").val($(this).attr("data-usuario"));
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtapellido").val($(this).attr("data-apellido"));
    $("#txttelefono").val($(this).attr("data-telefono"));
    $("#txtcorreo").val($(this).attr("data-correo"));
    $("#txtcomentario").val($(this).attr("data-comentario"));
    $("#hddcodusuario").val($(this).attr("data-usuarioid"));
    $("#cborol").empty();
    listarCboRoles($(this).attr("data-idrol"));
    $("#switchusuario").show();

    console.log($(this).attr("data-estado"));
        if($(this).attr("data-estado") === "true"){
            $("#chkestado").prop("checked", true);
        }else
            $("#chkestado").prop("checked", false);
        $("#modalNuevo").modal("show");
});



function listarUsuarios(){
    $.ajax({
        type: "GET",
        url: "/usuario/listar", // Asegúrate de tener la ruta correcta
        dataType: "json",
        success: function(resultado){
            $("#tblusuario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblusuario > tbody").append("<tr>"+
                    "<td>"+value.idusuario+"</td>"+
                    "<td>"+value.usuario+"</td>"+
                    "<td>"+value.nombre+"</td>"+
                    "<td>"+value.apellido+"</td>"+
                    "<td>"+value.telefono+"</td>"+
                    "<td>"+value.correo+"</td>"+
                    "<td>"+value.comentario+"</td>"+
                    "<td>"+value.rol.nombrerol+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-usuarioid='"+value.idusuario+"'"+
                                     "data-usuario='"+value.usuario+"'"+
                                     "data-nombre='"+value.nombre+"'"+
                                     "data-apellido='"+value.apellido+"'"+
                                     "data-telefono='"+value.telefono+"'"+
                                     "data-correo='"+value.correo+"'"+
                                     "data-comentario='"+value.comentario+"'"+
                                     "data-rol='"+value.rol.idrol+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}
