package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars = Arrays.asList(
            new Car("Honda Accord", 2020, "black"),
            new Car("Kia Rio", 2016, "red"),
            new Car("Lada Vesta", 2017, "white"),
            new Car("Ford Focus", 2010, "blue"),
            new Car("Kia Optima", 2019, "white"));

    @Override
    public List<Car> getCars(int n) {
        return cars.stream()
                .limit(n)
                .collect(Collectors.toList());
    }
}
