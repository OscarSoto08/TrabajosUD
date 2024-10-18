package modelo;

public class Persona {
    private String id, nom, tel, email;
    private Fecha fNac;

    public Persona(String id, String nom, String tel, String email, Fecha fNac) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.fNac = fNac;
    }
    
    public Persona(){
        id = "";
        nom = "";
        tel = "";
        email = "";
        fNac = new Fecha();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "\nCorreo electronico: " + email + 
                "\nFecha " + fNac.toString();
    }
}
