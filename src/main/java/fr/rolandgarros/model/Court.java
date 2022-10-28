package fr.rolandgarros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idT;

    private  String name;

    public Court() {}

    public Court(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdT() {
        return idT;
    }
}
