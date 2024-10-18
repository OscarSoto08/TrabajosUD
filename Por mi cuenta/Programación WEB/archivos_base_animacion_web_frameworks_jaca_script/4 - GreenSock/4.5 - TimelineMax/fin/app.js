var animacion;
var logo;
var btnAnimar;
var btnAnimarImg;
var btnReiniciar;
var btnAnimar;
var btnPausar;
var btnReversa;
var btnPlay;
var btnAnimarImg;

window.onload = function() {
    btnAnimar = document.getElementById("btnAnimar");
    btnReiniciar = document.getElementById("btnReiniciar");
    btnPausar = document.getElementById("btnPausar");
    btnReversa = document.getElementById("btnReversa");
    btnPlay = document.getElementById("btnPlay");
    btnAnimarImg = document.getElementById("btnAnimarImg");
    logo = document.getElementById("logo");
    btnAnimar.onclick = animar;
}

function animar() {
    var img1 = document.getElementById("img1");
    var img2 = document.getElementById("img2");
    var img3 = document.getElementById("img3");

    animacion = new TimelineMax({delay: 2, paused:true, repeat: 2, repeatDelay: 1, yoyo:true, onComplete: animacionCompleta});

    animacion.to(logo, 2, {
        left: 400
    })
    .staggerTo([img1, img2, img3], 2, {
        left: 600
    }, 0.5);

    btnReiniciar.onclick = function() {
        animacion.restart();
    }

     btnPausar.onclick = function() {
        animacion.pause();
    }

    btnReversa.onclick = function() {
        animacion.reverse();
    }

    btnPlay.onclick = function() {
        animacion.play();
    }
}

function animacionCompleta(){
    console.log('Animación terminada');
}