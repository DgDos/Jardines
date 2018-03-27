
$(document).ready(function () {
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
            $('#VerP').removeAttr('style');
            var selectForm = $('#cedula');
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
    $('#cedula').on('change', function () {
        $.ajax({
            type: 'GET',
            url: "ProfesorGestion",
            //force to handle it as text
            data: {
                'opcion': "1",
                'cedula': $('#cedula').val()
                        // 'documento':"144144"
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#pa');
                var json = $.parseJSON(data);
                selectForm.empty();
                var opcion = "<p style=\"color:white\" >Cedula: " + json.idProfesor + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Nombre: " + json.nombre + ".</p>";
                selectForm.append(opcion);               
                opcion = "<p style=\"color:white\" >Usuario: " + json.usuario + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Fecha Nacimiento: " + json.fechaNacimiento + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Tipo Sangre: " + json.tipoSangre + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Correo: " + json.correo + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Celular: " + json.celular + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Direccion: " + json.direccion + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"color:white\" >Experiencia: " + json.experiencia + ".</p>";
                selectForm.append(opcion);
                $('#cedula2').attr('value', json.idProfesor);
                $('#nombre').attr('value', json.nombre);
                $('#tipousuario').attr('value', json.tipoU);
                $('#password').attr('value', json.password);
                $('#usuario').attr('value', json.usuario);
                $('#fechanacimiento').attr('value', json.fechaNacimiento);
                $('#tiposangre').attr('value', json.tipoSangre);
                $('#rh').attr('value', json.rh);
                $('#correo').attr('value', json.correo);
                $('#celular').attr('value', json.celular);
                $('#direccion').attr('value', json.direccion);
                $('#estudios').attr('value', json.estudios);
                $('#experiencia').attr('value', json.experiencia);
                

            },
            async: false
        });
    });
});