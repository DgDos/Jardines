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
            $('#actividades').attr('style', 'display: none;');
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
        //force to handle it as text
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
            selectForm.append('<option selected  value="" disabled>Seleccione un tema</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var j=i+1;
                var opcion = "<p style=\"\" >"+j+". "+json[i].nombre+"</p>";
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
        //force to handle it as text

        data: {
            'opcion': "2",
            'estudiante': $('#estudiante').val()
        },
        dataType: "text",
        success: function (data) {
            $('#tablaNota').removeAttr('style');
            $('#AddNota').removeAttr('style');
            var selectForm = $('#tablaNota');
            selectForm.empty();
            selectForm.append('<tr><td>Detalles</td><td>Calificacion</td><td>Profesor</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].curso + "</td><td>" + json[i].materia + "</td><td>" + json[i].profesor + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});
$('#SelectCM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "NotaS",        
        data: {
            'tema': $('#tema').val(),
            'nombre': $('#nombre').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Nota agregada exitosamente');
        location.reload();
        },
        async: false
    });
});
