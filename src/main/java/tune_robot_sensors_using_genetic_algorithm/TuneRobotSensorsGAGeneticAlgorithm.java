package tune_robot_sensors_using_genetic_algorithm;

public class TuneRobotSensorsGAGeneticAlgorithm {

    private TuneRobotSensorsGAPopulation simpleGAPopulation = new TuneRobotSensorsGAPopulation();
    private int iterations = 0;

    public TuneRobotSensorsGAGeneticAlgorithm() {
        simpleGAPopulation.recalculatePopulationFitness();
    }

    public void evaluatePopulation() {
        simpleGAPopulation.recalculatePopulationFitness();
    }

    public TuneRobotSensorsGAIndividual getFittest() {
        return simpleGAPopulation.fittestIndividual();
    }

    public boolean shouldContinueToEvaluate() {
        boolean isLessThanMaxNumberOfIterations = iterations < TuneRobotSensorsGAConstants.NUMBER_OF_ITERATIONS;
        if (isLessThanMaxNumberOfIterations && !TuneRobotSensorsGAConstants.REACHED_GOAL) {
            iterations += 1;
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public void applyCrossover() {
        TuneRobotSensorsGAPopulation crossOveredSimpleGAPopulation = new TuneRobotSensorsGAPopulation();
        for (int i = 0; i < TuneRobotSensorsGAConstants.POPULATION_SIZE; i++) {
            TuneRobotSensorsGAIndividual firstParent = crossOveredSimpleGAPopulation.individual(i);
            if (TuneRobotSensorsGAConstants.CROSSOVER_RATE > Math.random() && i >= TuneRobotSensorsGAConstants.NUMBER_OF_ELITE_INDIVIDUALS) {
                TuneRobotSensorsGAIndividual secondParent = new TuneRobotSensorsGAPopulation().fittestIndividual();
                crossOveredSimpleGAPopulation.updateIndividualAt(i, selectGenesViaOnePointSelectionFrom(firstParent, secondParent));
            } else {
                crossOveredSimpleGAPopulation.updateIndividualAt(i, firstParent);
            }
        }
        this.simpleGAPopulation = crossOveredSimpleGAPopulation;
    }

    private TuneRobotSensorsGAIndividual selectGenesViaOnePointSelectionFrom(TuneRobotSensorsGAIndividual fromFirstParent, TuneRobotSensorsGAIndividual fromSecondParent) {
        TuneRobotSensorsGAIndividual simpleGAIndividual = new TuneRobotSensorsGAIndividual();
        for (int i = 0; i < RobotMovementSensors.CHROMOSOME_LENGTH; i++) {
            if (fromFirstParent.getFitnessScore() > fromSecondParent.getFitnessScore()) {
                simpleGAIndividual.selectGeneAt(i, fromFirstParent);
            } else {
                simpleGAIndividual.selectGeneAt(i, fromSecondParent);
            }
        }
        simpleGAIndividual.calculateFitnessScore();
        return simpleGAIndividual;
    }

    public void applyMutation() {
        TuneRobotSensorsGAPopulation mutatedPopulation = new TuneRobotSensorsGAPopulation();
        for (int i = 0; i < TuneRobotSensorsGAConstants.POPULATION_SIZE; i++) {
            TuneRobotSensorsGAIndividual simpleGAIndividual = simpleGAPopulation.individual(i);
            if (i >= TuneRobotSensorsGAConstants.NUMBER_OF_ELITE_INDIVIDUALS) {
                for (int geneIndex = 0; geneIndex < RobotMovementSensors.CHROMOSOME_LENGTH; geneIndex++) {
                    if (TuneRobotSensorsGAConstants.MUTATION_RATE > Math.random()) {
                        simpleGAIndividual.flipGeneAt(geneIndex);
                    }
                }
            }
            mutatedPopulation.updateIndividualAt(i, simpleGAIndividual);
        }
        this.simpleGAPopulation = mutatedPopulation;
    }
}
