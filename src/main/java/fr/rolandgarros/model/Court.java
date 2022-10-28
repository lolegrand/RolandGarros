package fr.rolandgarros.model;

import java.util.Objects;

public class Court {

    private final String name;

    public Court(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Court court = (Court) o;
        return Objects.equals(name, court.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
