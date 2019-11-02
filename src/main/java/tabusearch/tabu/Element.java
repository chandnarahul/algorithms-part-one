package tabusearch.tabu;

import java.util.Objects;

public class Element {
    private double x;
    private double y;
    private double z;


    public Element(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = Constants.costFunction(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Double.compare(element.x, x) == 0 &&
                Double.compare(element.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double z() {
        return z;
    }
}
