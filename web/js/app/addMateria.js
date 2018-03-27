
      
$('#guardarMateria').on('click', function () {
    $.ajax({
        type: 'POST',
        url: "MateriaS",
       
        data: {
            'nombreMateria': $('#nombreMateria').val()
           
        },
        dataType: "text",
        success: function (data) {
            
        },
        
        async: false
    });
});
  
  
  


