package org.example.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Turf turf;

    @ManyToOne
    private User user;

    public Booking() {
    }

    public Booking(Long id, User user, Turf turf) {
        this.id = id;
        this.user = user;
        this.turf = turf;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Turf getTurf() { return turf; }
    public void setTurf(Turf turf) { this.turf = turf; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}
