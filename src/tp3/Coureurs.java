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

    public void generateCoureurs() {
        coureurs.add(new Coureur("LATRONCHE", 1));
        coureurs.add(new Coureur("LACHAUD", 2));
        coureurs.add(new Coureur("COSTHILLES", 3));
    }

    @Override
    public Iterator<Coureur> iterator() {
        return coureurs.iterator();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for(Coureur c : coureurs) {
            text.append("[").append(c.getNumDossard())
                            .append("][").append(c.getNom())
                            .append("][Arrived: ").append(c.isArrive())
                            .append("][Forfeit: ").append(c.isAbandon())
                            .append("][Ratio: ").append(c.isRatio());
        }

        return text.toString();
    }

    public void classement(){
        List<Coureur> coureursClasse = getCoureurs();
        coureursClasse.sort(new CoureurComparator());
        System.out.println(coureursClasse.toString());
    }

    public void estArrive() {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs) {
            if (coureur.getNumDossard() == numJoueur) {
                coureur.setArrive(true);
                coureur.getTime();
                System.out.println("Le coureur" + coureur.toString() + "est arrivé");
            }
        }
    }

    public void aAbandonne(){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur) {
                coureur.setAbandon(true);
                coureur.getTime();
                System.out.println("Le coureur" + coureur.toString() + "a abandonné");
            }
        }

    }

    public void estDisqualifie(){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur) {
                coureur.setRatio(true);
                coureur.getTime();
                System.out.println("Le coureur" + coureur.toString() + "est disqualifié");
            }
        }

    }
}
