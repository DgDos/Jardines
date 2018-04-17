$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectCM').removeAttr('style');
            var selectForm = $('#cm');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione uno</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idcm + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    
});

$('#cm').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            $('#actividades').removeAttr('style');
            $('#botonsito').attr('style', 'display: none;');
            var selectForm = $('#tema');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un tema</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idTema + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});


$('#tema').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as te
        data: {
            'opcion': "2",
            'tema': $('#tema').val()
        },
        dataType: "text",
        success: function (data) {

            var selectForm = $('#actividades');
            var boton= $('#botonsito');
            boton.removeAttr('style');
            $('#actividades').removeAttr('style');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione una actividad</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
            
                var opcion = "<option value=\"" + json[i].id + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
            },
        async: false
    });
});
$('#actividades').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as te
        data: {
            'opcion': "3",
            'actividad': $('#actividades').val()
        },
        dataType: "text",
        success: function (data) {
            $('#tablaNota').removeAttr('style');
            $('#AddNota').removeAttr('style');
            var selectForm = $('#tablaNota');
            selectForm.empty();
            selectForm.append('<tr><td>Estudiante</td><td>Nota</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].idEstudiante + "</td><td>" + json[i].nota + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});

$('#AddNota').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "NotaS",
        data: {
            'nota': $('#nota').val(),
            'idEstudiante': $('#estudiante').val(),
            'id':$('#actividad').val()
        },
        dataType: "text",
        success: function (data) {

        },
        async: false
    });
});


