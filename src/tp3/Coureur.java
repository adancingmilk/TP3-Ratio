package tp3;
import java.time.*;
import java.util.Scanner;

public class Coureur {
    private String nom;
    private int numDossard;

    //Stats
    private boolean arrive;
    private boolean abandon;
    private boolean ratio;
    private LocalTime time;

    public Coureur(String nom, final int numDossard) {
        try {
            this.nom = nom;
            if (numDossard < 1)
                throw new ArithmeticException("Le numéro de dossard doit être supérieur à 1.");
            this.numDossard = numDossard;
            this.arrive = false;
            this.abandon = false;
            this.ratio = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getNumDossard() {
        return numDossard;
    }

    public String getNom() {
        return nom;
    }

    public boolean isRatio() {
        return ratio;
    }

    public LocalTime getTime() {return time = LocalTime.now();}

    public boolean isAbandon() {
        return abandon;
    }

    public boolean isArrive() {
        return arrive;
    }

    public void setArrive(boolean arrive) {
        this.arrive = arrive;
    }

    public void setAbandon(boolean abandon) {
        this.abandon = abandon;
    }

    public void setRatio(boolean ratio) {
        this.ratio = ratio;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Coureur{" +
                "nom='" + nom + '\'' +
                ", numDossard=" + numDossard +
                ", time=" +
                '}';
    }
}
