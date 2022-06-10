package tp3;

import java.util.Comparator;

public class CoureurComparator implements Comparator<Coureur> {

    @Override
    public int compare(Coureur o1, Coureur o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
