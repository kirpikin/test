package ru.javatest.sandbox;

import java.util.Objects;

public class Singleton {

    private int id;
    private String Name;
    private static Singleton currentInstance;

    private Singleton() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static Singleton getInstance() {
        if (currentInstance == null) {
            currentInstance = new Singleton();
        }
        return currentInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singleton that = (Singleton) o;
        return id == that.id &&
                Objects.equals(Name, that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name);
    }
}
