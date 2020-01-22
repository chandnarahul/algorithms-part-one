package genetic_algorithm;

import java.util.Arrays;
import java.util.Random;

public class Individual {
    private int[] genes = new int[Constant.CHROMOSOME_LENGTH];
    private int fitness = 0;
    private Random randomGenerator = new Random();

    public void generateIndividual() {
        for (int i = 0; i < Constant.CHROMOSOME_LENGTH; i++) {
            int gene = randomGenerator.nextInt(Constant.CHROMOSOME_LENGTH);
            genes[i] = gene;
        }
    }

    public int getFitness() {
        if (fitness == 0) {
            for (int i = 0; i < Constant.CHROMOSOME_LENGTH; i++) {
                if (genes[i] == Constant.SOLUTION_SEQUENCE[i]) {
                    this.fitness++;
                }
            }
        }
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
                ", fitness=" + getFitnessPercentage() +
                '}';
    }

    public String getFitnessPercentage() {
        return ((fitness / Constant.SOLUTION_SEQUENCE.length) * 100) + "%%";
    }
}
