$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "ProfesorS",
        //force to handle it as text
        data: {

        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#pa');
            var json = $.parseJSON(data);
            selectForm.empty();
            var opcion = "<p style=\"\" >Cedula: " + json.idProfesor + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Nombre: " + json.nombre + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Usuario: " + json.usuario + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Fecha Nacimiento: " + json.fechaNacimiento + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Tipo Sangre: " + json.tipoSangre + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Correo: " + json.correo + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Celular: " + json.celular + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Direccion: " + json.direccion + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Experiencia: " + json.experiencia + ".</p>";
            selectForm.append(opcion);

            $('#nombre').attr('value', json.nombre);
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


