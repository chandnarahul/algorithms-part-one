package basicsearch;

import java.util.concurrent.ThreadLocalRandom;

public class StochasticSearch {
    private static final double START_X = -2;
    private static final double END_X = 2;

    public static void main(String[] args) {
        new StochasticSearch().search();
    }

    public void search() {
        double startingPoint = START_X;
        double min = f(startingPoint);
        double minIndex = START_X;
        for (int i = 0; i < 10000000; i++) {
            final double random = ThreadLocalRandom.current().nextDouble(START_X, END_X);
            if (f(random) < min) {
                min = f(random);
                minIndex = random;
            }
        }
        System.out.println("The minimum value is f(x) = " + min + " at index " + minIndex);
    }

    public double f(double x) {
        return (x - 1) * (x - 1) - 1;
    }
}
