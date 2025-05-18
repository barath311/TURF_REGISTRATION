package org.example.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "pricing_logic")
public class PricingLogic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turf_id")
    private Turf turf;

    private LocalTime timeSlotStart;  // Only the time

    private LocalTime timeSlotEnd;

    private double rateIncrease;

    private boolean isActive;

    // Constructors
    public PricingLogic() {}

    public PricingLogic(Turf turf, LocalTime timeSlotStart, LocalTime timeSlotEnd, double rateIncrease, boolean isActive) {
        this.turf = turf;
        this.timeSlotStart = timeSlotStart;
        this.timeSlotEnd = timeSlotEnd;
        this.rateIncrease = rateIncrease;
        this.isActive = isActive;
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Turf getTurf() { return turf; }

    public void setTurf(Turf turf) { this.turf = turf; }

    public LocalTime getTimeSlotStart() { return timeSlotStart; }

    public void setTimeSlotStart(LocalTime timeSlotStart) { this.timeSlotStart = timeSlotStart; }

    public LocalTime getTimeSlotEnd() { return timeSlotEnd; }

    public void setTimeSlotEnd(LocalTime timeSlotEnd) { this.timeSlotEnd = timeSlotEnd; }

    public double getRateIncrease() { return rateIncrease; }

    public void setRateIncrease(double rateIncrease) { this.rateIncrease = rateIncrease; }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }
}
