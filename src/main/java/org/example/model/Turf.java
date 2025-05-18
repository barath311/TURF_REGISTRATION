package org.example.model;

import jakarta.persistence.*;


@Entity
@Table(name = "turfs")

public class Turf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private int baseRate;
    // Base rate per hour (e.g., 100 for 4-6 PM slot)


    public Turf() {
    }

    public Turf(String name, String location, int baseRate) {

        this.name = name;
        this.location = location;
        this.baseRate = baseRate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getBaseRate() {
        return baseRate;
    }
}
