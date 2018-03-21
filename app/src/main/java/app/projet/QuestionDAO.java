package app.projet;

import java.util.ArrayList;
import java.util.List;
import app.projet.Question.Domaine;

import static java.util.Collections.shuffle;

public class QuestionDAO {

    /**
     * Retourne toutes les questions contenues dans la base
     * @return
     */
    public static List<Question> allQuestions(){
        return Question.listAll(Question.class);
    }

    /**
     * Retourne toutes les questions correspondant au domaine d
     * @param d Domaine recherché
     * @return
     */
    public static List<Question> questionsFromDomaine(Domaine d){
        return Question.findWithQuery(Question.class, "Select * From Question where domaine = ?", d.toString());
    }

    public static List<Question> questionsFromDomaine(Domaine d, int nbQuestions){
        List<Question> q = questionsFromDomaine(d); // Recuperer toutes les questions du domaine

//        if (q.size() < nbQuestions){
//            throw new ArrayIndexOutOfBoundsException();
//        }

        shuffle(q); // Melanger les questions
//        List<Question> q1 = new ArrayList<>();
//
//        for (int i = 0; i < nbQuestions; i++){ // Recuperer les nbQuestions premières quesions de la liste
//            q1.add(q.get(i));
//        }

        return q;
    }

    /**
     * Met à jour la DB :
     *  - Si elle est vide, insert les éléments
     *  - Sinon ne fait rien
     */
    public static void updateDB(){
        List<Question> q = QuestionDAO.allQuestions();
//        if (! q.isEmpty()){
            Question qG1 = new Question("Quelle est la capitale de France ?", "Paris", "Lyon", "Bordeaux", Question.Domaine.GEO);
            Question qG2 = new Question("Quel fleuve traverse Paris ?", "La Seine", "Le Rhône", "L'isère", Question.Domaine.GEO);
            Question qG3 = new Question("Quel pays se trouve en-dessous de la France ?", "L'Espagne", "L'Allemagne", "Le Canada", Question.Domaine.GEO);
            Question qG4 = new Question("Combien y a-t-il de continents ? ?", "5", "3", "4", Question.Domaine.GEO);
            Question qG5 = new Question("Quel est le plus grand océan du monde ?", "Le Pacifique", "L'Atlantique", "La mer Noire", Question.Domaine.GEO);

//        }
    }



}
