package tp3;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Course {
    private static Coureurs coureurs;
    public static LocalTime startTime;
    public LocalTime endTime;

    public Course(Coureurs coureurs) {
        this.coureurs = coureurs;
    }

    public LocalTime StartCourse(){
        System.out.println("la course a commencé");
        return startTime = LocalTime.now();
    };

    public LocalTime EndCourse(){ //on fini la course, toutes les personnes non arrivées sont disqualifiées
        Coureurs c;
        c = coureurs;
        for (Coureur coureur : c){
            if (coureur.isArrive()==false)
                coureur.setRatio(true);
        }
        System.out.println("La course est terminée");
        return endTime = LocalTime.now();
    };

    public long currentTime(){ //retourne le temps actuel d'un participant
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur && coureur.isArrive()==false) {
                return startTime.until(coureur.getTime(), ChronoUnit.SECONDS); //si il n'est pas arrivé
            } else if (coureur.getNumDossard() == numJoueur && coureur.isArrive()==true) {
                System.out.println("Ce coureur est arrivé"); // si il est arrivé
                return startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
            } else if (coureur.getNumDossard() == numJoueur && coureur.isAbandon()==true) {
                System.out.println("Ce coureur à abandonné"); //ne retourne rien si il a abandonné
            } else if (coureur.getNumDossard() == numJoueur && coureur.isRatio()==true) {
                System.out.println("Ce coureur est disqualifié"); // ne retourne rien si il est disqualifié
            }
        }
        return 0;
    }

    public static void classement(){
        if (startTime!=null){
            List<Coureur> coureursClasse = coureurs.getCoureurs();
            coureursClasse.sort(new CoureurComparator());
            for (int k = 0, j = coureursClasse.size() - 1; k < j; k++)
            {
                coureursClasse.add(k, coureursClasse.remove(j));
            }
            for (Coureur coureur : coureursClasse) {
                if (coureur.isArrive() == false && coureur.isAbandon() == false && coureur.isRatio() == false) {
                    long t = startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
                    System.out.println(coureur.getNom() + " " + t);
                } else if (coureur.isArrive() == true && coureur.isAbandon() == false && coureur.isRatio() == false) {
                    long t = startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
                    System.out.println("cette personne est arrivée " + coureur.getNom() + " " + t);
                } else if (coureur.isAbandon() == true) {
                    System.out.println("Cette personne à abandonnée " + coureur.getNom());
                } else if (coureur.isRatio()) {
                    System.out.println("Cette personne est disqualifiée " + coureur.getNom());
                }
            }
        }else System.out.println("La course n'a pas commencée!");
    }

    public void getTime(){ // declare le temps d'un coureur
        if (startTime!=null) {
            Scanner sc3 = new Scanner(System.in);
            System.out.println("entrez le numéro de dossard du coureur :");
            int numJoueur = sc3.nextInt();
            for (Coureur coureur : coureurs) {
                if (coureur.getNumDossard() == numJoueur && coureur.isRatio() == false && coureur.isAbandon() == false && coureur.isArrive()==false) {
                    long t = startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
                    System.out.println(coureur.getNom() + " " + t + "sec");
                } else if (coureur.getNumDossard() == numJoueur && coureur.isRatio() == false && coureur.isAbandon() == false && coureur.isArrive()==true) {
                    long t = startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
                    System.out.println("Ce coureur est arrivé " +coureur.getNom() + " " + t + "sec");
                } else if(coureur.getNumDossard() == numJoueur && coureur.isRatio() == true ){
                    System.out.println("Ce coureur est disqualifié");
                } else if(coureur.getNumDossard() == numJoueur &&  coureur.isAbandon() == true){
                    System.out.println("Ce coureur à abandonné");
                }
            }
        } else System.out.println("La course n'a pas commencée !");
    }

    public void compareTwo(){
        if (startTime!=null){
            List<Coureur> comp = new ArrayList<>();
            int n, n2;
            Scanner sc3 = new Scanner(System.in);
            System.out.println("entrez le numéro de dossard :");
            n = sc3.nextInt();
            System.out.println("entrez le deuxième numéro de dossard :");
            n2 = sc3.nextInt();
            for (Coureur coureur : coureurs){
                if (coureur.getNumDossard() == n || coureur.getNumDossard() == n2)
                    comp.add(coureur);
            }
            comp.sort(new CoureurComparator());
            for (int k = 0, j = comp.size() - 1; k < j; k++)
            {
                comp.add(k, comp.remove(j));
            }
            long t = comp.get(0).getTime().until(comp.get(1).getTime(), ChronoUnit.SECONDS);
            System.out.println("La différence entre " + comp.get(0).getNom() + " " + " et " + comp.get(1).getNom() + " " + " est de "+ t + " sec");


        }else System.out.println("La course n'a pas commencée !");
    }
}
