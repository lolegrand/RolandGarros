package fr.rolandgarros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idC")
    private Integer idC;

    @Column(name = "name", nullable = false)
    private String name;

    public Court() {}

    public Court(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdC() {
        return idC;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
