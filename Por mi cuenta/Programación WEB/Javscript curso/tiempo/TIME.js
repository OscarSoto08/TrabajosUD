
//SetTimeOUT
setTimeout((nombre)=>{
    console.log('Hola '+ nombre)
},2000, 'Oscar')

//detener el setTimeout --> clearTimeout
let temporizadorID = setTimeout((nombre)=>{
    console.log('Hola '+ nombre)
},6000, 'Alejandro')

clearTimeout(temporizadorID)

// Ejecutar una función cada cierto tiempo --> setInterval()
let numero = 10

console.log('Cuenta regresiva...')
let lanzamiento = setInterval((nombre)=>{
    console.log(numero + '...' + '\n')
    numero--
    if(numero == 0){
        clearInterval(lanzamiento)
        console.log('Bienvenido ' + nombre)
    }
}, 1000, 'Oscar')


function contar(){

//Ejecutar una función cada cierto tiempo --> Recursividad setTimeout
    let num = 0;
    let incrementoID = setTimeout(function incremento(){
        console.log(num++)
        incrementoID = setTimeout(incremento, 1000)
        if(num == 11){
            clearTimeout(incrementoID)
            console.log("Bienvenido Oscar")
        }
    }, 1000)
}

