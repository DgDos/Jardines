<nav class="navbar navbar-expand-md fixed-top" color-on-scroll="500" style="background-color: white">
    <div class="container">
        <div class="navbar-translate">
            <button class="navbar-toggler navbar-toggler-right navbar-burger" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
            </button>
            <a class="navbar-brand" href="menuAdmin.jsp">Jardin Infantil</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarToggler">
            <ul class="navbar-nav ml-auto">               

                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-circle-10"></i>Gestion Estudiante</a>
                    <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="crearEstudiante.jsp">Crear Estudiante</a>
                        <a class="dropdown-item" href="editarEstudiante.jsp">Editar Estudiante</a>
                        <a class="dropdown-item" href="verEstudiante.jsp">Ver Estudiante</a>
                        <a class="dropdown-item" href="eliminarEstudiante.jsp">Eliminar Estudiante</a>
                         <a class="dropdown-item" href="ubicarEstudiante.jsp">Asignar Estudiante</a>
                    </ul>
                </div>
            

                <div class="collapse navbar-collapse" id="navbarToggler">
                    <ul class="navbar-nav ml-auto">               

                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-single-02"></i>Gestion Profesor</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="crearProfesor.jsp">Crear Profesor</a>
                                <a class="dropdown-item" href="editarProfesor.jsp">Editar Profesor</a>
                                <a class="dropdown-item" href="verProfesor.jsp">Ver Profesor</a>
                                <a class="dropdown-item" href="eliminarProfesor.jsp">Eliminar Profesor</a>
                                <a class="dropdown-item" href="ubicarDirector.jsp">Asignar Profesor</a>
                            </ul>
                        </div> 
                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-ruler-pencil"></i>Gestion Curso</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="addCurso.jsp">Crear Curso</a>
                                <a class="dropdown-item" href="verCurso.jsp">Ver Curso</a>                             
                            </ul>
                        </div>
                     
                         <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-single-copy-04"></i>Curso/ Materia</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="cursoMateria.jsp">Crear Curso/Materia</a>
                                <a class="dropdown-item" href="vercursoMateria.jsp">Ver Curso/Materia</a>                             
                            </ul>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-tile-56"></i>Gestion Materia</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="addMateria.jsp">Crear Materia</a>
                                <a class="dropdown-item" href="verMateria.jsp">Ver Materias</a>                             
                            </ul>
                        </div>
                        <li class="nav-item">
                            <a href="tema.jsp"  class="nav-link"><i class="nc-icon nc-bullet-list-67"></i> Gestion Tema</a>
                        </li>
                        <li class="nav-item">
                            <a href="Login?action=salir" class="nav-link"><i class="nc-icon nc-button-power"></i> Logout</a>
                        </li>
                    </ul>
                </div>
        </div>
</nav>
<br>