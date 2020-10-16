package ru.javatest.sandbox;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SandboxTests {

    @Test
    public void firstTest() {
        Car car = new CarBuilder().setDoors(4).setWheels(4).setName("Mustang").getResult();
        System.out.println(car);
        Car newCar = Car.builder()
                .setDoors(4)
                .setName("Volga")
                .setWheels(4)
                .build();

        System.out.println(newCar);
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();

        BaseCar olol = new ExtendCar();
        //olol.soutHeigth();

        if (one.equals(two)) {
            System.out.println("one Equals two");
        }
        int j = 3;

        System.out.println("Hello world");

        frt();

        Map map = new HashMap<Integer, String>();
        map.put(1, "Hello");
        map.put(2, "there");
        map.replace(2, "toto");

        System.out.println("Test " + map.values().toString());

        UserFor<Double> user = (x, y) -> {
            return x+y;
        };
        user.count(5.4,4.5);
        //j=89;
        System.out.println("lalal");
    }

    public static void frt() {
        int i = 10;

        System.out.println(i);
    }

    public int ret(int a) {
        return a*5;
    }

}

//interface UserFor<T> {
//    T count(T x, T y);
//}

