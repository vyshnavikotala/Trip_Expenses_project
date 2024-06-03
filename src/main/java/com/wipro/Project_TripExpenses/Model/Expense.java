package com.wipro.Project_TripExpenses.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Expense {

    @Id
    private Long id;//pk
    private  String Description;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "trip_Id")
    private Trip trip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", Description='" + Description + '\'' +
                ", amount=" + amount +
                ", trip=" + trip +
                '}';
    }
}
