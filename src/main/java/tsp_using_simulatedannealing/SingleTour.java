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

    public int getTourSize() {
        return tour.size();
    }

    public double getDistance() {
        if (distance == 0) {
            return distance = calculateRandomTourDistance();
        } else {
            return distance;
        }
    }

    private double calculateRandomTourDistance() {
        double tourDistance = 0;
        for (int cityIndex = 0; cityIndex < getTourSize() - 1; cityIndex++) {
            City fromCity = getCity(cityIndex);
            if (isNotLastCity(cityIndex)) {
                City nextCity = getCity(cityIndex + 1);
                tourDistance += fromCity.distanceTo(nextCity);
            } else {
                City firstCity = getCity(0);
                tourDistance += fromCity.distanceTo(firstCity);
            }
        }
        return tourDistance;
    }

    private boolean isNotLastCity(int cityIndex) {
        return cityIndex + 1 < getTourSize();
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
