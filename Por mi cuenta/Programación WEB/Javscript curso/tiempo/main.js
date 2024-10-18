let fechaElemento = document.getElementById("fecha");
let horaElemento = document.getElementById("reloj")

let fechaActual = new Date();
let diaSemana = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo']
let meses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']
fechaElemento.innerHTML = diaSemana[fechaActual.getDay()]  + ", "+ fechaActual.getDate() + ' de ' + meses[fechaActual.getMonth()] + " de " + fechaActual.getFullYear();

setInterval(()=>{
    let hora = new Date();
    horaElemento.innerHTML = hora.toLocaleTimeString()
}, 1000)