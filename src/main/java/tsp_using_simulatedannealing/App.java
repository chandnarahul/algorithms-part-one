package tsp_using_simulatedannealing;

public class App {
    public static void main(String[] args) {
        Repository.addRandomCitiesUpTo(1000);
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        simulatedAnnealing.simulation();

        System.out.println("Final approximated solution distance is " + simulatedAnnealing.getBest().getDistance());
        System.out.println("Final approximated solution distance is " + simulatedAnnealing.getBest());
    }
}
