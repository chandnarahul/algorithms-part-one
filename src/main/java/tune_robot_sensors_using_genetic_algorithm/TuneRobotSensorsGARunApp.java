package tune_robot_sensors_using_genetic_algorithm;

public class TuneRobotSensorsGARunApp {
    public static void main(String[] args) {
        TuneRobotSensorsGAGeneticAlgorithm simpleGAGeneticAlgorithm = new TuneRobotSensorsGAGeneticAlgorithm();
        int generation = 0;
        while (simpleGAGeneticAlgorithm.shouldContinueToEvaluate()) {
            simpleGAGeneticAlgorithm.applyCrossover();
            simpleGAGeneticAlgorithm.applyMutation();
            simpleGAGeneticAlgorithm.evaluatePopulation();
            System.out.println("For generation [" + generation + "] current fittest is " + simpleGAGeneticAlgorithm.getFittest() + " with fitness score of [" + simpleGAGeneticAlgorithm.getFittest().getFitnessScore() + "]");
            generation += 1;
        }
        System.out.println("Individuals in population that reached the end of maize");
        for (TuneRobotSensorsGAIndividual tuneRobotSensorsGAIndividual : simpleGAGeneticAlgorithm.getFittestPopulations()) {
            System.out.println(tuneRobotSensorsGAIndividual);
        }
    }
}
