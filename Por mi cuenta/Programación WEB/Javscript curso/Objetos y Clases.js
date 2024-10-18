//CREACION DE OBJETOS

let usuario = {
    nombre: "Maria",
    edad: "20",
    estudiante: true
};

console.log(usuario.nombre);
console.log(usuario.edad);
console.log(usuario.estudiante);

//Metodos de punto para los objetos

// 1. Agregar atributos

usuario.carrera = "contabilidad"
console.log(usuario['carrera'])

// 2. Eliminar

delete usuario.edad;
console.log(usuario['edad']);

//Verificar si hay algun elemento
console.log(usuario.hasOwnProperty('edad'));
console.log(usuario.hasOwnProperty('carrera'));

//un objeto dentro de otro objeto...
let usuario2 = {
    nombre: "Maria",
    edad: "20",
    estudiante: true,
    idiomas:{
        nativo: 'Español',
        extranjero: {
            ingles: 'alto',
            frances: 'medio',
            italiano: 'bajo'
        }
    }
};

console.log(usuario2['idiomas']['extranjero']['ingles']);
console.log(usuario2.idiomas['extranjero'].ingles);


/// CONSTRUCTORES

function Disco(artista, album, año){
    this.artista = artista;
    this.album = album;
    this.año = año;
}

let disco1 = new Disco('Jose Jose', '40 y 20', 1992)
console.log(disco1)

// EJEMPLO DE CLASES

class Player{
    constructor(nombre, colorSombrero){
        this._nombre = nombre;
        this._colorSombrero = colorSombrero;
    }

    saltar(){}
    correr(){}
    saludar(){ 
        return 'Hola, Soy '+this._nombre+' y mi sombrero es '+ this._colorSombrero
    } 
    get nombre(){
        return this._nombre;
    }  
    get colorSombrero(){
        return this._colorSombrero;
    } 
    set nombre(nombre){
        this._nombre = nombre;
    }
    set colorSombrero(colorSombrero){
        this._colorSombrero = colorSombrero;
    }
}

let mario = new Player("Mario", "Rojo");
let luigi = new Player("Luigi", "Verde");
console.log(mario.saludar())