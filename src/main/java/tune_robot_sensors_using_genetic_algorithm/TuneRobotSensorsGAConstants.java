package tune_robot_sensors_using_genetic_algorithm;


public class TuneRobotSensorsGAConstants {
    private static final int[][] MAIZE = {
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 1}
    };
    public static boolean DEBUG = Boolean.TRUE;
    public static final int NUMBER_OF_ROWS_IN_MAIZE = MAIZE.length;
    public static final int NUMBER_OF_COLUMNS_IN_MAIZE = MAIZE[0].length;
    public static boolean REACHED_GOAL = Boolean.FALSE;
    public static final int POPULATION_SIZE = 10;
    public static final int TOURNAMENT_SELECTION = 10;
    public static final int NUMBER_OF_ELITE_INDIVIDUALS = 5;
    public static final double MUTATION_RATE = 0.001;
    public static final double CROSSOVER_RATE = 0.95;
    public static final double NUMBER_OF_ITERATIONS = 100;

    public static boolean isWallFree(MaizeNode nextStep) {
        try {
            return MAIZE[nextStep.getRowIndex()][nextStep.getColIndex()] == 0;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
