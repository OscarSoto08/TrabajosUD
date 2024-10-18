/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author FAMILIA
 */
public class ClaseConversor {
    
    
    public Fecha convertirStringAFecha(String valor) {
        // Suponiendo el formato de fecha "dd/MM/yyyy"
        String[] partes = valor.split("/");

        if (partes.length != 3) {
            // Manejo de error si la fecha no está en el formato esperado
            throw new IllegalArgumentException("Formato de fecha no válido. Debe ser dd/MM/yyyy.");
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int año = Integer.parseInt(partes[2]);

            return new Fecha(dia, mes, año);
        } catch (NumberFormatException e) {
            // Manejo de error si las partes no son enteros válidos
            throw new IllegalArgumentException("Fecha contiene valores no numéricos.");
        }
    }
    
    public Membresia convertirStringAMembresia(String valor) {
        switch(valor) {
            case "A" -> {
                return new TipoA();
            }
            case "B" -> {
                return new TipoB();
            }
            case "C" -> {
                return new TipoC();
            }
            default -> // Lanza una excepción o retorna un valor por defecto
            throw new IllegalArgumentException("Tipo de membresía no válido: " + valor);
        }
    }
    
}
