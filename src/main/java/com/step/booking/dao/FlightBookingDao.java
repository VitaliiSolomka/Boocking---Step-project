package com.step.booking.dao;

import java.util.List;

public interface FlightBookingDao {

    List<Flight> findAll();
    void bookingFlight(Flight Flight);
    boolean cancelBooking(int id);
}
