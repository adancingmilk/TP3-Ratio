package tp3;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Course {
    private Coureurs coureurs;
    public static LocalTime startTime;
    public LocalTime endTime;

    public Course(Coureurs coureurs) {
        this.coureurs = coureurs;
    }

    public LocalTime StartCourse(){
        System.out.println("la course a commencé");
        return startTime = LocalTime.now();
    };

    public LocalTime EndCourse(){
        Coureurs c;
        c = coureurs;
        for (Coureur coureur : c){
            if (coureur.isArrive()==false)
                coureur.setRatio(true);
        }
        return endTime = LocalTime.now();
    };

    public void Disqualified(Coureur coureur) {
        if (coureur.isArrive() == false) {
            coureur.setRatio(true);
        }
    }

    public long currentTime(){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc3.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur)
                sc3.close();
                return startTime.until(coureur.getTime(), ChronoUnit.SECONDS);
        }
        return 0;
    }
}
