package tp3;
import java.time.*;

public class Course {
    private String[][] statsCoureurs;
    public static LocalTime startTime;
    public LocalTime endTime;

    public Course(int nbCoureurs) {
        statsCoureurs = new String[nbCoureurs][5];
    }

    public LocalTime StartCourse(){
        return startTime = LocalTime.now();
    };

    public LocalTime EndCourse(){
        return endTime = LocalTime.now();
    };

    public void Disqualified(Coureur coureur) {
        if (coureur.isArrive() == false) {
            coureur.setRatio(true);
        }
    }

}
