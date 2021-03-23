package sn.isi.entities;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;

    public Client(int id, String nom, String prenom, String email, String password, String telephone) {
    }

    public Client() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void affichage() {
        System.out.println("ID :"+this.id +"NOM :"+this.nom + "PRENOM :"+this.prenom);
    }
}
