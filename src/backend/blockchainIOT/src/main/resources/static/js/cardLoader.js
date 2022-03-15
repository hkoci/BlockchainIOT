/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready( function () {
    $.getJSON("http://localhost:8080/api/fog/block/all", function(data) {
        //Loop each object in the json request
        for (var i = 0; i < data.length; i++) {
            
            //Convert TimeStamp from Unix numerical to Date object to display date and time when output
            var timeStamp = new Date(data[i].timeStamp);
            
            var html = '<div class="card card-body">';
            html += '<div class="mb-3 row">';
            html += '<label for="blockHash" class="col-sm-2 col-form-label">Hash</label>';
            html += '<div class="col-sm-10"> <input type="text" readonly class="form-control-plaintext" id="blockHash" value="' + data[i].hash + '"> </div>';
            html += '</div>';
            //Previous Hash
            html += '<div class="mb-3 row">';
            html += '<label for="previousBlockHash" class="col-sm-2 col-form-label">Prev. Hash</label>';
            html += '<div class="col-sm-10"> <input type="text" readonly class="form-control-plaintext" id="previousBlockHash" value="' + data[i].previousHash + '"> </div>';
            html += '</div>';
            //Nonce
            html += '<div class="mb-3 row">';
            html += '<label for="blockNonce" class="col-sm-4 col-form-label">Nonce</label>';
            html += '<div class="col-sm-8"> <input type="text" readonly class="form-control-plaintext" id="blockNonce" value="' + data[i].nonce + '"> </div>';
            html += '</div>';
            //Timestamp
            html += '<div class="mb-3 row">';
            html += '<label for="blockTime" class="col-sm-4 col-form-label">Timestamp</label>';
            html += '<div class="col-sm-8"> <input type="text" readonly class="form-control-plaintext" id="blockTime" value="' + timeStamp.toLocaleString() + '"> </div>';
            html += '</div>';
            //Block Data
            html += '<form class="form-floating">';
            html += '<input type="blockData" class="form-control disable" id="blockData" value=" ' + data[i].blockData + ' " readonly>';
            html += '<label for="floatingInputValue">Block Data</label>';
            html += '</form>';
            //Check if its the last block, to add miner button
            if(i === data.length - 1){
                html += '<button type="button" class="btn btn-success mt-3" data-bs-toggle="modal" data-bs-target="#mineModal" onclick="$("#mineModal").modal("show")">';
                html += 'Mine last block';
                html += '</button>';
            }
            //EOF
            html += '</div>';
            $('#blockCards').append(html);
        }
    });
});