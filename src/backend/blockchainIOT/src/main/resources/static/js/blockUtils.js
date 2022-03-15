/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready( function () {
    
    //Miner onClick function
    $('#mineBtn').click(function(){
        //Hide Modal
        $('#mineModal').modal('hide');
        //Show progress bar modal anim
        $('#preLoaderModal').modal('show'); 
        $('#preLoaderModalTitle').html("Mining in progress");
        //Perform mining request to endpoint
        $.get( "api/fog/block/mine", function( data ) {
          //Remove progress indicator
          $('#preLoaderModal').modal('hide');
          //Reload cards
          location.reload();
        });
    });
    
    //Block creation onClick function
    $('#createBtn').click(function(){
        //Hide Modal
        $('#createModal').modal('hide');
        //Show progress bar modal anim
        $('#preLoaderModal').modal('show'); 
        $('#preLoaderModalTitle').html("Creating block");

        //Perform mining request to endpoint, using input data
        $.post( "api/fog/block", { data: $('#message-text').val() }, function( data ) {
            //Delay by 500ms as the get request is quite instant preventing closure of modal that just opened (!)
            setTimeout(function () {
                //Remove progress indicator
                $('#preLoaderModal').modal('hide');
                if(data === true){
                    //Reload cards
                    location.reload();
                }else{
                    //Append validation fail msg
                    var html = '<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert" width="50%">';
                    html += '<strong>Block creation failed</strong> The data integrity of the blockchain has been affected.';
                    html += '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
                    html += '</div>';
                    $( ".flex-shrink-0" ).append( html );
                }
            }, 500);
        });
    });

    //Blockchain validation onClick function
    $('#validateBtn').click(function(){
        //Hide Modal
        $('#validationModal').modal('hide');
        //Show progress bar modal anim
        $('#preLoaderModal').modal('show'); 
        $('#preLoaderModalTitle').html("Validation in progress");
        //Perform mining request to endpoint
        $.get( "api/fog/block/valid", function( data ) {
            //Delay by 500ms as the get request is quite instant preventing closure of modal that just opened (!)
            setTimeout(function () {
                //Remove progress indicator
                $('#preLoaderModal').modal('hide');
                if(data === true){
                    //Append validation success msg
                    var html = '<div class="alert alert-success alert-dismissible fade show mt-2" role="alert" width="50%">';
                    html += '<strong>Validation passed</strong> The data integrity of the blockchain has not been affected.';
                    html += '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
                    html += '</div>';
                    $( ".flex-shrink-0" ).append( html );
                }else{
                    //Append validation fail msg
                    var html = '<div class="alert alert-danger alert-dismissible fade show mt-2" role="alert" width="50%">';
                    html += '<strong>Validation failed</strong> The data integrity of the blockchain has been affected.';
                    html += '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
                    html += '</div>';
                    $( ".flex-shrink-0" ).append( html );
                }
            }, 500);
        });
    });
});