package tune_robot_sensors_using_genetic_algorithm;


import java.util.Set;

public class Sensor {
    public static int withoutObstacle(MaizeNode currentNode, Set<MaizeNode> visitedNode) {
        //neighbour on forward
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.forward())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.FORWARD);
            }
            return RobotMovementSensors.FORWARD.location;
        }
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.forwardRight())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.FORWARD_RIGHT);
            }
            return RobotMovementSensors.FORWARD_RIGHT.location;
        }
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.forwardLeft())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.FORWARD_LEFT);
            }
            return RobotMovementSensors.FORWARD_LEFT.location;
        }
        //neighbour right
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.right())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.RIGHT);
            }
            return RobotMovementSensors.RIGHT.location;
        }
        //neighbour left
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.left()) && !visitedNode.contains(currentNode.left())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.LEFT);
            }
            return RobotMovementSensors.LEFT.location;
        }
        //neighbour back
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.back()) && !visitedNode.contains(currentNode.back())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovementSensors.BACK);
            }
            return RobotMovementSensors.BACK.location;
        }
        return -1;
    }
}
