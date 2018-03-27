<%@page import="Modelo.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        Profesor p = (Profesor) request.getSession().getAttribute("profesor");
        if (p != null) {
            if (p.getTipoU() == 1) {
                response.sendRedirect("menuProfesor.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Gestion Estudiante</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/paper-kit.css?v=2.1.0" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />

        <!--     Fonts and icons     -->
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,300,700' rel='stylesheet' type='text/css'>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />

    </head>
    <body style="background-color:black">
        <%@include file="headerAdmin.jsp" %>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <br>
                    <br>
                    <br>
                    <br>
                    <div class="container">
                        <a class href="crearEstudiante.jsp">
                            <button type="text" class="btn btn-default btn-round" id="botonCrear"> Crear Estudiante</button>
                        </a>                      
                        <a  href="editarEstudiante.jsp">
                            <button type="text" class="btn btn-default btn-round" id="editarBoton">Editar Estudiante</button>
                        </a>                      
                        <a  href="verEstudiante.jsp">
                            <button   type="text" class="btn btn-default btn-round" id="botonVer">Ver Estudiante</button>  
                        </a>                       
                        <a  href="eliminarEstudiante.jsp">
                            <button   type="text" class="btn btn-default btn-round" id="botonEliminar">Eliminar Estudiante</button>  
                        </a>

                    </div>
                    <br>



                    <div  class="form-group"  >
                        <label style="color:white" >Buscar Estudiante:</label>
                        <select class="form-control" required name="documento" id="documento">
                            <option value="" selected disabled>Seleccione el estudiante</option>
                        </select> 
                    </div>

                    <form id="EditarE"  >

                        <br>
                        <div class="form-group">
                            <label style="color:white">Documento:</label>
                            <input  class="form-control form-control-success" id="documento2" readonly="readonly" >
                        </div>
                        <div class="form-group">
                            <label style="color:white" >Nombre:</label>
                            <input  class="form-control form-control-success" id="nombre" value="">
                        </div>
                        <div class="form-group">
                            <label style="color:white">Fecha de Nacimiento:</label>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <div class='input-group date'  id='datetimepicker' >
                                                <input  id="fechanacimiento" name="fecha" type='text' class="form-control datetimepicker" placeholder="MM/DD/AAAA" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Direccion:</label>
                            <input  class="form-control form-control-success" id="direccion"  value="">
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Celular de contacto:</label>
                            <input  class="form-control form-control-success"  id="celularcontacto" value="">
                        </div>
                        <div class="form-group">
                            <label style="color:white">Tipo de sangre:</label>
                            <input  class="form-control form-control-success" id="tiposangre"  value="">
                        </div> 
                        <button type="submit" class="btn btn-neutral" name="Enviar">Enviar</button>
                    </form>





                </div>
            </div>




    </body>
    <script src="assets/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.12.1.custom.min.js" type="text/javascript"></script>
    <script src="assets/js/popper.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!-- Switches -->
    <script src="assets/js/bootstrap-switch.min.js"></script>

    <!--  Plugins for Slider -->
    <script src="assets/js/nouislider.js"></script>

    <!--  Plugins for DateTimePicker -->
    <script src="assets/js/moment.min.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.min.js"></script>

    <!--  Paper Kit Initialization and functons -->
    <script src="assets/js/paper-kit.js?v=2.1.0"></script>
    <script src="js/app/gestionEstudiante.js"></script>
</html>

