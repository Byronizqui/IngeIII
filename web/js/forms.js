/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#nombre_testigo").change(function(){
        if($("#nombre_testigo").val() == "civil" ){
            $('#info_testigo_civil').show(); //muestro mediante id
            $('#info_testigo_policia').hide();
        }
    });
    ver_info_testigo();
});

function ver_info_testigo(){
    $("#nombre_testigo").change(function(){
        if($("#nombre_testigo").val() == "civil" ){
            $('#info_testigo_civil').show(); //muestro mediante id
            $('#info_testigo_policia').hide();
        }
        if($("#nombre_testigo").val() == "policia"){
            $('#info_testigo_civil').hide(); //muestro mediante id
            $('#info_testigo_policia').show()();
        }
        if($("#nombre_testigo").val() == "vacio"){
            $('#info_testigo_civil').hide(); //muestro mediante id
            $('#info_testigo_policia').hide();
        }
    });
}

$(function(){
	// Clona la fila oculta que tiene los campos base, y la agrega al final de la tabla
	$("#agregar").on('click', function(){
		$("#tabla tbody tr:eq(0)").clone().removeClass('fila-base').appendTo("#tabla tbody");
	});
 
	// Evento que selecciona la fila y la elimina 
	$(document).on("click",".eliminar",function(){
		var parent = $(this).parents().get(0);
		$(parent).remove();
	});
});

$(function () {
    //agrega los eventos las capas necesarias
    $("#enviarActa_Dec").click(function () {
        enviar();
    });
    $("#cancelarActa_Dec").click(function () {
        limpiarForm();
    });
});

function enviar(){
    if(validar()){
        
    }
    else
    {
        
    }
}


function validar(){
    var validacion = true;
    
     $("#groupNombrePolicia").removeClass("has-error");
     $("#groupIdInteresado").removeClass("has-error");
     $("#groupLugar").removeClass("has-error");
     $("#groupFecha").removeClass("has-error");
     $("#info_testigo_policia").removeClass("has-error");
     $("#nombre_civil").removeClass("has-error");
     $("#id_civil").removeClass("has-error");
     
     
     if ($("#id_policia").val() === "") {
        $("#groupNombrePolicia").addClass("has-error");
        validacion = false;
     }
     if ($("#direccion").val() === "") {
        $("#groupLugar").addClass("has-error");
        validacion = false;
     }
     if ($("#fecha").val() === "") {
        $("#groupFecha").addClass("has-error"); 
        validacion = false;
     }
     if ($("#info_policia").val() === "") {
        $("#info_test_policia").addClass("has-error"); 
        validacion = false;
     }
     if ($("#nombre_testigo").val() === "") {
        $("#nombre_civil").addClass("has-error"); 
        validacion = false;
     }
     if ($("#id_testigo").val() === "") {
        $("#id_civil").addClass("has-error"); 
        validacion = false;
     }
     if ($("#id_acompanante").val() === "") {
        $("#groupNombreTestigo").addClass("has-error");
        validacion = false;
     }
     return validacion;   
}

function limpiarForm(){
    $("#groupIdPolicia").removeClass("has-error");
    $("#groupLugar").removeClass("has-error");
    $("#groupFecha").removeClass("has-error");
    $("#id_civil").removeClass("has-error");
    $("#nombre_civil").removeClass("has-error");
    $("#info_test_policia").removeClass("has-error");
    $("#groupNombrePolicia").removeClass("has-error");
    $('#acta_decomiso').trigger("reset");
}
