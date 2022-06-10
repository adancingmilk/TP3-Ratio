package tp3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Coureurs implements Iterable<Coureur> {
    private List<Coureur> coureurs;

    public Coureurs() {
        this.coureurs = new ArrayList<>();
    }

    List<Coureur> getCoureurs() {
        return coureurs;
    }

    public void add(Coureur c) {
        coureurs.add(c);
    }

    public void generateCoureurs() { // ajoute des coureurs de base pour le programme
        coureurs.add(new Coureur("LATRONCHE", 1));
        coureurs.add(new Coureur("LACHAUD", 2));
        coureurs.add(new Coureur("COSTHILLES", 3));
    }

    @Override
    public Iterator<Coureur> iterator() {
        return coureurs.iterator();
    } // permet d'itérer dans la liste, directement avec un for

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for(Coureur c : coureurs) {
            text.append("[").append(c.getNumDossard())
                            .append("][").append(c.getNom())
                            .append("][Arrived: ").append(c.isArrive())
                            .append("][Forfeit: ").append(c.isAbandon())
                            .append("][Ratio: ").append(c.isRatio()).append("]\n");
        }

        return text.toString();
    }


    public void estArrive() { // déclare quand un coureur choisi est arrivé
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs) {
            if (coureur.getNumDossard() == numJoueur && coureur.isAbandon()==false && coureur.isRatio() == false) {
                coureur.setArrive(true);
                coureur.getTime();
                coureur.setTime(LocalTime.now());
                System.out.println("Le coureur" + coureur.toString() + "est arrivé");
            }
        }
    }

    public void aAbandonne(){ // déclare si un coureur abandonne
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur && coureur.isArrive()==false && coureur.isRatio() == false) {
                coureur.setAbandon(true);
                coureur.getTime();
                System.out.println("Le coureur" + coureur.toString() + "a abandonné");
            }
        }

    }

    public void estDisqualifie(){ // declare si un coureur est disqualifié
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur && coureur.isRatio() == false) {
                coureur.setRatio(true);
                coureur.getTime();
                System.out.println("Le coureur" + coureur.toString() + "est disqualifié");
            }
        }

    }

}
