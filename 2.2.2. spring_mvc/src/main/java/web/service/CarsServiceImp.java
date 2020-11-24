package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsServiceImp implements CarsService {

    @Override
    public List<Car> listCars(List<Car> cars, int count) {
        if (count >= cars.size()) {
            return cars;
        }

        List<Car> newCars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            newCars.add(cars.get(i));
        }

        return newCars;
    }
}
