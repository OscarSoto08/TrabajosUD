package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    private String id, nom;
    private String tel;
    private Fecha fNac;

    public Persona(String id, String nom, String tel, Fecha fNac) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.fNac = fNac;
    }
    
    public Persona(){
        id = "";
        nom = "";
        tel = "";
        fNac = new Fecha();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws FormatoEntradaException {
        if(id.equals(""))
            throw new FormatoEntradaException();
        else
            this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws FormatoEntradaException {
        Pattern pat = Pattern.compile("[1-9]");
        Matcher mat = pat.matcher(nom);
        if(nom.equals(""))
            throw new FormatoEntradaException(101, "Nombre: ");
        else if(mat.find())
            throw new FormatoEntradaException(102, "Nombre: "); 
        else
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    public Fecha getfNac() {
        return fNac;
    }

    public void setfNac(Fecha fNac) {
        this.fNac = fNac;
    }
    
    
    @Override
    public String toString() {
        return "\nIdentificacion:" + id + 
                "\nNombre: " + nom + 
                "\nTelefono: " + tel + 
                "\nFecha " + fNac.toString();
    }
}
