package modelo;

import java.util.Calendar;

public class Fecha {
    int dd, mm, aa;

    public Fecha() {
        Calendar fecha = Calendar.getInstance();
        dd = fecha.get(Calendar.DAY_OF_MONTH);
        mm = fecha.get(Calendar.MONTH)+1;
        aa = fecha.get(Calendar.YEAR);
    }

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
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
        return "\n" + dd + "/ " + mm + " /" + aa;
    }
}
