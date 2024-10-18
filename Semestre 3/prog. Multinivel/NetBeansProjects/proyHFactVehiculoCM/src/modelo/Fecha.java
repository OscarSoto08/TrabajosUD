package modelo;

import java.util.Calendar;

public class Fecha {
    int dias,meses,años;

    public Fecha(int dd, int mm, int aa) {
        this.dias = dd;
        this.meses = mm;
        this.años = aa;
    }

    public Fecha() {
        Calendar fechaSis = Calendar.getInstance();
        this.dias = fechaSis.get(Calendar.DAY_OF_MONTH);
        this.meses = fechaSis.get(Calendar.MONTH);
        this.años = fechaSis.get(Calendar.YEAR);
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public void calcularEdad() {
    Calendar fechaNacimiento = Calendar.getInstance();
    fechaNacimiento.set(años, meses - 1, dias); // Meses en Calendar van de 0 a 11

    Calendar fechaActual = Calendar.getInstance();

    if (fechaNacimiento.after(fechaActual)) {
        // Si la fecha de nacimiento es posterior a la fecha actual, lanzamos una excepción
        throw new IllegalArgumentException("La fecha de nacimiento es posterior a la fecha actual.");
    }

    años = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
    
    int mesesDiferencia = fechaActual.get(Calendar.MONTH) - (meses - 1);
    if (mesesDiferencia < 0) {
        años--; // Aún no ha cumplido años este año
        mesesDiferencia += 12;
    }
    meses = mesesDiferencia;

    int diasDiferencia = fechaActual.get(Calendar.DAY_OF_MONTH) - dias;
    if (diasDiferencia < 0) {
        meses--; // Ajustar meses si no ha pasado el cumpleaños este mes
        diasDiferencia += fechaActual.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    dias = diasDiferencia;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha{");
        sb.append("dias=").append(dias);
        sb.append(", meses=").append(meses);
        sb.append(", a\u00f1os=").append(años);
        sb.append('}');
        return sb.toString();
    }
    
}
