package tune_robot_sensors_using_genetic_algorithm;


import java.util.Set;

public class Sensor {
    public static int withoutObstacle(MaizeNode currentNode, Set<MaizeNode> visitedNode) {
        //neighbour on forward
        if (TuneRobotSensorsGAConstants.isWallFree(currentNode.forward()) && !visitedNode.contains(currentNode.forward())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovement.FORWARD);
            }
            return RobotMovement.FORWARD.location;
        }
        //neighbour right
        else if (TuneRobotSensorsGAConstants.isWallFree(currentNode.right()) && !visitedNode.contains(currentNode.right())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovement.RIGHT);
            }
            return RobotMovement.RIGHT.location;
        }
        //neighbour left
        else if (TuneRobotSensorsGAConstants.isWallFree(currentNode.left()) && !visitedNode.contains(currentNode.left())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovement.LEFT);
            }
            return RobotMovement.LEFT.location;
        }
        //neighbour back
        else if (TuneRobotSensorsGAConstants.isWallFree(currentNode.back()) && !visitedNode.contains(currentNode.back())) {
            if (TuneRobotSensorsGAConstants.DEBUG) {
                System.out.println("going " + RobotMovement.BACK);
            }
            return RobotMovement.BACK.location;
        }
        return -1;
    }
}
