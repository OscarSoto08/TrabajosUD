package modelo;

import java.util.Calendar;

public class Fecha {
    private int dia, mes, año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha() {
        Calendar fechaSis = Calendar.getInstance();
        this.dia = fechaSis.get(Calendar.DAY_OF_MONTH);
        this.mes = fechaSis.get(Calendar.MONTH)+1;
        this.año = fechaSis.get(Calendar.YEAR);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}
