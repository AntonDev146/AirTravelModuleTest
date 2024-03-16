package com.gridnine.testing.testPackage;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureBeforeCurrentTime implements FlightFilter {
    // Вылет до текущего момента времени
    public boolean search(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now()))
                return true;
        }
        return false;
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> noFiltering) {
        List<Flight> filtred = new ArrayList<>();

        for (Flight flight : noFiltering) {
            if (search(flight)) {
                filtred.add(flight);
            }
        }
        return filtred;
    }
}
