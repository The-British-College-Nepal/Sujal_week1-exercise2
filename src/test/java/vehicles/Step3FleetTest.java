package vehicles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 3: Polymorphic FleetManager Tests")
public class Step3FleetTest {

    @Test
    @DisplayName("FleetManager adds vehicles and tracks count")
    void testAddVehicles() {
        FleetManager manager = new FleetManager();
        assertEquals(0, manager.getVehicleCount());

        manager.addVehicle(new Bicycle("Trek", 25, 21));
        manager.addVehicle(new Car("Toyota", 160, 5, 80));

        assertEquals(2, manager.getVehicleCount());
    }

    @Test
    @DisplayName("FleetManager rejects adding null vehicle")
    void testRejectsNullVehicle() {
        FleetManager manager = new FleetManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addVehicle(null),
                "Should throw IllegalArgumentException when adding null vehicle");
    }

    @Test
    @DisplayName("FleetManager calculates total passenger capacity polymorphically")
    void testTotalPassengerCapacity() {
        FleetManager manager = new FleetManager();
        manager.addVehicle(new Bicycle("Commuter Bike", 20, 7)); // capacity = 1
        manager.addVehicle(new Car("Sedan", 180, 5, 90));         // capacity = 5
        manager.addVehicle(new Car("Minivan", 150, 7, 75));       // capacity = 7

        // 1 + 5 + 7 = 13
        assertEquals(13, manager.getTotalPassengerCapacity(),
                "Total passenger capacity should sum all heterogeneous vehicle capacities");
    }

    @Test
    @DisplayName("FleetManager identifies fastest vehicle in fleet")
    void testFindFastestVehicle() {
        FleetManager manager = new FleetManager();
        assertNull(manager.findFastestVehicle(), "Empty fleet should return null for fastest vehicle");

        Vehicle bike = new Bicycle("Road Bike", 35, 18);
        Vehicle car1 = new Car("Hatchback", 150, 4, 50);
        Vehicle sportsCar = new Car("Porsche 911", 300, 2, 95);

        manager.addVehicle(bike);
        manager.addVehicle(car1);
        manager.addVehicle(sportsCar);

        Vehicle fastest = manager.findFastestVehicle();
        assertNotNull(fastest);
        assertEquals("Porsche 911", fastest.getModel());
        assertEquals(300, fastest.getMaxSpeed());
    }
}
