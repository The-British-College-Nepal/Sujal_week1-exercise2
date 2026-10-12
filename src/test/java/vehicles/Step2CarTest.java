package vehicles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 2: Car Implementation Tests")
public class Step2CarTest {

    @Test
    @DisplayName("Car initializes correctly with superclass and subclass state")
    void testCarInitialization() {
        Car car = new Car("Tesla Model 3", 225, 5, 80);
        assertEquals("Tesla Model 3", car.getModel());
        assertEquals(225, car.getMaxSpeed());
        assertEquals(5, car.getPassengerCapacity());
        assertEquals(80, car.getFuelLevelPercent());
    }

    @Test
    @DisplayName("Car calculates travel time accurately")
    void testCalculateTravelTime() {
        Car car = new Car("Honda Civic", 180, 5, 50);
        double time = car.calculateTravelTime(360.0);
        assertEquals(2.0, time, 0.001, "Travel time for 360km at 180km/h should be 2.0 hours");
    }

    @Test
    @DisplayName("Car rejects invalid fuel levels (< 0 or > 100)")
    void testThrowsOnInvalidFuelLevel() {
        assertThrows(IllegalArgumentException.class, () -> new Car("Civic", 180, 5, -1),
                "Should throw IllegalArgumentException when fuelLevel < 0");
        assertThrows(IllegalArgumentException.class, () -> new Car("Civic", 180, 5, 101),
                "Should throw IllegalArgumentException when fuelLevel > 100");
    }

    @Test
    @DisplayName("Car refuel increases fuel level and caps at 100%")
    void testRefuel() {
        Car car = new Car("Toyota Corolla", 160, 5, 60);
        car.refuel(20);
        assertEquals(80, car.getFuelLevelPercent(), "Fuel should increase from 60 to 80");

        car.refuel(50);
        assertEquals(100, car.getFuelLevelPercent(), "Fuel level should cap at 100%");
    }

    @Test
    @DisplayName("Car refuel rejects negative or zero amount")
    void testRefuelRejectsInvalidAmount() {
        Car car = new Car("Toyota Corolla", 160, 5, 60);
        assertThrows(IllegalArgumentException.class, () -> car.refuel(0),
                "Refueling with 0 should throw IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> car.refuel(-15),
                "Refueling with negative amount should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Car rejects invalid travel distance (<= 0)")
    void testThrowsOnInvalidDistance() {
        Car car = new Car("Toyota Corolla", 160, 5, 60);
        assertThrows(IllegalArgumentException.class, () -> car.calculateTravelTime(0),
                "Should throw IllegalArgumentException when distance is 0");
        assertThrows(IllegalArgumentException.class, () -> car.calculateTravelTime(-50),
                "Should throw IllegalArgumentException when distance is negative");
    }
}
