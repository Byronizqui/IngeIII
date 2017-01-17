<%-- 
    Document   : actaDecomiso
    Created on : 26-oct-2016, 11:52:35
    Author     : Mery Zúñiga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Sistema de Gestión de Decomisos</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-checkbox.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="css/nprogress.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


        <!-- Custom Theme Style -->
        <link href="css/custom.min.css" rel="stylesheet">
        <link href="css/forms.css" rel="stylesheet">
        <link href="css/verificador.css" rel="stylesheet">
        <link rel="shortcut icon" href="media/images/logo2.ico" type="image/x-icon" />


    </head>

    <body class="nav-md">
        <div class="container body">
            <div id="modalAgregarUsuario" class="modal modal-wide fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Agregar Usuario</h4>
                        </div>
                        <div class="modal-body">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title" id="add_user">
                                        <h2>Datos del Usuario</h2>

                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content" >
                                        <div class="form-horizontal">
                                            <!--<form id="form_agregar_usuario" role="form" class="form-horizontal">-->
                                            <div class="form-group">
                                                <input type="hidden" id="idUsuario" value="0">
                                                <label for="tipoUsuario">Tipo de Usuario</label>
                                                <div>
                                                    <label class="radio-inline">
                                                        <input id="funcionarioRadio" type="radio" name="tipoUsuario" value="funcionario" checked onchange="cargarListado();">Funcionario 
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input id="policiaRadio" type="radio" name="tipoUsuario" value="policia" onchange="cargarListado();">Policía Municipal 
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="estado">Estado</label>

                                                <div>
                                                    <label class="radio-inline">
                                                        <input id="activo" type="radio" name="estado" value="activo" checked>Activo 
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input id="inactivo" type="radio" name="estado" value="inactivo">Inactivo 
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="listadoNombre">Nombre</label>
                                                <div>
                                                    <select id="listadoNombre"></select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="nuevo_usuario">Usuario</label>
                                                <div>
                                                    <input type="text" id="nuevo_usuario" class="col-md-4">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="pass">Contraseña</label>
                                                <div>
                                                    <input type="password" id="pass" class="col-md-2">
                                                    <div class="fa-hover col-md-2" ><a onmouseover="mouseoverPass();" onmouseout="mouseoutPass();"><i class="fa fa-eye"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="esAdmin">Administrador <input id="esAdmin" type="checkbox" /></label>
                                            </div>

                                            <div class="ln_solid"></div>
                                            <div class="form-group">
                                                <div align="center" id="alertError" class="alert alert-danger" style=" z-index: 1003; margin-left: 25%;display:none;">
                                                    <p id="labelAlertError" style="color:white;"> </p>
                                                </div>
                                                <div id="alertSuccess" class="alert alert-success" style=" z-index: 1003;margin-left: 25%;display:none;"> 
                                                    <p id="labelAlertSuccess" style=" color:white;"> </p>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-9 col-md-offset-3">
                                                    <button type="submit" class="btn btn-primary btn-sm" id="agregar_usuario" onclick="validarCampos();"><i class="fa fa-save" ></i> Agregar Usuario </button>
                                                    <button type="reset" class="btn btn-danger btn-sm" id="cancelar_agregar_usuario" data-dismiss="modal"><i class="fa fa-remove"></i> Cancelar</button>
                                                </div>

                                            </div>

                                            <!--</form>-->

                                        </div>
                                    </div>
                                </div>
                            </div> 
                        </div>

                        <div class="modal-footer">

                            <button type="button" class="btn btn-default" data-dismiss="modal" >Cerrar</button> 
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="home.jsp" class="site_title"><img src="media/images/logo_home.png"></a>
                        </div>

                        <div class="clearfix"></div>
                        <%@ include file="Fragmentos/side.jspf" %>
                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>
                            <%@ include file="Fragmentos/header.jspf" %>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->

                <div class="right_col" role="main">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div align="right">
                            <img src="media/images/addPersona.png" height="50" width="50" data-toggle="modal"  onclick="showPopUp('agregar');" title="Agregar nuevo usuario" >
                        </div>
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Usuarios existentes </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <table class="table" id="usuariosTable">
                                </table>
                            </div>
                        </div>
                    </div>

                    <!--<button class="btn btn-upload btn-dark " style=" margin-left: 20px;"><i class="fa fa-plus"></i> Agregar Usuario</button>-->

                </div>

                <!-- /page content -->


                <!-- footer content -->
                <footer>
                    <div class="pull-right">
                        Municipalidad de Heredia. 2016 Todos los derechos reservados.
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-checkbox.js"></script>
        <!-- FastClick -->
        <script src="js/fastclick.js"></script>
        <!-- NProgress -->
        <script src="js/nprogress.js"></script>
        <!--Date-->
        <script src="js/daterangepicker.js"></script>
        <script src="js/moment.min.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="js/custom.js"></script>
        <script src="js/home.js"></script>
        <script src="js/Proxy.js"></script>
        <script src="js/forms.js"></script>
        <script src="js/multifield.js"></script>
        <script src="js/validator.js"></script>
        <script src="js/objects/Funcionario.js"></script>
        <script src="js/objects/Policia.js"></script>
        <script src="js/objects/Usuario.js"></script>
        <script src="js/objects/Contenedor.js"></script>
        <script src="js/Utils.js"></script>
        <script src="js/BaseDatos.js"></script>
        <script src="js/Table.js"></script>
        <script src="js/Proxy.js"></script>
        <script src="js/GestionarUsuarios.js"></script>
    </body>
</html>

