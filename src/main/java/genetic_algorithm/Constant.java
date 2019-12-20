package genetic_algorithm;

public class Constant {
    public static final int[] SOLUTION_SEQUENCE = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final int MAX_NUMBER = SOLUTION_SEQUENCE.length + 1;
    public static final int CHROMOSOME_LENGTH = SOLUTION_SEQUENCE.length;
    public static final int MAX_FITNESS = SOLUTION_SEQUENCE.length;
    public static final double CROSSOVER_RATE = 0.7;
    public static final double MUTATION_RATE = 0.15; //usually smaller than crossover so we make more crossover than mutation
    public static final int TOURNAMENT_SIZE = 5;
    public static final int MAX_NUMBER_OF_GENERATIONS = 50000;

}
