package fr.rolandgarros.rolandgarros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
