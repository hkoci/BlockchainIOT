/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready( function () {
    $('#mineBtn').click(function(){
        //Hide Modal
        $('#mineModal').modal('hide');
        //Show progress bar modal anim
        $('#minerLoaderModal').modal('show'); 
        //Perform mining request to endpoint
        $.get( "api/fog/block/mine", function( data ) {
          $( ".result" ).html( data );
          //Remove progress indicator
          $('#minerLoaderModal').modal('hide');
          //Reload cards
          location.reload();
        });
    });
});