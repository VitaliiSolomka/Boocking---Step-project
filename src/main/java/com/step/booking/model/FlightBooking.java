package com.step.booking.model;

import java.time.LocalDate;

public class FlightBooking {
    private String arriveFlight;
    private LocalDate date;
    private int numberOfPeople;

    FlightBooking (String arriveFlight, LocalDate date, int numberOfPeople) {
        this.arriveFlight = arriveFlight;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
    }

    public String getArriveFlight() {
        return arriveFlight;
    }

    public void setArriveFlight(String arriveFlight) {
        this.arriveFlight = arriveFlight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
