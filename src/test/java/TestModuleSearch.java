import com.gridnine.testing.testPackage.ArriveBeforeDeparture;
import com.gridnine.testing.testPackage.DepartureBeforeCurrentTime;
import com.gridnine.testing.testPackage.TimeMoreThanTwoHours;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestModuleSearch {

    // проверка условия на соответствие true/false
    private List<Flight> flights;

    @Before
    public void createFlights() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void arriveBeforeDepartureTest() {
        ArriveBeforeDeparture arriveBeforeDeparture = new ArriveBeforeDeparture();
        Assert.assertTrue(arriveBeforeDeparture.search(flights.get(3)));
        Assert.assertFalse(arriveBeforeDeparture.search(flights.get(1)));
    }

    @Test
    public void departureBeforeCurrentTimeTest() {
        DepartureBeforeCurrentTime departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
        Assert.assertTrue(departureBeforeCurrentTime.search(flights.get(2)));
        Assert.assertFalse(departureBeforeCurrentTime.search(flights.get(3)));
    }

    @Test
    public void timeMoreThanTwoHoursTest() {
        TimeMoreThanTwoHours timeMoreThanTwoHours = new TimeMoreThanTwoHours();
        Assert.assertTrue(timeMoreThanTwoHours.search(flights.get(4)));
        Assert.assertFalse(timeMoreThanTwoHours.search(flights.get(5)));
    }
}
