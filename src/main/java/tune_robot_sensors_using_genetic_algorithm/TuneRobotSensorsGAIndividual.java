package tune_robot_sensors_using_genetic_algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class TuneRobotSensorsGAIndividual {
    private RobotMovement[] chromosome = new RobotMovement[TuneRobotSensorsGAConstants.CHROMOSOME_LENGTH];
    private Set<MaizeNode> visitedNodes = new HashSet<>();

    public TuneRobotSensorsGAIndividual() {
        System.out.println("******************");
        System.out.println("New Individual");
        System.out.println("******************");

        for (int i = 0; i < TuneRobotSensorsGAConstants.CHROMOSOME_LENGTH; i++) {
            chromosome[i] = RobotMovement.randomMovement();
        }
        calculateFitnessScore();
    }

    public int getFitnessScore() {
        return visitedNodes.size();
    }

    public void calculateFitnessScore() {
        System.out.println("Entering calculateFitnessScore");
        int i = 0, j = 0;
        for (; i < TuneRobotSensorsGAConstants.NUMBER_OF_ROWS_IN_MAIZE; ) {
            for (; j < TuneRobotSensorsGAConstants.NUMBER_OF_COLUMNS_IN_MAIZE; ) {
                final MaizeNode maizeNode = new MaizeNode(i, j);
                System.out.println(maizeNode + " " + this);
                if (visitedNodes.size() == TuneRobotSensorsGAConstants.TOTAL_NUMBER_OF_STEPS) {
                    return;
                }
                if (visitedNodes.size() == TuneRobotSensorsGAConstants.TOTAL_NUMBER_OF_STEPS) {
                    return;
                }
                final MaizeNode nextStep = getNodeFromChromosomeBasedOnSensorValueAt(maizeNode);
                visitedNodes.add(nextStep);
                if (TuneRobotSensorsGAConstants.isWallFree(nextStep) && !visitedNodes.contains(nextStep) && nextStep != null) {
                    i = nextStep.getRowIndex();
                    j = nextStep.getColIndex();
                    break;
                } else {
                    return;
                }
            }
        }
    }

    private MaizeNode getNodeFromChromosomeBasedOnSensorValueAt(MaizeNode maizeNode) {
        final int location = Sensor.withoutObstacle(maizeNode, visitedNodes);
        if (location == -1) {
            return null;
        } else {
            return maizeNode.getMovement(chromosome[location]);
        }
    }

    public void selectGeneAt(int i, TuneRobotSensorsGAIndividual fromParent) {
        chromosome[i] = fromParent.chromosome[i];
    }

    @Override
    public String toString() {
        return "SimpleGAIndividual {" +
                "chromosome= " + Arrays.toString(chromosome) +
                ",visitedNodes " + visitedNodes.size() +
                '}';
    }

    public void flipGeneAt(int geneIndex) {
        chromosome[geneIndex] = RobotMovement.randomMovementExcept(chromosome[geneIndex]);
    }
}
