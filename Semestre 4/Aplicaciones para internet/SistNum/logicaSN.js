
$(document).ready(function() {
    // Conversión de números
    $('#calculatorForm').on('submit', function(event) {
        event.preventDefault();
        
        let number = $('#numberInput').val().trim();
        let fromSystem = $('#fromSystem').val();
        let toSystem = $('#toSystem').val();
        
        if (number === '') {
            alert('Por favor, ingresa un número.');
            return;
        }
        
        let result = convertNumber(number, fromSystem, toSystem);
        let steps = generateConversionSteps(number, fromSystem, toSystem);

        $('#result').text(result);
        $('#steps').html(steps);
    });

    function convertNumber(number, fromSystem, toSystem) {
        let decimalValue;

        // Convertir a decimal primero
        switch (fromSystem) {
            case 'decimal':
                decimalValue = parseInt(number, 10);
                break;
            case 'binary':
                decimalValue = parseInt(number, 2);
                break;
            case 'octal':
                decimalValue = parseInt(number, 8);
                break;
            case 'hexadecimal':
                decimalValue = parseInt(number, 16);
                break;
        }

        // Convertir de decimal al sistema de destino
        let result;
        switch (toSystem) {
            case 'decimal':
                result = decimalValue.toString(10);
                break;
            case 'binary':
                result = decimalValue.toString(2);
                break;
            case 'octal':
                result = decimalValue.toString(8);
                break;
            case 'hexadecimal':
                result = decimalValue.toString(16).toUpperCase();
                break;
        }

        return result;
    }

    function generateConversionSteps(number, fromSystem, toSystem) {
        let steps = '';
        let decimalValue;

        // Paso 1: Convertir a decimal
        switch (fromSystem) {
            case 'decimal':
                decimalValue = parseInt(number, 10);
                steps += `<div class="step"><span class="step-title">Paso 1:</span> El número ya está en decimal: <strong>${decimalValue}</strong></div>`;
                break;
            case 'binary':
                decimalValue = parseInt(number, 2);
                steps += `<div class="step"><span class="step-title">Paso 1:</span> Convertir de binario a decimal: <strong>${number} = ${generateBinaryToDecimalSteps(number)}</strong></div>`;
                break;
            case 'octal':
                decimalValue = parseInt(number, 8);
                steps += `<div class="step"><span class="step-title">Paso 1:</span> Convertir de octal a decimal: <strong>${number} = ${generateOctalToDecimalSteps(number)}</strong></div>`;
                break;
            case 'hexadecimal':
                decimalValue = parseInt(number, 16);
                steps += `<div class="step"><span class="step-title">Paso 1:</span> Convertir de hexadecimal a decimal: <strong>${number} = ${generateHexadecimalToDecimalSteps(number)}</strong></div>`;
                break;
        }

        // Paso 2: Convertir de decimal al sistema de destino
        let result;
        switch (toSystem) {
            case 'decimal':
                result = decimalValue.toString(10);
                steps += `<div class="step"><span class="step-title">Paso 2:</span> El número ya está en decimal: <strong>${result}</strong></div>`;
                break;
            case 'binary':
                result = decimalValue.toString(2);
                steps += `<div class="step"><span class="step-title">Paso 2:</span> Convertir de decimal a binario: <strong>${decimalValue} = ${generateDecimalToBinarySteps(decimalValue)}</strong></div>`;
                break;
            case 'octal':
                result = decimalValue.toString(8);
                steps += `<div class="step"><span class="step-title">Paso 2:</span> Convertir de decimal a octal: <strong>${decimalValue} = ${generateDecimalToOctalSteps(decimalValue)}</strong></div>`;
                break;
            case 'hexadecimal':
                result = decimalValue.toString(16).toUpperCase();
                steps += `<div class="step"><span class="step-title">Paso 2:</span> Convertir de decimal a hexadecimal: <strong>${decimalValue} = ${generateDecimalToHexadecimalSteps(decimalValue)}</strong></div>`;
                break;
        }

        return steps;
    }

    function generateBinaryToDecimalSteps(binary) {
        let steps = '';
        let total = 0;
        let length = binary.length;

        for (let i = 0; i < length; i++) {
            let digit = parseInt(binary[length - 1 - i]);
            total += digit * Math.pow(2, i);
            steps += `${digit} * 2^${i}`;
            if (i < length - 1) steps += ' + ';
        }
        return steps + ' = ' + total;
    }

    function generateOctalToDecimalSteps(octal) {
        let steps = '';
        let total = 0;
        let length = octal.length;

        for (let i = 0; i < length; i++) {
            let digit = parseInt(octal[length - 1 - i]);
            total += digit * Math.pow(8, i);
            steps += `${digit} * 8^${i}`;
            if (i < length - 1) steps += ' + ';
        }
        return steps + ' = ' + total;
    }

    function generateHexadecimalToDecimalSteps(hexadecimal) {
        let steps = '';
        let total = 0;
        let length = hexadecimal.length;

        for (let i = 0; i < length; i++) {
            let digit = parseInt(hexadecimal[length - 1 - i], 16);
            total += digit * Math.pow(16, i);
            steps += `${digit} * 16^${i}`;
            if (i < length - 1) steps += ' + ';
        }
        return steps + ' = ' + total;
    }

    function generateDecimalToBinarySteps(decimal) {
        let steps = '';
        let result = '';
        let quotient = decimal;

        while (quotient > 0) {
            let remainder = quotient % 2;
            result = remainder + result;
            steps += `${quotient} / 2 = ${Math.floor(quotient / 2)}, Resto: ${remainder}<br>`;
            quotient = Math.floor(quotient / 2);
        }
        return steps + 'Resultado: ' + resultz;
    }

    function generateDecimalToOctalSteps(decimal) {
        let steps = '';
        let result = '';
        let quotient = decimal;

        while (quotient > 0) {
            let remainder = quotient % 8;
            result = remainder + result;
            steps += `${quotient} / 8 = ${Math.floor(quotient / 8)}, Resto: ${remainder}<br>`;
            quotient = Math.floor(quotient / 8);
        }
        return steps + 'Resultado: ' + result;
    }

    function generateDecimalToHexadecimalSteps(decimal) {
        let steps = '';
        let result = '';
        let quotient = decimal;

        while (quotient > 0) {
            let remainder = quotient % 16;
            result = remainder.toString(16).toUpperCase() + result;
            steps += `${quotient} / 16 = ${Math.floor(quotient / 16)}, Resto: ${remainder.toString(16).toUpperCase()}<br>`;
            quotient = Math.floor(quotient / 16);
        }
        return steps + 'Resultado: ' + result;
    }

    // Operaciones aritméticas
    $('#operationForm').on('submit', function(event) {
        event.preventDefault();

        let firstNumber = $('#firstNumber').val().trim();
        let secondNumber = $('#secondNumber').val().trim();
        let operation = $('#operation').val();
        let system = $('#arithmeticSystem').val();

        if (firstNumber === '' || secondNumber === '') {
            alert('Por favor, ingresa ambos números.');
            return;
        }

        let decimalFirstNumber = convertNumber(firstNumber, system, 'decimal');
        let decimalSecondNumber = convertNumber(secondNumber, system, 'decimal');
        let result;
        let steps;

        switch (operation) {
            case 'add':
                result = parseInt(decimalFirstNumber) + parseInt(decimalSecondNumber);
                steps = `<div class="operation-step"><span class="operation-step-title">Paso 1:</span> Convertir ambos números a decimal: <strong>${firstNumber} = ${decimalFirstNumber}</strong>, <strong>${secondNumber} = ${decimalSecondNumber}</strong></div>`;
                steps += `<div class="operation-step"><span class="operation-step-title">Paso 2:</span> Sumar los valores decimales: <strong>${decimalFirstNumber} + ${decimalSecondNumber} = ${result}</strong></div>`;
                break;
            case 'subtract':
                result = parseInt(decimalFirstNumber) - parseInt(decimalSecondNumber);
                steps = `<div class="operation-step"><span class="operation-step-title">Paso 1:</span> Convertir ambos números a decimal: <strong>${firstNumber} = ${decimalFirstNumber}</strong>, <strong>${secondNumber} = ${decimalSecondNumber}</strong></div>`;
                steps += `<div class="operation-step"><span class="operation-step-title">Paso 2:</span> Restar los valores decimales: <strong>${decimalFirstNumber} - ${decimalSecondNumber} = ${result}</strong></div>`;
                break;
            case 'multiply':
                result = parseInt(decimalFirstNumber) * parseInt(decimalSecondNumber);
                steps = `<div class="operation-step"><span class="operation-step-title">Paso 1:</span> Convertir ambos números a decimal: <strong>${firstNumber} = ${decimalFirstNumber}</strong>, <strong>${secondNumber} = ${decimalSecondNumber}</strong></div>`;
                steps += `<div class="operation-step"><span class="operation-step-title">Paso 2:</span> Multiplicar los valores decimales: <strong>${decimalFirstNumber} * ${decimalSecondNumber} = ${result}</strong></div>`;
                break;
            case 'divide':
                result = parseInt(decimalFirstNumber) / parseInt(decimalSecondNumber);
                steps = `<div class="operation-step"><span class="operation-step-title">Paso 1:</span> Convertir ambos números a decimal: <strong>${firstNumber} = ${decimalFirstNumber}</strong>, <strong>${secondNumber} = ${decimalSecondNumber}</strong></div>`;
                steps += `<div class="operation-step"><span class="operation-step-title">Paso 2:</span> Dividir los valores decimales: <strong>${decimalFirstNumber} / ${decimalSecondNumber} = ${result}</strong></div>`;
                break;
        }

        let finalResult = convertNumber(result.toString(), 'decimal', system);
        steps += `<div class="operation-step"><span class="operation-step-title">Paso 3:</span> Convertir el resultado decimal de vuelta al sistema numérico ${system}: <strong>${result} = ${finalResult}</strong></div>`;

        $('#operationResult').text(finalResult);
        $('#operationSteps').html(steps);
    });
});