package basicsearch;

public class HillClimbing {
    private static final double START_X = -2;

    public static void main(String[] args) {
        new HillClimbing().climb();
    }

    public void climb() {
        double startingPoint = START_X;
        double max = f(startingPoint);
        double index = START_X;
        double dx = 0.01;
        while (f(startingPoint + dx) >= max) {
            System.out.println("Currently at point = " + startingPoint + " function value " + f(startingPoint));
            startingPoint = startingPoint + dx;
            max = f(startingPoint);
        }
        System.out.println("The maximum value is f(x) = " + max);
    }

    public double f(double x) {
        return -(x - 1) * (x - 1) + 2;
    }
}
