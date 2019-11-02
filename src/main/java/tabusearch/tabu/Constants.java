package tabusearch.tabu;

public enum Constants {

    // because interval is [-10 to 10] with 0.1 steps,
    // so from 0 to -1 with 0.1 step = total 10 steps,
    // now number of steps from 0 to -10 = 10 * 10 = 100 steps in negative direction
    // and number of steps from 0 to  10 = 10 * 10 = 100 steps in positive direction
    // so total number of steps = 200
    NUMBER_OF_VALUES(200),

    // maximum number of times the loop will run when doing tabu search
    NUMBER_OF_ITERATIONS(100000),

    // maximum number of elements we will mark as "tabu" at a time
    TABU_TENURE(400);

    public int value;

    Constants(int value) {
        this.value = value;
    }

    public static double costFunction(double x, double y) {
        return Math.exp(-x * x - y * y) * Math.sin(x);
    }

}
