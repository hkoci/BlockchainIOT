/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready( function () {
    //Set difficulty on page load
    $.getJSON("api/fog/block/mine/difficulty", function(data) {
        $('#difficultyRange').val(data);
        $('#difficultyValue').html(data);
    });
    
    //Change difficulty on request
    $('#difficultyRange').change(function(){        
        //Perform mining request to endpoint, using input data
        $.post( "api/fog/block/mine/difficulty", { difficulty: $('#difficultyRange').val() }, function( data ) {
            if(data === true){
                $('#difficultyRange').val(data);
                $('#difficultyValue').html(data);
            }
        });
        
    });
});
    
    
    
