var animacion;
var logo;
var btnReiniciar;
var btnAnimar;


window.onload = function() {
    btnAnimar = document.getElementById("btnAnimar");
    btnReiniciar = document.getElementById("btnReiniciar");
    
    logo = document.getElementById("logo");
    btnAnimar.onclick = animar;
}

function animar() {
    animacion = TweenLite.to(logo, 3, {
        left: 400,
        backgroundColor: "black",
    });


    btnReiniciar.onclick = function() {
        animacion.restart();
    }

}