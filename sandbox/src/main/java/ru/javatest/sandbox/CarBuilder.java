package ru.javatest.sandbox;

public class CarBuilder {
    private int wheels;
    private int doors;
    private String name;

    public CarBuilder setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    public CarBuilder setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Car getResult() {
        return new Car(wheels, doors, name);
    }
}
