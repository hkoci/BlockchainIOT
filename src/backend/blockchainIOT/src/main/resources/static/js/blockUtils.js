/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready( function () {
    $('#mineBtn').click(function(){
        //Hide Modal
        $('#mineModal').modal('hide');
        //Show progress bar modal anim
        $('#preLoaderModal').modal('show'); 
        $('#preLoaderModalTitle').html("Mining in progress");
        //Perform mining request to endpoint
        $.get( "api/fog/block/mine", function( data ) {
          $( ".result" ).html( data );
          //Remove progress indicator
          $('#preLoaderModal').modal('hide');
          //Reload cards
          location.reload();
        });
    });

    $('#validateBtn').click(function(){
        //Hide Modal
        $('#validationModal').modal('hide');
        //Show progress bar modal anim
        $('#preLoaderModal').modal('show'); 
        $('#preLoaderModalTitle').html("Validation in progress");
        //Perform mining request to endpoint
        $.get( "api/fog/block/valid", function( data ) {
            if(data === true){
                var html = '<div class="alert alert-success alert-dismissible fade show mt-2" role="alert" width="50%">';
                html += '<strong>Validation passed</strong> The data integrity of the blockchain has not been affected.';
                html += '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
                html += '</div>';
                $( ".flex-shrink-0" ).append( html );
                //Remove progress indicator
                $('#preLoaderModal').delay('500').modal('hide');
            }else{
                var html = '<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert" width="50%">';
                html += '<strong>Validation failed</strong> The data integrity of the blockchain has been affected.';
                html += '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
                html += '</div>';
                $( ".flex-shrink-0" ).append( html );
                //Remove progress indicator
                $('#preLoaderModal').delay('500').modal('hide');
            }

        });
    });
});