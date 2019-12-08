package tsp_using_simulatedannealing;

public class SimulatedAnnealing {

    private SingleTour bestSolution;

    public void simulation() {
        double temperature = 10000;
        double coolingRate = 0.003;

        SingleTour initialSolution = new SingleTour();
        System.out.println("initial solution is " + initialSolution.getDistance());

        bestSolution = new SingleTour(initialSolution.getTour());

        while (temperature > 1) {
            temperature = temperature - coolingRate;

            SingleTour newSolution = new SingleTour(initialSolution.getTour());
            int randomIndex1 = (int) (newSolution.tourSize() * Math.random());
            City city1 = newSolution.getCity(randomIndex1);

            int randomIndex2 = (int) (newSolution.tourSize() * Math.random());
            City city2 = newSolution.getCity(randomIndex2);

            newSolution.setCity(randomIndex2, city1);
            newSolution.setCity(randomIndex1, city2);

            double currentEnergy = initialSolution.getDistance();
            double newSolutionEnergy = newSolution.getDistance();

            if (acceptanceProbability(currentEnergy, newSolutionEnergy, temperature) > Math.random()) {
                initialSolution = new SingleTour(newSolution.getTour());
            }
            if (bestSolutionIsLessEffectiveThan(newSolution)) {
                bestSolution = new SingleTour(newSolution.getTour());
            }
        }
    }

    private boolean bestSolutionIsLessEffectiveThan(SingleTour newSolution) {
        return newSolution.getDistance() < bestSolution.getDistance();
    }

    private double acceptanceProbability(double currentEnergy, double newSolutionEnergy, double temperature) {
        if (newSolutionEnergy < currentEnergy) {
            return 1;
        } else {
            return Math.exp((currentEnergy - newSolutionEnergy) / temperature);
        }
    }

    public SingleTour getBestSolution() {
        return bestSolution;
    }
}
