package tabusearch.tabu;

import astar.algorithm.Heuristics;
import astar.algorithm.Node;
import astar.algorithm.SearchSpaceAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Neighbours {
    private final VisitedElementList visitedElements;
    private final int x;
    private final int y;

    public Neighbours(VisitedElementList visitedElements, int x, int y) {
        this.visitedElements = visitedElements;
        this.x = x;
        this.y = y;
    }

    public Element bestNeighbour() {
        // find all neighbours
        // ignore the ones in visited elements list
        // find and return the one with smallest z value
        return getNeighbourWithMinimumZValue();
    }

    private Element getNeighbourWithMinimumZValue() {
        List<Element> pendingTraversalNeighbours = getPendingTraversalNeighbours();
        //if all the neighbouring states are tabu states
        // then we are going to return the middle state and traverse from there
        if (pendingTraversalNeighbours.isEmpty()) {
            return new Element(Constants.NUMBER_OF_VALUES.value, Constants.NUMBER_OF_VALUES.value);
        } else {
            pendingTraversalNeighbours.sort(new TabuMinimumElementComparator());
            //get the minimum element which will be the first one after sorting the list
            return pendingTraversalNeighbours.get(0);
        }
    }

    public List<Element> getPendingTraversalNeighbours() {
        List<Element> neighbours = new ArrayList<>();
        neighbours.addAll(getHorizontalVerticalNeighbours());
        neighbours.addAll(getDiagonalNeighbours());
        return neighbours;
    }

    private List<Element> getHorizontalVerticalNeighbours() {
        List<Element> neighbours = new ArrayList<>();
        //neighbour up
        if (y - 1 >= 0) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y - 1, x);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour down
        if (y + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y + 1, x);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on left
        if (x - 1 >= 0) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y, x - 1);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on right
        if (x + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y, x + 1);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }
        return neighbours;
    }

    private List<Element> getDiagonalNeighbours() {
        List<Element> diagonalNeighbours = new ArrayList<>();
        diagonalNeighbours.addAll(getRightDiagonals());
        diagonalNeighbours.addAll(getLeftDiagonals());
        return diagonalNeighbours;
    }

    private List<Element> getLeftDiagonals() {
        List<Element> diagonalNeighbours = new ArrayList<>();
        //neighbour on diagonal up left
        if (x + 1 < Constants.NUMBER_OF_VALUES.value && y - 1 >= 0) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y - 1, x + 1);
            if (neighbourForLocation.isPresent()) {
                diagonalNeighbours.add(neighbourForLocation.get());
            }
        }
        //neighbour on diagonal down left
        if (x + 1 < Constants.NUMBER_OF_VALUES.value && y + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y + 1, x + 1);
            if (neighbourForLocation.isPresent()) {
                diagonalNeighbours.add(neighbourForLocation.get());
            }
        }
        return diagonalNeighbours;
    }

    private List<Element> getRightDiagonals() {
        List<Element> diagonalNeighbours = new ArrayList<>();
        //neighbour on diagonal up right
        if (x - 1 >= 0 && y - 1 >= 0) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y - 1, x - 1);
            if (neighbourForLocation.isPresent()) {
                diagonalNeighbours.add(neighbourForLocation.get());
            }
        }
        //neighbour on diagonal down right
        if (x - 1 >= 0 && y + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> neighbourForLocation = locateNeighbours(y + 1, x - 1);
            if (neighbourForLocation.isPresent()) {
                diagonalNeighbours.add(neighbourForLocation.get());
            }
        }
        return diagonalNeighbours;
    }

    private Optional<Element> locateNeighbours(int rowIndex, int columnIndex) {
        final Element element = new Element(x, y);
        if (SearchSpaceAttributes.nodeIsNotBlocked(rowIndex, columnIndex) && !visitedElements.contains(element)) {
            return Optional.of(element);
        } else {
            return Optional.empty();
        }
    }
}
