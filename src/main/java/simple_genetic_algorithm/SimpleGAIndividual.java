package simple_genetic_algorithm;

import java.util.Arrays;
import java.util.Random;

import static simple_genetic_algorithm.SimpleGAConstants.SOLUTION;

public class SimpleGAIndividual {
    private int[] chromosome = new int[SOLUTION.length];


    public SimpleGAIndividual() {
        for (int i = 0; i < SOLUTION.length; i++) {
            chromosome[i] = new Random().nextInt(2);
        }
    }

    public int getFitnessScore() {
        int count = 0;
        for (int i = 0; i < SOLUTION.length; i++) {
            if (chromosome[i] == SOLUTION[i]) {
                count += 1;
            }
        }
        return count;
    }

    public void selectGeneAt(int i, SimpleGAIndividual fromFirstParent) {
        chromosome[i] = fromFirstParent.chromosome[i];
    }

    public SimpleGAIndividual flipGeneAt(int geneIndex) {
        chromosome[geneIndex] = (chromosome[geneIndex] == 1) ? 0 : 1;
        return this;
    }

    @Override
    public String toString() {
        return "SimpleGAIndividual {" +
                "chromosome= " + Arrays.toString(chromosome) +
                '}';
    }
}
