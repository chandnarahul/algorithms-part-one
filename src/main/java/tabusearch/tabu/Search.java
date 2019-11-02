package tabusearch.tabu;

public class Search {
    private final VisitedElementList visitedElementList = new VisitedElementList();
    private final Element[][] elementsMap;

    public Search() {
        this.elementsMap = new Element[Constants.NUMBER_OF_VALUES.value][Constants.NUMBER_OF_VALUES.value];
        int row = 0, column = 0;
        for (double x = -10; x < 9.9; x += 0.1, row++, column = 0) {
            for (double y = -10; y < 9.9; y += 0.1, column++) {
                elementsMap[row][column] = new Element(x, y, row, column);
            }
        }
    }

    public Element solve() {
        Element elementWithMinimumZ = elementsMap[100][100];
        for (int iterations = 0; iterations < Constants.NUMBER_OF_ITERATIONS.value; iterations++) {
            Element bestNeighbour = new Neighbours(visitedElementList, elementsMap, elementWithMinimumZ).bestNeighbour();
            visitedElementList.add(elementWithMinimumZ);
            if (bestNeighbour.z() < elementWithMinimumZ.z()) {
                elementWithMinimumZ = bestNeighbour;
            }
        }
        return elementWithMinimumZ;
    }
}
