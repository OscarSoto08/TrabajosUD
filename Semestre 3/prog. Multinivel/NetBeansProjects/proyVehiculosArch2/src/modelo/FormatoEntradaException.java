/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class FormatoEntradaException extends Exception{
    private int NroError;
    private String msg;

    public FormatoEntradaException(int NroError, String dato) {
        this.NroError = NroError;
        switch(NroError)
        {
            case 101 -> {msg = "Se ha detectado valor nulo... ";}
            case 102 -> {msg = "Solo se admiten letras... ";}
            case 103 -> {msg = "Solo se admiten números... ";}
        }
        msg += " \nEn dato: " + dato;
    }

    public FormatoEntradaException() {
        this.msg = "";
        this.NroError = 0;
    }

    @Override
    public String toString() {
        return "Error: " + NroError +
                "\nGenerado por: " + msg;
    }

    public int getNroError() {
        return NroError;
    }

    public void setNroError(int NroError) {
        this.NroError = NroError;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
