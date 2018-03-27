$('#verCursosMateria').click(function () {
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            $('#tablaCM').removeAttr('style');
            $('#SelectCM').attr('style', 'display: none;');
            var selectForm = $('#tablaCM');
            selectForm.empty();
            selectForm.append('<tr><td style="color:white" >Curso</td><td style="color:white" >Materia</td><td style="color:white" >Profesor</td> </tr>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"color:white\" >" + json[i].curso + "</td><td style=\"color:white\" >" + json[i].materia + "</td><td style=\"color:white\" >" + json[i].profesor + "</td> </tr>";
                selectForm.append(opcion);
            }

        },
        async: false
    });
});
$(document).ready(function () {
    $('#crearCursoMateria').click(function () {
        //curso
        $.ajax({
            type: 'GET',
            url: "CursoMateriaS",
            //force to handle it as text
            data: {
                'opcion': "1",
                'var': "0"
            },
            dataType: "text",
            success: function (data) {
                $('#SelectCM').removeAttr('style');
                $('#tablaCM').attr('style', 'display: none;');
                var selectForm = $('#curso');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione un curso</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }

            },
            async: false
        });
        //materia
        $.ajax({
            type: 'GET',
            url: "CursoMateriaS",
            //force to handle it as text
            data: {
                'opcion': "1",
                'var': "1"
            },
            dataType: "text",
            success: function (data) {
                $('#SelectCM').removeAttr('style');
                $('#tablaCM').attr('style', 'display: none;');
                var selectForm = $('#materia');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione una materia</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].idMateria + "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }

            },
            async: false
        });
        //profesor
        $.ajax({
            type: 'GET',
            url: "CursoMateriaS",
            //force to handle it as text
            data: {
                'opcion': "1",
                'var': "2"
            },
            dataType: "text",
            success: function (data) {
                $('#SelectCM').removeAttr('style');
                $('#tablaCM').attr('style', 'display: none;');
                var selectForm = $('#profesor');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione un profesor</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].idProfesor + "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }

            },
            async: false
        });
    });
});
$('#SelectCM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoMateriaS",        
        data: {
            'curso': $('#curso').val(),
            'materia': $('#materia').val(),
            'profesor': $('#profesor').val(),
            'fechainicio': $('#fecha').val()
            
        },
        dataType: "text",
        success: function (data) {
            
        },
        async: false
    });
});
