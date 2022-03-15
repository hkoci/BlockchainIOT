/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


$(document).ready( function () {
    var data = $.getJSON("http://localhost:8080/api/fog/block/all", function(data) {
        
        console.log(data);
        //TODO: HTML code to place JSON into cards (!)
        $("#blockCards").html(data[0].hash);
    });
});