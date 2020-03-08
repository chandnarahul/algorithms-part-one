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

        System.out.println("Final fittest For generation [" + generation + "] " + simpleGAGeneticAlgorithm.getFittest() + " with fitness score of [" + simpleGAGeneticAlgorithm.getFittest().getFitnessScore() + "]");
    }
}
