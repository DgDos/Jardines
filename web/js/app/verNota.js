$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        
        data: {
           
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><th >Estudiante</th>  <th >Nota</th></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"\" >" + json[i].nombre + "</td></tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });



});









