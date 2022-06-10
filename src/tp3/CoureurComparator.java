package tp3;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class CoureurComparator implements Comparator<Coureur> {

    @Override
    public int compare(Coureur o1, Coureur o2) { // nous permet de comparer deux temps
        return (int)(o1.getTime().until(o2.getTime(),ChronoUnit.SECONDS));
    }
}
