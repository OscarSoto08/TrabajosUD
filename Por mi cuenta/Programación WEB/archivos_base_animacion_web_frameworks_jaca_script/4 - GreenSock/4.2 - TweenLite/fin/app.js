var animacion;
var logo;
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
    btnAnimarImg.onclick = animarImg;
}

function animar() {
    animacion = TweenLite.to(logo, 3, {
        left: 400,
        backgroundColor: "black",
        borderRadius: 50,
        delay: 2,
        ease: Back.easeIn,
        onComplete: animacionTerminada,
        onCompleteParams:["Animación terminada", "otro parametro"]
    });


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

function animacionTerminada(mensaje, parametro2){
	console.log(mensaje, parametro2)
}

function animarImg(){
    var img1 = document.getElementById("img1");
    var img2 = document.getElementById("img2");
    var img3 = document.getElementById("img3");
    TweenLite.to([img1, img2, img3], 1, {scale:0.2});
}
