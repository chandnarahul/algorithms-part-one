package genetic_algorithm_optimise_function.genetic_algorithm;

public class GeneticAlgorithmFunctionOptimisationApp {
    public static void main(String[] args) {
        FunctionOptimisationGeneticAlgorithm functionOptimisationGeneticAlgorithm = new FunctionOptimisationGeneticAlgorithm();
        FunctionOptimisationPopulation functionOptimisationPopulation = new FunctionOptimisationPopulation(100);
        functionOptimisationPopulation.initialise();

        int generationCounter = 0;
        while (functionOptimisationPopulation.getFitnessIndividual().getFitness() != FunctionOptimisationConstant.MAX_FITNESS && generationCounter <= FunctionOptimisationConstant.MAX_NUMBER_OF_GENERATIONS) {
            generationCounter++;
            System.out.printf("Generation " + generationCounter + " fittest is " + functionOptimisationPopulation.getFitnessIndividual().getFitnessAsString());
            System.out.println(functionOptimisationPopulation.getFitnessIndividual());
            functionOptimisationPopulation = functionOptimisationGeneticAlgorithm.evolvePopulation(functionOptimisationPopulation);
        }
        System.out.println("Solution Found");
        System.out.println(functionOptimisationPopulation.getFitnessIndividual());
    }
}
