var world;
var ctx;
var canvasWidth;
var canvasHeight;
var canvasTop;
var canvasLeft;

window.onload = function() {
   
    ctx = $('canvas').getContext('2d');
    var myCanvas = $('canvas');
    canvasWidth = parseInt(myCanvas.width);
    canvasHeight = parseInt(myCanvas.height);
    canvasTop = parseInt(myCanvas.style.top);
    canvasLeft = parseInt(myCanvas.style.left);

    generarMundo();

}

function generarMundo() {
    console.log("El mundo ha sido creado");
}