
package Modelo;
import java.util.*;

    public class Person {
        int dias, meses, años;
        String nombre, apellido;

        public Person() {
            dias = meses = años = 0;
            nombre = apellido = "";
        }

        public Person(int dia, int mes, int año, String nombre, String apellido) {
            this.dias = dia;
            this.meses = mes;
            this.años = año;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public int getDia() {
            return dias;
        }

        public void setDia(int dia) {
            this.dias = dia;
        }

        public int getMes() {
            return meses;
        }

        public void setMes(int mes) {
            this.meses = mes;
        }

        public int getAño() {
            return años;
        }

        public void setAño(int año) {
            this.años = año;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
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
            return "Nombre: " + nombre +
                            "\nApellido: "+ apellido +
                            "\nAños: " + años +
                            "\nMeses: " + meses +
                            "\nDias: "+ dias;
        }
}
