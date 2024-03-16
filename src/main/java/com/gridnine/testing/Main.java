package com.gridnine.testing;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;
import com.gridnine.testing.testPackage.ArriveBeforeDeparture;
import com.gridnine.testing.testPackage.DepartureBeforeCurrentTime;
import com.gridnine.testing.testPackage.TimeMoreThanTwoHours;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flight = FlightBuilder.createFlights();
        System.out.println("Все вылеты:");
        System.out.println(flight);
        System.out.println("Вылет до текущего момента времени:");
        System.out.println(new DepartureBeforeCurrentTime().getFilteredFlights(flight));
        System.out.println("Имеются сегменты с датой прилёта раньше даты вылета:");
        System.out.println(new ArriveBeforeDeparture().getFilteredFlights(flight));
        System.out.println("Общее время, проведённое на земле превышает два часа:");
        System.out.println(new TimeMoreThanTwoHours().getFilteredFlights(flight));
    }
}
