package localsearch;

public class BruteForceSearch {
    private static final double START_X = -1;
    private static final double END_X = 2;

    public static void main(String[] args) {
        new BruteForceSearch().search();
    }

    public void search() {
        double startingPoint = START_X;
        double max = f(startingPoint);
        double min = f2(startingPoint);
        double maxIndex = START_X;
        double minIndex = START_X;
        double dx = 0.01;

        for (double i = startingPoint; i < END_X; i = i + dx) {
            if (f(i) > max) {
                max = f(i);
                maxIndex = i;
            }

            if (f2(i) < min) {
                min = f2(i);
                minIndex = i;
            }
        }
        System.out.println("The maximum value is f(x) = " + max + " at index " + maxIndex);
        System.out.println("The minimum value is f2(x) = " + min + " at index " + minIndex);
    }

    public double f(double x) {
        return -1 * (x - 1) * (x - 1) + 2;
    }

    public double f2(double x) {
        return (x - 1) * (x - 1);
    }
}
