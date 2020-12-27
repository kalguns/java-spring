package com;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrmconfigApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmconfigApplication.class, args);
    }

    @PostConstruct
    public void dataInit(){

        Car c1 = new Car("BMW", "M5");
        Car c2 = new Car("Toyota", "Camry");
        Car c3 = new Car("Opel", "Corsa");
        Car c4 = new Car("Mercedes", "C5");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
        carRepository.save(c4);

        carRepository.delete(c1);




    }
}