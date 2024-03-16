package com.gridnine.testing.testPackage;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.util.ArrayList;
import java.util.List;

public class ArriveBeforeDeparture implements FlightFilter {
    // Имеются сегменты с датой прилёта раньше даты вылета
    public boolean search(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isAfter(seg.getArrivalDate()))
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
