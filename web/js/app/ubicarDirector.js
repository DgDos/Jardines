$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "CursoS",
        //force to handle it as text
        data: {
            'op': "0"
        },
        dataType: "text",
        success: function (data) {
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
            selectForm.attr('required', false);
        },
        async: false
    });
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

$('#ubicarPro').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "DirectorCursoS",        
        data: {
            'cedula': $('#profesor').val(),
            'idCurso': $('#curso').val(),
            'fechaInicio': $('#fecha').val()
        },
        dataType: "text",
        success: function (data) {
            
        },
        async: false
    });
});
 