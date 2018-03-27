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

        <title>Observador</title>

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
                        <a>
                            <button type="button"  type="text" name="crearCursoMateria" class="btn btn-default btn-round" id="crearCursoMateria">Crear Curso Materia</button>
                        </a>
                        <a>
                            <button type="button"  type="text" name="verCursosMateria" class="btn btn-default btn-round" id="verCursosMateria">Ver Cursos Materias</button>
                        </a>
                        <br>
                        <br>
                        <br>
                        <form id="SelectCM" style="display: none;">                                
                            <div>
                                <label style="color:white">Curso: </label>
                                <select class="form-control" required name="curso" id="curso">
                                    <option value="" selected disabled>Seleccione un curso</option>
                                </select> 
                                <br>
                                <label style="color:white" >Materia: </label>
                                <select required name="materia" id="materia" class="form-control">
                                    <option value="" selected  disabled>Seleccione una materia</option>
                                </select>   
                                <br>
                                <label style="color:white" >Profesor: </label>
                                <select required name="profesor" id="profesor" class="form-control">
                                    <option value="" selected  disabled>Seleccione un profesor</option>
                                </select>
                                <br>
                                <label style="color:white" >Fecha de Inicio: </label>
                                <div class="row">
                                <div class='col-sm-6'>
                                    <div class="form-group">
                                        <div class='input-group date'  id='datetimepicker' >
                                            <input  id="fecha" name="fecha" type='text' class="form-control datetimepicker" placeholder="MM/DD/AAAA" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                               <br>
                                <br>
                                <button type="submit" class="btn btn-neutral" name="Enviar">Ubicar</button>
                            </div>  
                        </form>
                        <table id="tablaCM" class="table table-hover" style="display: none;">

                        </table>                                                           
                    </div>
                </div>

            </div>

    </body>
    <script src="assets/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.12.1.custom.min.js" type="text/javascript"></script>
    <script src="assets/js/popper.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Plugins for Slider -->
    <script src="assets/js/nouislider.js"></script>
    <script src="js/app/cursoMateria.js"></script>
</html>
