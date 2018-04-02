

//$('#SelectCurso').on('submit', function () {
//    var valor = $('#curso').val();
//    consultarEstudiantes(valor);
//    var casilla = $('#SelectEstudiante');
//    casilla.removeClass('hidden-sm-up');
//    var casilla2 = $('#estudiante');
//    casilla2.attr('required', false);
//    return false;
//});
$(document).ready(function () {
    $('#botonVisualizar').click(function () {
        $.ajax({
            type: 'GET',
            url: "NotaS",
            //force to handle it as text
            data: {
                'opcion': "0"
            },
            dataType: "text",
            success: function (data) {
                $('#tablaNota').removeAttr('style');
                $('#SelectCurso').removeAttr('style');
                $('#AddNota').attr('style', 'display: none;');
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
    });
    
    $('#botonRealizar').click(function () {
        $.ajax({
            type: 'GET',
            url: "NotaS",
            //force to handle it as text
            data: {
                'opcion': "0"
            },
            dataType: "text",
            success: function (data) {
                //$('#AddNota').removeAttr('style');
                //$('#tablaNota').attr('style', 'display: none;');
                $('#SelectCurso').removeAttr('style');
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
    });
});



$('#AddNota').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "NotaS",        
        data: {
            'idTema': $('#tema').val(),
            'nota': $('#nota').val(),
            'idEstudiante': $('#estudiante').val(),
            'idActividad': $('#actividad').val()
        },
        
        dataType: "text",
        
        success: function (data) {
        alert('Nota agregada exitosamente');

        },
        async: false
    });
});


$('#curso').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'curso': $('#curso').val()
        },
        dataType: "text",
        success: function (data) {

            var selectForm = $('#estudiante');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un estudiante</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
            selectForm.attr('required', false);
        },
        async: false
    });
});

$('#estudiante').on('change', function () {
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
            var selectForm = $('#tablaNota');
            selectForm.empty();
            selectForm.append('<tr><td style="color:white" >Actividad</td><td style="color:white" >Nota</td><td style="color:white" >Detalles</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"color:white\" >" + json[i].curso + "</td><td style=\"color:white\" >" + json[i].materia + "</td><td style=\"color:white\" >" + json[i].profesor + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});



//function consultarEstudiantes(curso) {
//    $.ajax({
//        type: 'GET',
//        url: "ObservadorS",
//        //force to handle it as text
//        data: {
//            'opcion': "1",
//            'curso': curso
//        },
//        dataType: "text",
//        success: function (data) {
//            var selectForm = $('#estudiante');
//            selectForm.empty();
//            selectForm.append('<option selected  value="" disabled>Seleccion un estudiante</option>');
//            var json = $.parseJSON(data);
//            console.log(json);
//            for (var i = 0; i < json.length; ++i)
//            {
//                var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
//                selectForm.append(opcion);
//            }
//        },
//        async: false
//    });
//
//}