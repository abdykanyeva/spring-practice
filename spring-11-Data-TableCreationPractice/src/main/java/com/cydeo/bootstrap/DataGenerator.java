package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataGenerator implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW", "M3");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Corolla");


        // i want to save c1, c2, c3 to db

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        // I am going to love you one day, thymeleaf













    }
}
