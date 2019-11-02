package tabusearch.tabu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Neighbours {
    private final int rowIndex;
    private final int columnIndex;
    private final Element[][] elementsMap;
    private VisitedElementList visitedElementList;

    Neighbours(VisitedElementList visitedElementList, Element[][] elementsMap, Element element) {
        this.visitedElementList = visitedElementList;
        this.elementsMap = elementsMap;
        this.rowIndex = element.getRowIndex();
        this.columnIndex = element.getColumnIndex();
    }

    Element bestNeighbour() {
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
            return elementsMap[Constants.NUMBER_OF_VALUES.value][Constants.NUMBER_OF_VALUES.value];
        } else {
            pendingTraversalNeighbours.sort(new TabuMinimumElementComparator());
            //get the minimum element which will be the first one after sorting the list
            return pendingTraversalNeighbours.get(0);
        }
    }

    private List<Element> getPendingTraversalNeighbours() {
        List<Element> neighbours = new ArrayList<>();
        neighbours.addAll(getHorizontalVerticalNeighbours());
        neighbours.addAll(getDiagonalNeighbours());
        return neighbours;
    }

    private List<Element> getHorizontalVerticalNeighbours() {
        List<Element> neighbours = new ArrayList<>();
        //neighbour up
        if (rowIndex - 1 >= 0) {
            final Optional<Element> element = locateNeighbourAt(rowIndex - 1, columnIndex);
            element.ifPresent(neighbours::add);
        }

        //neighbour down
        if (rowIndex + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> element = locateNeighbourAt(rowIndex + 1, columnIndex);
            element.ifPresent(neighbours::add);
        }

        //neighbour on left
        if (columnIndex - 1 >= 0) {
            final Optional<Element> element = locateNeighbourAt(rowIndex, columnIndex - 1);
            element.ifPresent(neighbours::add);
        }

        //neighbour on right
        if (columnIndex + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> element = locateNeighbourAt(rowIndex, columnIndex + 1);
            element.ifPresent(neighbours::add);
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
        List<Element> neighbours = new ArrayList<>();
        //neighbour on diagonal up left
        if (columnIndex + 1 < Constants.NUMBER_OF_VALUES.value && rowIndex - 1 >= 0) {
            final Optional<Element> element = locateNeighbourAt(rowIndex - 1, columnIndex + 1);
            element.ifPresent(neighbours::add);
        }
        //neighbour on diagonal down left
        if (columnIndex + 1 < Constants.NUMBER_OF_VALUES.value && rowIndex + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> element = locateNeighbourAt(rowIndex + 1, columnIndex + 1);
            element.ifPresent(neighbours::add);
        }
        return neighbours;
    }

    private List<Element> getRightDiagonals() {
        List<Element> neighbours = new ArrayList<>();
        //neighbour on diagonal up right
        if (columnIndex - 1 >= 0 && rowIndex - 1 >= 0) {
            final Optional<Element> element = locateNeighbourAt(rowIndex - 1, columnIndex - 1);
            element.ifPresent(neighbours::add);
        }
        //neighbour on diagonal down right
        if (columnIndex - 1 >= 0 && rowIndex + 1 < Constants.NUMBER_OF_VALUES.value) {
            final Optional<Element> element = locateNeighbourAt(rowIndex + 1, columnIndex - 1);
            element.ifPresent(neighbours::add);
        }
        return neighbours;
    }

    private Optional<Element> locateNeighbourAt(int rowIndex, int columnIndex) {
        Element element = elementsMap[rowIndex][columnIndex];
        if (visitedElementList.contains(element)) {
            return Optional.empty();
        } else {
            return Optional.of(element);
        }
    }

}
