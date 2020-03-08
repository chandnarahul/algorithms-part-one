package tune_robot_sensors_using_genetic_algorithm;

import java.util.Arrays;
import java.util.Random;

public enum RobotMovement {
    FORWARD(0),
    RIGHT(1),
    LEFT(2),
    BACK(3);

    int location;

    RobotMovement(int location) {
        this.location = location;
    }

    public static RobotMovement randomMovement() {
        int location = new Random().nextInt(4);
        return RobotMovement.fromLocation(location);
    }

    public static RobotMovement randomMovementExcept(RobotMovement robotMovement) {
        int location = robotMovement.location;
        if (location == 0 || location == 1) {
            return fromLocation(location == 1 ? 0 : 1);
        } else {
            String str = Integer.toBinaryString(location);
            str = "" + ((str.charAt(0) - 48) == 0 ? 1 : 0) +((str.charAt(1) - 48) == 0 ? 1 : 0);
            location = Integer.parseInt(str, 2);
        }
        return fromLocation(location);
    }

    public static RobotMovement fromLocation(int location) {
        return Arrays.stream(RobotMovement.values())
                .filter(it -> it.location == location)
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return this.name();
    }
}
