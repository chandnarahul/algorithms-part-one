package genetic_algorithm_optimise_function.genetic_algorithm;

import java.util.Random;

public class FunctionOptimisationGeneticAlgorithm {
    private Random randomGenerator = new Random();

    public FunctionOptimisationGeneticAlgorithm() {
    }

    public FunctionOptimisationPopulation evolvePopulation(FunctionOptimisationPopulation functionOptimisationPopulation) {
        FunctionOptimisationPopulation newFunctionOptimisationPopulation = new FunctionOptimisationPopulation(functionOptimisationPopulation.size());

        for (int i = 0; i < functionOptimisationPopulation.size(); i++) {
            FunctionOptimisationIndividual firstFunctionOptimisationIndividual = randomSelection(functionOptimisationPopulation);
            FunctionOptimisationIndividual secondFunctionOptimisationIndividual = randomSelection(functionOptimisationPopulation);
            FunctionOptimisationIndividual newFunctionOptimisationIndividual = crossover(firstFunctionOptimisationIndividual, secondFunctionOptimisationIndividual);
            newFunctionOptimisationPopulation.saveIndividual(i, newFunctionOptimisationIndividual);
        }

        for (int i = 0; i < newFunctionOptimisationPopulation.size(); i++) {
            mutate(newFunctionOptimisationPopulation.getIndividual(i));
        }
        return newFunctionOptimisationPopulation;
    }

    private void mutate(FunctionOptimisationIndividual functionOptimisationIndividual) {
        for (int i = 0; i < FunctionOptimisationConstant.CHROMOSOME_LENGTH; i++) {
            if (Math.random() < FunctionOptimisationConstant.MUTATION_RATE) {
                int gene = randomGenerator.nextInt(FunctionOptimisationConstant.MAX_NUMBER);
                functionOptimisationIndividual.setGene(i, gene);
            }
        }
    }

    private FunctionOptimisationIndividual crossover(FunctionOptimisationIndividual firstFunctionOptimisationIndividual, FunctionOptimisationIndividual secondFunctionOptimisationIndividual) {
        FunctionOptimisationIndividual newSolution = new FunctionOptimisationIndividual();
        for (int i = 0; i < FunctionOptimisationConstant.CHROMOSOME_LENGTH; i++) {
            if (Math.random() <= FunctionOptimisationConstant.CROSSOVER_RATE) {
                newSolution.setGene(i, firstFunctionOptimisationIndividual.getGene(i));
            } else {
                newSolution.setGene(i, secondFunctionOptimisationIndividual.getGene(i));
            }
        }
        return newSolution;
    }

    private FunctionOptimisationIndividual randomSelection(FunctionOptimisationPopulation functionOptimisationPopulation) {
        FunctionOptimisationPopulation newFunctionOptimisationPopulation = new FunctionOptimisationPopulation(FunctionOptimisationConstant.TOURNAMENT_SIZE);

        for (int i = 0; i < FunctionOptimisationConstant.TOURNAMENT_SIZE; i++) {
            int randomIndex = (int) (Math.random() * functionOptimisationPopulation.size());
            newFunctionOptimisationPopulation.saveIndividual(i, functionOptimisationPopulation.getIndividual(randomIndex));
        }
        FunctionOptimisationIndividual fittestFunctionOptimisationIndividual = newFunctionOptimisationPopulation.getFitnessIndividual();
        return fittestFunctionOptimisationIndividual;
    }
}
