package tsp_using_simulatedannealing;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static List<City> cityList = new ArrayList<>();

    public static void addCity(City city) {
        cityList.add(city);
    }

    public static City getCity(int index) {
        return cityList.get(index);
    }

    public static int size() {
        return cityList.size();
    }

    public static List<City> getCityList() {
        return cityList;
    }
}
