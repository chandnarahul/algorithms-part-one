package tabusearch.tabu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Element {
    private int rowIndex;
    private int columnIndex;
    private double x;
    private double y;
    private double z;

    Element(double x, double y, int rowIndex, int columnIndex) {
        this.x = x;
        this.y = y;
        this.z = Constants.costFunction(x, y);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
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

    double z() {
        return z;
    }

    int getRowIndex() {
        return rowIndex;
    }

    int getColumnIndex() {
        return columnIndex;
    }

    @Override
    public String toString() {
        return "Element{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
