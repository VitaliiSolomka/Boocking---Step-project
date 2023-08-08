package com.step.booking.dao;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileFlightBookingDao implements FlightBookingDao {
    private final static String BOOKING_FLIGHT_DB_PATH = "bookingFlightDB.txt";

    @Override
    List<Flight> findAll() {
        createFile(BOOKING_FLIGHT_DB_PATH);
        List<Flight> resultFlights = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKING_FLIGHT_DB_PATH)) {
            List<String> lines = bufferedReader.lines().toList();
             for (int i = 0; i < lines.size(); i+=3) {
                 String arriveFlight = lines.get(i);
                 LocalDate date = LocalDate.valueOf(lines.get(i+1));
                 int numberOfPeople = Integer.parseInt(lines.get(i+2));
                 resultFlights.add(new FlightBooking(arriveFlight, date, numberOfPeople));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return resultFlights;
    }

    @Override
    void bookingFlight(Flight Flight) {
        createFile(BOOKING_FLIGHT_DB_PATH);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(BOOKING_FLIGHT_DB_PATH, true))) {
            printWriter.println(Flight.getArriveFlight());
            printWriter.println(Flight.getDate());
            printWriter.println(Flight.getNumberOfPeople());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    boolean cancelBooking(int id) {
        createFile(BOOKING_FLIGHT_DB_PATH);

    }

    public void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() | !file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
