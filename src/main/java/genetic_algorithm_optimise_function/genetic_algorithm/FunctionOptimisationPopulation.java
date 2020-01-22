package genetic_algorithm_optimise_function.genetic_algorithm;

public class FunctionOptimisationPopulation {
    private FunctionOptimisationIndividual[] functionOptimisationIndividuals;

    public FunctionOptimisationPopulation(int populationSize) {
        this.functionOptimisationIndividuals = new FunctionOptimisationIndividual[populationSize];
    }

    public void initialise() {
        for (int i = 0; i < functionOptimisationIndividuals.length; i++) {
            FunctionOptimisationIndividual newFunctionOptimisationIndividual = new FunctionOptimisationIndividual();
            newFunctionOptimisationIndividual.generateIndividual();
            saveIndividual(i, newFunctionOptimisationIndividual);
        }
    }

    public FunctionOptimisationIndividual getIndividual(int index) {
        return this.functionOptimisationIndividuals[index];
    }

    void saveIndividual(int i, FunctionOptimisationIndividual newFunctionOptimisationIndividual) {
        this.functionOptimisationIndividuals[i] = newFunctionOptimisationIndividual;
    }

    public FunctionOptimisationIndividual getFitnessIndividual() {
        FunctionOptimisationIndividual fitness = functionOptimisationIndividuals[0];
        for (int i = 0; i < functionOptimisationIndividuals.length; i++) {
            if (getIndividual(i).getFitness() < fitness.getFitness()) {
                fitness = getIndividual(i);
            }
        }
        return fitness;
    }

    public int size() {
        return this.functionOptimisationIndividuals.length;
    }
}
