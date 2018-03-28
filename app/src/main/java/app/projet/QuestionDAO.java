package app.projet;

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
//        List<Question> q = QuestionDAO.allQuestions();
//        if (! q.isEmpty()){
            Question qG1 = new Question("Quelle est la capitale de France ?", "Paris", "Lyon", "Bordeaux", Domaine.GEO);
            Question qG2 = new Question("Quel fleuve traverse Paris ?", "La Seine", "Le Rhône", "L'isère", Domaine.GEO);
            Question qG3 = new Question("Quel pays se trouve en-dessous de la France ?", "L'Espagne", "L'Allemagne", "Le Canada", Domaine.GEO);
            Question qG4 = new Question("Combien y a-t-il de continents ?", "5", "3", "4", Domaine.GEO);
            Question qG5 = new Question("Quel est le plus grand océan du monde ?", "Le Pacifique", "L'Atlantique", "La mer Noire", Domaine.GEO);

            qG1.save();
            qG2.save();
            qG3.save();
            qG4.save();
            qG5.save();

            Question qF1 = new Question("Aujourd'hui, j'ai ____ aux Légos", "joué", "jouer", "jouet", Domaine.FRANCAIS);
            Question qF2 = new Question("Les verbes du 1er groupe se finissent par : ", "- er", "- ir", "- dre", Domaine.FRANCAIS);
            Question qF3 = new Question("Quelle est la 2e personne du pluriel ?", "Vous", "Nous", "Je", Domaine.FRANCAIS);
            Question qF4 = new Question("Le ____ de la ville nous a rendu visite", "maire", "mère", "mer", Domaine.FRANCAIS);
            Question qF5 = new Question("Quel est l'infinitif du verbe dans \"J\'ai chaud\" ?", "Avoir", "Chaudir", "Avoir Chaud", Domaine.FRANCAIS);

            qF1.save();
            qF2.save();
            qF3.save();
            qF4.save();
            qF5.save();

            Question qH1 = new Question("En quelle année a été sacré Charlemagne ?", "800", "700", "600", Domaine.HISTOIRE);
            Question qH2 = new Question("Quel évènement a eu lieu en 1492 ?", "Découverte de l'Amérique par Christophe Colomb", "Fin de l'Antiquité", "Révolution Française", Domaine.HISTOIRE);
            Question qH3 = new Question("Quel roi était surnommé \"Le Roi Soleil\" ?", "Louis XIV", "Louis XV", "Clovis 1er", Domaine.HISTOIRE);
            Question qH4 = new Question("Comment s'écrit \"13\" en chriffres romains ?", "XIII", "XIIV", "VIII", Domaine.HISTOIRE);
            Question qH5 = new Question("Quand a débuté la 1re guerre mondiale ?", "1914", "1918", "1939", Domaine.HISTOIRE);

            qH1.save();
            qH2.save();
            qH3.save();
            qH4.save();
            qH5.save();
//        }
    }



}
