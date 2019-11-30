package simulatedannealing;

import java.util.Random;

public class SimulatedAnnealing {
    private Random randomGenerator;
    private double currentCoordinateX;
    private double nextCoordinateX;
    private double bestCoordinateX;

    public SimulatedAnnealing() {
        this.randomGenerator = new Random();
    }

    public double f(double x) {
        return (x - 0.3) * (x - 0.3) * (x - 0.3) - 5 * x + x * x - 2;
    }

    public double functionEnergy(double x) {
        return f(x);
    }

    public double acceptanceProbability(double energy, double newEnergy, double temperature) {
        if (newEnergy < energy) {
            return 1;
        } else {
            return Math.exp((energy - newEnergy) / temperature);
        }
    }

    public void findOptimum() {
        double temperature = Constants.MAX_TEMPERATURE;
        while (temperature > Constants.MIN_TEMPERATURE) {
            nextCoordinateX = getRandomX();
        }
    }

    private double getRandomX() {
        return randomGenerator.nextDouble() * (Constants.MAX_COORDINATE - Constants.MIN_COORDINATE) + Constants.MIN_COORDINATE;
    }
}
