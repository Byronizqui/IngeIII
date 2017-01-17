$(document).ready(function () {
//        $('.log-btn').click(function(){
//            $('.log-status').addClass('wrong-entry');
//           $('.alert').fadeIn(500);
//           setTimeout( "$('.alert').fadeOut(1500);",3000 );
//        });
    $('.form-control').keypress(function () {
        $('.log-status').removeClass('wrong-entry');
    });
    $('#login').click(function () {
        login();
    });
});
function login() {
    var nick = $("#UserName").val();
    var pass = $("#PassWord").val();
    var usuario = new Usuario(0,nick, pass,0,0);
    Proxy.userLogin(JSON.stringify(usuario, replacer));
}
function errorLogin() {
    $('.log-status').addClass('wrong-entry');
    $('.alert').fadeIn(500);
    setTimeout("$('.alert').fadeOut(1500);", 3000);
    document.getElementById('UserName').value = "";
    document.getElementById('PassWord').value = "";
}
function keyAction(event) {

    if (validateEnter(event) == true) {
        login();
    }

}
$(function () {
    //agrega los eventos las capas necesarias
    $("#enviarActa_Dec").click(function () {
        enviar();
    });
});

function enviar() {
    if (validar()) {

    }
    else
    {

    }
}


function validar() {
    var validacion = true;

    $("#groupIdPolicia").removeClass("has-error");
    $("#groupIdInteresado").removeClass("has-error");
    $("#groupLugar").removeClass("has-error");
    $("#groupFecha").removeClass("has-error");
    $("#groupIdTestigo").removeClass("has-error");

    if ($("#id_policia").val() === "") {
        $("#groupIdPolicia").addClass("has-error");
        validacion = false;
    }
    if ($("#id_interesado").val() === "") {
        $("#groupIdInteresado").addClass("has-error");
        validacion = false;
    }
    if ($("#lugar").val() === "") {
        $("#groupLugar").addClass("has-error");
        validacion = false;
    }
    if ($("#fecha").val() === "") {
        $("#groupFecha").addClass("has-error");
        validacion = false;
    }
    if ($("#id_acompanante").val() === "") {
        $("#groupIdTestigo").addClass("has-error");
        validacion = false;
    }
    return validacion;

}