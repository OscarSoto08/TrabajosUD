package modelo;

public class Consulta extends Servicio{

    private String tipoConsulta;

    public Consulta(String tipoConsulta, String codigo, String descripcion, double valor) {
        super(codigo, descripcion, valor);
        this.tipoConsulta = tipoConsulta;
    }

    public Consulta() {
        super();
        this.tipoConsulta = "";
    }
    
    public String getTipoConsuta() {
        return tipoConsulta;
    }

    public void setTipoConsuta(String tipoConsuta) {
        this.tipoConsulta = tipoConsuta;
    }
    
    
    @Override
    public double valorPago() {
        return switch(tipoConsulta){
            case "General" -> 1000;
            case "Especialista" -> 2000;
            default -> 3000;
        };
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo Consulta: " + tipoConsulta;
    }
    
    
}