package com.gridnine.testing.testPackage;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeMoreThanTwoHours implements FlightFilter {
    // Общее время, проведённое на земле превышает два часа
    public boolean search(Flight flight) {

        if (flight.getSegments().size() >= 2) {
            List<Segment> list = flight.getSegments();

            for (int i = 0; i < list.size() - 1; i++) {

                LocalDateTime arr = flight.getSegments().get(i).getArrivalDate().plusMinutes(120);
                LocalDateTime depNext = flight.getSegments().get(i + 1).getDepartureDate();

                if (arr.isBefore(depNext)) {
                    return true;
                } else return false;
            }
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
