package tsp_using_simulatedannealing;

import java.util.ArrayList;
import java.util.List;

public class SingleTour {
    private List<City> tour = new ArrayList<>();
    private double distance = 0;

    public SingleTour() {
        generateTour();
    }

    public SingleTour(List<City> tour) {
        this.tour.addAll(tour);
    }

    public List<City> getTour() {
        return tour;
    }

    private void generateTour() {
        tour.addAll(Repository.getCityList());
    }

    public City getCity(int index) {
        return tour.get(index);
    }

    private City getNextCity(int index) {
        return tour.get(index + 1);
    }

    private City firstCity() {
        return tour.get(0);
    }

    private City lastCity() {
        return tour.get(tourSize() - 1);
    }

    public double getDistance() {
        if (distance == 0) {
            return distance = calculateGeneratedTourDistance();
        } else {
            return distance;
        }
    }

    public void resetDistance() {
        this.distance = 0;
    }

    private double calculateGeneratedTourDistance() {
        double tourDistance = 0;
        for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {
            if (isLastCity(cityIndex)) {
                tourDistance += lastCity().distanceTo(firstCity());
            } else {
                tourDistance += getCity(cityIndex).distanceTo(getNextCity(cityIndex));
            }
        }
        return tourDistance;
    }

    private boolean isLastCity(int cityIndex) {
        return cityIndex + 1 == tourSize();
    }

    public int tourSize() {
        return tour.size();
    }

    @Override
    public String toString() {
        return "SingleTour{" +
                "tour=" + tour +
                ", distance=" + distance +
                '}';
    }

    public void setCity(int randomIndex, City city) {
        this.tour.set(randomIndex, city);
    }
}
