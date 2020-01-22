package genetic_algorithm_optimise_function.genetic_algorithm;

public class FunctionOptimisationConstant {
    public static final int MAX_NUMBER = 2;
    public static final int CHROMOSOME_LENGTH = 16;
    public static final int MAX_FITNESS = CHROMOSOME_LENGTH;
    public static final double CROSSOVER_RATE = 0.05;
    public static final double MUTATION_RATE = 0.015; //usually smaller than crossover so we make more crossover than mutation
    public static final int TOURNAMENT_SIZE = 5;
    public static final int MAX_NUMBER_OF_GENERATIONS = 500;
    public static final int GENE_LENGTH = 10;
}
