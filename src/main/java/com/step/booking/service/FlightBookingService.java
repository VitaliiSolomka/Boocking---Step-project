package com.step.booking.service;

import java.time.LocalDate;

public interface FlightBookingService {
    List<Flight> findFilteredFlights (String arriveFlight, LocalDate date, int numberOfPeople) {
        return findAll().stream()
                .filter(e -> e.getArriveFlight == arriveFlight)
                .filter(e -> e.getDate == date)
                .filter(e -> e.getNumberOfPeople >= numberOfPeople)
                .toList();

    }
}
