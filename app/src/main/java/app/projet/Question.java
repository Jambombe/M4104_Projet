package app.projet;

import android.content.ContentValues;

import com.orm.SugarRecord;

public class Question extends SugarRecord{

    private String ennonce;
    private String reponseCorrecte;
    private String reponseIncorrecte1;
    private String reponseIncorrecte2;
    private Domaine domaine;

    public enum Domaine{
        FRANCAIS,
        HISTOIRE,
        GEO
    }

    public Question(){}

    public Question(String ennonce, String reponseCorrecte, String reponseIncorrecte1, String reponseIncorrecte2, Domaine d){
        this.ennonce = ennonce;
        this.reponseCorrecte = reponseCorrecte;
        this.reponseIncorrecte1 = reponseIncorrecte1;
        this.reponseIncorrecte2 = reponseIncorrecte2;
        this.domaine = d;

    }

    public String getEnnonce(){ return this.ennonce; }
    public String getReponseCorrecte(){ return this.reponseCorrecte; }
    public String getReponseIncorrecte1(){ return this.reponseIncorrecte1; }
    public String getReponseIncorrecte2(){ return this.reponseIncorrecte2; }
    public Domaine getDomaine(){ return this.domaine; }




}
