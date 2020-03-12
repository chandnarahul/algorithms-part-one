package tune_robot_sensors_using_genetic_algorithm;

import java.util.ArrayList;
import java.util.List;

import static tune_robot_sensors_using_genetic_algorithm.TuneRobotSensorsGAConstants.POPULATION_SIZE;

public class TuneRobotSensorsGAPopulation {
    private List<TuneRobotSensorsGAIndividual> simpleGAIndividuals;
    private int totalPopulationFitnessScore;

    public TuneRobotSensorsGAPopulation() {
        getIndividuals(POPULATION_SIZE);

    }

    public TuneRobotSensorsGAPopulation(int populationSize) {
        getIndividuals(populationSize);
    }

    private void getIndividuals(int populationSize) {
        simpleGAIndividuals = new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            simpleGAIndividuals.add(new TuneRobotSensorsGAIndividual());
        }
        sortByFittestIndividual();
        recalculatePopulationFitness();
    }


    public void updateIndividualAt(int location, TuneRobotSensorsGAIndividual toIndividual) {
        simpleGAIndividuals.set(location, toIndividual);
        sortByFittestIndividual();
    }

    private void sortByFittestIndividual() {
        simpleGAIndividuals.sort((i1, i2) -> {
            if (i1.getFitnessScore() > i2.getFitnessScore()) {
                return -1;
            } else if (i1.getFitnessScore() < i2.getFitnessScore()) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public void recalculatePopulationFitness() {
        simpleGAIndividuals.forEach(individual -> this.totalPopulationFitnessScore = +individual.getFitnessScore());
    }

    public int getTotalPopulationFitnessScore() {
        return totalPopulationFitnessScore;
    }

    public TuneRobotSensorsGAIndividual individual(int location) {
        return simpleGAIndividuals.get(location);
    }

    public TuneRobotSensorsGAIndividual fittestIndividual() {
        return simpleGAIndividuals.get(0);
    }

}
