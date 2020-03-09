package tune_robot_sensors_using_genetic_algorithm;

import java.util.Arrays;
import java.util.Random;

public enum RobotMovementSensors {
    FORWARD(0),
    FORWARD_RIGHT(1),
    FORWARD_LEFT(2),
    RIGHT(3),
    LEFT(4),
    BACK(5);

    int location;
    public static final int CHROMOSOME_LENGTH = RobotMovementSensors.values().length;

    RobotMovementSensors(int location) {
        this.location = location;
    }

    public static RobotMovementSensors randomMovement() {
        int location = new Random().nextInt(CHROMOSOME_LENGTH);
        return RobotMovementSensors.fromLocation(location);
    }

    public static RobotMovementSensors randomMovementExcept(RobotMovementSensors robotMovement) {
        int location = robotMovement.location;
        if (location == 0 || location == 1) {
            return fromLocation(location == 1 ? 0 : 1);
        } else {
            String str = Integer.toBinaryString(location);
            str = "" + ((str.charAt(0) - 48) == 0 ? 1 : 0) + ((str.charAt(1) - 48) == 0 ? 1 : 0);
            location = Integer.parseInt(str, 2);
        }
        return fromLocation(location);
    }

    public static RobotMovementSensors fromLocation(int location) {
        return Arrays.stream(RobotMovementSensors.values())
                .filter(it -> it.location == location)
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return this.name();
    }
}
