package app.projet;


import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;


public class User extends SugarRecord {

    public static int ID_INVITE = -1;

    private String prenom;
    private String nom;
    private String image;
    private int bestScoreMathsAdd;
    private int bestScoreMathsMult;
    private int bestScoreCGHist;
    private int bestScoreCGFr;
    private int bestScoreCGGeo;

    public User(){}

    public User(String prenom, String nom, String image){
        this.prenom = prenom;
        this.nom = nom;
        this.image = image;
        this.bestScoreMathsAdd = 0;
        this.bestScoreMathsMult = 0;
        this.bestScoreCGFr = 0;
        this.bestScoreCGHist = 0;
        this.bestScoreCGGeo = 0;
    }

    public String getPrenom(){ return this.prenom; }
    public String getNom(){ return this.nom; }
    public String image(){ return this.image; }
    public int getScoreMathsAdd(){ return this.bestScoreMathsAdd;}
    public int getScoreMathsMult(){ return this.bestScoreMathsMult;}
    public int getScoreCGFr(){ return this.bestScoreCGFr;}
    public int getScoreCGHist(){ return this.bestScoreCGHist;}
    public int getScoreCGGeo(){ return this.bestScoreCGGeo;}

    /**
     * Retourn tous les cores de l'utilisateur sous forme de string déjà formatés
     * @return List<String>
     */
    public List getAllScoresString(){
        ArrayList scores = new ArrayList<>();
        scores.add("Additions : " + getScoreMathsAdd() + "/10");
        scores.add("Multiplications : " + getScoreMathsMult() + "/10");
        scores.add("QCM Français : " + getScoreCGFr() + "/5");
        scores.add("QCM Histoire : " + getScoreCGHist() + "/5");
        scores.add("QCM Géographie : " + getScoreCGGeo() + "/5");

        return scores;
    }

    /**
     * Met à jour le meilleur score de l'utilisateur de la matière donnée
     * Si le score actuel est meilleur que le nouveau, il est conservé, sinon il est remplacé
     * @param idMatiere ID de la matière correspondant au score
     * @param newScore Score effectué dans la matière d'ID idMatiere
     */
    public void setBestScore(int idMatiere, int newScore){
        switch (idMatiere){
            case Question.ID_MATH_ADD:
                this.bestScoreMathsAdd = Math.max(newScore, this.bestScoreMathsAdd);
                break;
            case Question.ID_MATH_MULT:
                this.bestScoreMathsMult = Math.max(newScore, this.bestScoreMathsMult);
                break;
            case Question.ID_CG_FR:
                this.bestScoreCGFr = Math.max(newScore, this.bestScoreCGFr);
                break;
            case Question.ID_CG_GEO:
                this.bestScoreCGGeo = Math.max(newScore, this.bestScoreCGGeo);
                break;
            case Question.ID_CG_HIST:
                this.bestScoreCGHist = Math.max(newScore, this.bestScoreCGHist);
                break;
        }

        // Sauvegarde
        this.save();
    }

}
