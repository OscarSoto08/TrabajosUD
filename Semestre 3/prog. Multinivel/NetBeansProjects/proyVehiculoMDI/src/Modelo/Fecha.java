/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author User
 */
public class Fecha {
    private int dd,mm,aa;

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }
    
  
        public Fecha() {
        Calendar fechaSis= Calendar.getInstance();
        this.dd = fechaSis.get(Calendar.DAY_OF_MONTH);
        this.mm = fechaSis.get(Calendar.MONTH)+1;//genera datos de 0 a 1
        this.aa = fechaSis.get(Calendar.YEAR);
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return  dd + "/" + mm + "/" + aa;
    }
    public int CalcularAa(int a){
        return this.aa-a;
    }    
}
