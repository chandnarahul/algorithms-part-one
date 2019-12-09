package tsp_using_simulatedannealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository {
    private static final List<City> cityList = new ArrayList<>();

    public static void addRandomCitiesUpTo(int numberOfCities) {
        for (int i = 0; i < numberOfCities; i++) {
            cityList.add(new City());
        }
    }

    public static List<City> getShuffledCityList() {
        Collections.shuffle(cityList);
        return cityList;
    }
}
