package genetic_algorithm;

public class Population {
    private Individual[] individuals;

    public Population(int populationSize) {
        this.individuals = new Individual[populationSize];
    }

    public void initialise() {
        for (int i = 0; i < individuals.length; i++) {
            Individual newIndividual = new Individual();
            newIndividual.generateIndividual();
            saveIndividual(i, newIndividual);
        }
    }

    public Individual getIndividual(int index) {
        return this.individuals[index];
    }

    void saveIndividual(int i, Individual newIndividual) {
        this.individuals[i] = newIndividual;
    }

    public Individual getFitnessIndividual() {
        Individual fitness = individuals[0];
        for (int i = 0; i < individuals.length; i++) {
            if (getIndividual(i).getFitness() >= fitness.getFitness()) {
                fitness = getIndividual(i);
            }
        }
        return fitness;
    }

    public int size() {
        return this.individuals.length;
    }
}
