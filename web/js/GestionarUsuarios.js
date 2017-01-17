$(document).ready(function () {
    pageLoad();
});
function showPopUp(action) {

    cargarListado();
    $("#modalAgregarUsuario").modal('show');
    if (action == "editar") {

    }
}
function cargarListado() {
    if (document.getElementById("funcionarioRadio").checked) {
        Proxy.listadoFuncionarios();
    } else {
        Proxy.listadoPolicias();
    }
}
function mouseoverPass(obj) {
    var obj = document.getElementById('pass');
    obj.type = "text";
}
function mouseoutPass(obj) {
    var obj = document.getElementById('pass');
    obj.type = "password";
}
function guardarUsuario() {
    var activo = document.getElementById("activo");
    var privilegio = document.getElementById("esAdmin");
    var estado = 0;
    var priv = 0;
    if (activo.checked) {
        estado = 1;
    }
    if (privilegio.checked) {
        priv = 1;
    }

    var usuario = new Usuario(
            0,
            $("#nuevo_usuario").val(),
            $("#pass").val(),
            estado,
            priv
            );
    Proxy.guardarUsuario(JSON.stringify(usuario, replacer));
}
function validarCampos() {


    var exito = true;
    var refNombre = document.getElementById("listadoNombre");
    var refNick = document.getElementById("nuevo_usuario");
    var refPass = document.getElementById("pass");
    exito = (refNombre.value != "") && (refNick.value != "") && (refPass.value != "");
    if (exito) {
        guardarUsuario();
    } else {
        if (refNombre.value == "") {
            refNombre.className = "col-md-2 error";
            refNombre.title = "Nombre requerido";
        }
        else {
            refNombre.className = "col-md-2";
            refNombre.title = "";
        }

        if (refNick.value == "") {
            refNick.className = "col-md-2 error";
            refNick.title = "Nombre de usuario requerido";
        }
        else {
            refNick.className = "col-md-2";
            refNick.title = "";
        }
        if (refPass.value == "") {
            refPass.className = "col-md-2 error";
            refPass.title = "Contrase\u00F1a requerido";
        }
        else {
            refPass.className = "col-md-2";
            refPass.title = "";
        }

    }

    return exito;
}
function clearForm() {

    var refNick = document.getElementById("nuevo_usuario");
    var refPass = document.getElementById("pass");
    refNick.value = "";
    refPass.value = "";
    refNick.className = "col-md-2";
    refNick.title = "";
    refPass.className = "col-md-2";
    refPass.title = "";
}
function pageLoad() {
    chargeContainer();
}
function chargeContainer() {
    usuariosTable = document.getElementById("usuariosTable");
    loadTable();
    listadoUsuarios();
}
function loadTable() {
    var thead = document.createElement("thead");
    var tr = document.createElement("tr");
    var th0 = document.createElement("td");
    th0.appendChild(document.createTextNode("Codigo"));
    th0.setAttribute("align", "center");
    var th1 = document.createElement("td");
    th1.appendChild(document.createTextNode("Tipo de Usuario"));
    th1.setAttribute("align", "center");
    var th2 = document.createElement("td");
    th2.appendChild(document.createTextNode("Estado"));
    th2.setAttribute("align", "center");
    var th3 = document.createElement("td");
    th3.appendChild(document.createTextNode("Nombre"));
    th3.setAttribute("align", "center");
    var th4 = document.createElement("td");
    th4.appendChild(document.createTextNode("Nick"));
    th4.setAttribute("align", "center");
    var th5 = document.createElement("td");
    th5.appendChild(document.createTextNode("Administrador"));
    th5.setAttribute("align", "center");
    var th6 = document.createElement("td");
    th6.appendChild(document.createTextNode("Acciones"));
    th6.setAttribute("align", "center");
    tr.appendChild(th0);
    tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    tr.appendChild(th4);
    tr.appendChild(th5);
    tr.appendChild(th6);
    thead.appendChild(tr);
    var tbody = document.createElement("tbody");
    usuariosTable.appendChild(thead);
    usuariosTable.appendChild(tbody);
    usuariosTable.modelId = location.pathname.split("/").slice(-1) + "_" + usuariosTable.id;
    usuariosTable.toCell = usuariosTable_toCell;
}

function usuariosTable_toCell(obj, colIdx) {
    switch (colIdx) {

        case 0:
            content = document.createTextNode(obj.idUsuario);
            return content;
        case 1:
            content = document.createTextNode("Funcionario");
            return content;
        case 2:
            var estado = "Inactivo";
            if (obj.estado == 1) {
                estado = "Activo";
            }
            content = document.createTextNode(estado);
            return content;
        case 3:
            content = document.createTextNode(obj.contrasena);
            return content;
        case 4:
            content = document.createTextNode(obj.nick);
            return content;
        case 5:
            var privilegio = "No";
            if (obj.privilegio == 1)
                privilegio = "Si";
            content = document.createTextNode(privilegio);
            return content;
        case 6:
            var button = document.createElement("input");
            button.type = "button";
            button.value = "Editar";
            button.addEventListener("click", function (e) {
                editarUsuario(e.target);
            });
            content = button;
            return content;
    }
    ;
    return null;
}
function editarUsuario(i) {

    var tabla = i.parentNode.parentNode.parentNode.parentNode;
    var fila = 0;
    fila = Number(i.rowIdx);
    tbody = tabla.childNodes[2];
    row = tbody.childNodes[fila];

    var codigo = row.childNodes[0].innerHTML;
    var tipoUsuario = row.childNodes[1].innerHTML;
    var estado = row.childNodes[2].innerHTML;
    var nombre = row.childNodes[3].innerHTML;
    var nick = row.childNodes[4].innerHTML;
    var administrador = row.childNodes[5].innerHTML;

    $("#idUsuario").val(codigo);
    if (tipoUsuario == "Funcionario") {
        document.getElementById("funcionarioRadio").checked = true;
    } else {
        document.getElementById("policiaRadio").checked = true;
    }
    if (estado == "activo") {
        document.getElementById("activo").checked = true;
    } else {
        document.getElementById("inactivo").checked = true;
    }
    $("#nuevo_usuario").val(nick);
    if (administrador == "Si") {
        document.getElementById("esAdmin").checked = true;
    } else {
        document.getElementById("esAdmin").checked = false;
    }

    showPopUp('block', 'edit');

}
function listadoUsuarios() {
    Proxy.listadoUsuarios();
}



