package vehicles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 1: Bicycle Implementation Tests")
public class Step1BicycleTest {

    @Test
    @DisplayName("Bicycle initializes correctly with superclass and subclass state")
    void testBicycleInitialization() {
        Bicycle bike = new Bicycle("Trek Marlin 7", 30, 21);
        assertEquals("Trek Marlin 7", bike.getModel());
        assertEquals(30, bike.getMaxSpeed());
        assertEquals(1, bike.getPassengerCapacity(), "Bicycle must pass 1 as passenger capacity to super()");
        assertEquals(21, bike.getGearCount());
    }

    @Test
    @DisplayName("Bicycle calculates travel time accurately")
    void testCalculateTravelTime() {
        Bicycle bike = new Bicycle("Giant Escape", 25, 18);
        double time = bike.calculateTravelTime(50.0);
        assertEquals(2.0, time, 0.001, "Travel time for 50km at 25km/h should be 2.0 hours");
    }

    @Test
    @DisplayName("Bicycle rejects invalid gear count (<= 0)")
    void testThrowsOnInvalidGearCount() {
        assertThrows(IllegalArgumentException.class, () -> new Bicycle("Trek", 25, 0),
                "Should throw IllegalArgumentException when gearCount is 0");
        assertThrows(IllegalArgumentException.class, () -> new Bicycle("Trek", 25, -5),
                "Should throw IllegalArgumentException when gearCount is negative");
    }

    @Test
    @DisplayName("Bicycle rejects invalid travel distance (<= 0)")
    void testThrowsOnInvalidDistance() {
        Bicycle bike = new Bicycle("Trek", 25, 18);
        assertThrows(IllegalArgumentException.class, () -> bike.calculateTravelTime(0),
                "Should throw IllegalArgumentException when distance is 0");
        assertThrows(IllegalArgumentException.class, () -> bike.calculateTravelTime(-10),
                "Should throw IllegalArgumentException when distance is negative");
    }

    @Test
    @DisplayName("Bicycle inherits Vehicle base invariant validation")
    void testInheritsBaseValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Bicycle("", 25, 10),
                "Should throw IllegalArgumentException when model is blank");
        assertThrows(IllegalArgumentException.class, () -> new Bicycle("Trek", 0, 10),
                "Should throw IllegalArgumentException when maxSpeed is 0");
    }
}
