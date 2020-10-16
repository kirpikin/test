package ru.javatest.sandbox;

public class Car {

    private final int wheels;
    private final int doors;
    private final String name;

    public Car(int wheels, int doors, String name) {
        this.wheels = wheels;
        this.doors = doors;
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int wheels;
        private int doors;
        private String name;

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Car build() {
            return new Car(wheels, doors, name);
        }

        private Builder() {
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", doors=" + doors +
                ", name='" + name + '\'' +
                '}';
    }
}
