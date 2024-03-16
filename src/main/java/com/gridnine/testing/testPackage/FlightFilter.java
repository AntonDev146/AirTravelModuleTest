package com.gridnine.testing.testPackage;

import com.gridnine.testing.testClasses.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> getFilteredFlights(List<Flight> noFiltering);
}
