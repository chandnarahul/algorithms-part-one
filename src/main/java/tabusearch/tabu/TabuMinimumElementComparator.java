package tabusearch.tabu;

import java.util.Comparator;

public class TabuMinimumElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element t1, Element t2) {
        if (t1.z() < t2.z()) {
            return -1;
        } else if (t1.z() == t2.z()) {
            return 0;
        } else {
            return 1;
        }
    }
}
