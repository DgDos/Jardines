$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "ActividadS",
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
        url: "ActividadS",
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
        url: "ActividadS",
        //force to handle it as text
        data: {
            'opcion': "2",
            'tema': $('#tema').val()
        },
        dataType: "text",
        success: function (data) {
            $('#nombreaparece').removeAttr('style');
            var selectForm = $('#actividades');
            var boton= $('#botonsito');
            boton.removeAttr('style');
            $('#actividades').removeAttr('style');
            selectForm.empty();
            selectForm.append('<p style=\"\" >Actividades: </p>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var j=i+1;
                var opcion = "<p style=\"\" >"+j+". "+json[i].nombre+"</p>";
                selectForm.append(opcion);
            }
            selectForm.append("<br><p style=\"\" >Quiere agregar otro?</p>");
        },
        async: false
    });
});

$('#SelectCM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "ActividadS",        
        data: {
            'tema': $('#tema').val(),
            'nombre': $('#nombre').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Actividad agregada exitosamente');
        location.reload();
        },
        async: false
    });
});

