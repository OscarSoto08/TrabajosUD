const contador1 = () => {
    let contador = 0;
    return() => {
        contador++;
        return contador;
    };
}
    
console.log(contador1()); 
console.log(contador1()); 

