package genetic_algorithm;

public class GeneticAlgorithmApp {
    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        Population population = new Population(100);
        population.initialise();

        int generationCounter = 0;
        while (population.getFitnessIndividual().getFitness() != Constant.MAX_FITNESS && generationCounter <= Constant.MAX_NUMBER_OF_GENERATIONS) {
            generationCounter++;
            System.out.printf("Generation " + generationCounter + " fittest is" + population.getFitnessIndividual().getFitness());
            System.out.println(population.getFitnessIndividual());
            population = geneticAlgorithm.evolvePopulation(population);
        }
        System.out.println("Solution Found");
        System.out.println(population.getFitnessIndividual());
    }
}
