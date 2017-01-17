<%-- 
    Document   : login
    Created on : 05/10/2016, 08:29:54 AM
    Author     : Byron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html >

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inicio de Sesión</title>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/login.css">
        <script src='js/jquery.min.js'></script>
        <script src="js/Utils.js"></script>
        <script src="js/login.js"></script>
        <script src="js/Proxy.js"></script>
        <script src="js/BaseDatos.js"></script>
        <script src="js/objects/ActaDecomiso.js"></script>
        <script src="js/objects/Decomiso.js"></script>
        <script src="js/objects/Distrito.js"></script>
        <script src="js/objects/Funcionario.js"></script>
        <script src="js/objects/Interesado.js"></script>
        <script src="js/objects/Lugar.js"></script>
        <script src="js/objects/Persona.js"></script>
        <script src="js/objects/Policia.js"></script>
        <script src="js/objects/Testigo.js"></script>  
        <script src="js/objects/Usuario.js"></script>   
        <link rel="shortcut icon" href="media/images/logo2.ico" type="image/x-icon" />
        
    </head>
    <body>
        <div class="login_wrapper">
            <div class="animate form login-form">
                <section class="login-content">
                        <h1>Sistema de Gestión de Decomisos</h1>
                        <div class="logo ">
                            <img src="media/images/logo.png" alt="logo">
                        </div>
                        <div class="form-group log-status">
                            <input type="text"  class="form-control" placeholder="Usuario" id="UserName" onkeyup="actionKey(event);">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group log-status">
                            <input type="password"  class="form-control" placeholder="Contraseña" id="PassWord" onkeyup="actionKey(event);">
                            <i class="fa fa-lock"></i>
                        </div>
                        <span class="alert">¡Datos Erróneos! <br/>Si ha olvidado la contraseña, contacte con el administrador.</span>
                        <button class="log-btn" id="login">Iniciar Sesión </button> 
                        
                    
                </section>
            </div>
        </div>
    </body>
    
    
</html>