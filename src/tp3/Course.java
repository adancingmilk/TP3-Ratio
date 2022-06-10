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
        Coureurs c = new Coureurs();
        c.getCoureurs();
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
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez le numéro de dossard du coureur :");
        int numJoueur = sc.nextInt();
        for (Coureur coureur : coureurs){
            if (coureur.getNumDossard() == numJoueur)

                return startTime.until(coureur.getTime(), ChronoUnit.MINUTES);
        }
        return 0;
    }
}
