$(document).ready(function () {

    $('#crearProfesor').on('submit', function () {
        $.ajax({
            type: 'POST',
            url: "ProfesorS",
            data: {
                'cedula': $('#cedula').val(),
                'nombre': $('#nombre').val(),
                'tipoU': $('#tipoU').val(),
                'correo': $('#correo').val(),
                'celular': $('#celular').val(),
                'direccion': $('#direccion').val(),
                'estudios': $('#estudios').val(),
                'experiencia': $('#experiencia').val(),
                'fechanacimiento': $('#fechanacimiento').val(),
                'tiposangre': $('#tiposangre').val(),
                'rh': $('#rh').val(),
                'usuario': $('#usuario').val(),
                'contra': $('#contra').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha creado al Profesor exitosamente');
                location.reload();
            },
            async: false
        });
    });
});
 