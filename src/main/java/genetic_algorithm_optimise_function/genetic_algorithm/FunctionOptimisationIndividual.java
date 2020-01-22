package genetic_algorithm_optimise_function.genetic_algorithm;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.sin;

public class FunctionOptimisationIndividual {
    private int[] genes = new int[FunctionOptimisationConstant.CHROMOSOME_LENGTH];
    private double fitness = 0;
    private Random randomGenerator = new Random();

    public void generateIndividual() {
        for (int i = 0; i < FunctionOptimisationConstant.CHROMOSOME_LENGTH; i++) {
            int gene = randomGenerator.nextInt(FunctionOptimisationConstant.MAX_NUMBER);
            genes[i] = gene;
        }
    }

    public double f(double x) {
        return sin(x) * ((x - 2) * (x - 2)) + 3;
    }

    public double genesToDouble() {
        int base = 1;
        double geneToDouble = 0;
        for (int i = 0; i < FunctionOptimisationConstant.GENE_LENGTH; i++) {
            if (this.genes[i] == 1) {
                geneToDouble += base;
            }
            base = base * 2;
        }
        //[0,10] range 2 pow 10 = 1024 /10
        geneToDouble = geneToDouble / 102.4f;
        return geneToDouble;
    }

    public double getFitness() {
        this.fitness = f(genesToDouble());
        return fitness;
    }

    public int getGene(int index) {
        return this.genes[index];
    }

    public void setGene(int index, int value) {
        this.genes[index] = value;
        this.fitness = 0;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "genes=" + Arrays.toString(genes) +
                ", fitness=" + getFitnessAsString() +
                '}';
    }

    public String getFitnessAsString() {
        return Double.toString(fitness);
    }
}
