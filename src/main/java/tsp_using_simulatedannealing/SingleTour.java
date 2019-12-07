package tsp_using_simulatedannealing;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.shuffle(tour);
    }

    public City getCity(int index) {
        return tour.get(index);
    }

    public int getTourSize() {
        return tour.size();
    }

    public double getDistance() {
        if (distance == 0) {
            double tourDistance = 0;
            for (int cityIndex = 0; cityIndex < getTourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if (cityIndex + 1 < getTourSize()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
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
