package tsp_using_simulatedannealing;

public class App {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            City city = new City();
            Repository.addCity(city);
        }
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        simulatedAnnealing.simulation();

        System.out.println("Final approximated solution distance is " + simulatedAnnealing.getBest().getDistance());
        System.out.println("Final approximated solution distance is " + simulatedAnnealing.getBest());
    }
}
