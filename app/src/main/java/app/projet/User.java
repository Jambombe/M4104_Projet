package app.projet;

import com.orm.SugarRecord;



public class User extends SugarRecord{

    private String prenom;
    private String nom;
    private String image;

    public User(){}

    public User(String prenom, String nom, String image){
        this.prenom = prenom;
        this.nom = nom;
        this.image = image;
    }

    public String getPrenom(){ return this.prenom; }
    public String getNom(){ return this.nom; }
    public String image(){ return this.image; }
}
