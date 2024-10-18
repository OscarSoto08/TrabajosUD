var animacion;
var logo;
var btnReiniciar;
var btnAnimar;
var btnPausar;
var btnReversa;
var btnPlay;

window.onload = function() {
    btnAnimar = document.getElementById("btnAnimar");
    btnReiniciar = document.getElementById("btnReiniciar");
    logo = document.getElementById("logo");
    btnAnimar.onclick = animar;
}

function animar() {
    animacion = TweenLite.to(logo, 1, {
        left: 600,
        backgroundColor: "black"
    });


    btnReiniciar.onclick = function() {
        animacion.restart();
    }

}

