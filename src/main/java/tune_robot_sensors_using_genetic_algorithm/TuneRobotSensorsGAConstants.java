package tune_robot_sensors_using_genetic_algorithm;


public class TuneRobotSensorsGAConstants {
    public static final int CHROMOSOME_LENGTH = 4;
    private static final int[][] MAIZE = {
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
    };
    public static final int NUMBER_OF_ROWS_IN_MAIZE = MAIZE.length;
    public static final int NUMBER_OF_COLUMNS_IN_MAIZE = MAIZE[0].length;
    public static int TOTAL_NUMBER_OF_STEPS = 0;
    public static final int POPULATION_SIZE = 10;
    public static final int NUMBER_OF_ELITE_INDIVIDUALS = 5;
    public static final double MUTATION_RATE = 0.001;
    public static final double CROSSOVER_RATE = 0.75;
    public static final double NUMBER_OF_ITERATIONS = 500;

    static {
        for (int i = 0; i < NUMBER_OF_ROWS_IN_MAIZE; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS_IN_MAIZE; j++) {
                if (MAIZE[i][j] == 0) {
                    TOTAL_NUMBER_OF_STEPS += 1;
                }
            }
        }
        System.out.println("TOTAL_NUMBER_OF_STEPS "+TOTAL_NUMBER_OF_STEPS);
    }

    public static boolean isWallFree(MaizeNode nextStep) {
        try {
            return MAIZE[nextStep.getRowIndex()][nextStep.getColIndex()] == 0;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
