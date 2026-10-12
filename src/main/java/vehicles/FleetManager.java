package vehicles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Step 3: Implement the Polymorphic FleetManager.
 * Demonstrates:
 * - Polymorphism (holding heterogeneous subclasses in a List<Vehicle>)
 * - Invariant checking (rejecting null vehicles)
 * - Encapsulation (unmodifiable view)
 */
public class FleetManager {

    private final List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Adds a vehicle to the fleet.
     *
     * @param vehicle vehicle to add (must not be null)
     */
    public void addVehicle(Vehicle vehicle) {
        // TODO [Step 3.1]: If vehicle is null, throw IllegalArgumentException
        // TODO [Step 3.2]: Add vehicle to vehicles list
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    /**
     * Calculates the total passenger capacity across all vehicles in the fleet.
     * Must demonstrate polymorphic iteration over List<Vehicle>.
     *
     * @return total passenger capacity
     */
    public int getTotalPassengerCapacity() {
        // TODO [Step 3.3]: Loop through vehicles and sum each vehicle's getPassengerCapacity()
        return 0;
    }

    /**
     * Finds the fastest vehicle in the fleet based on maxSpeed.
     *
     * @return the fastest Vehicle, or null if fleet is empty
     */
    public Vehicle findFastestVehicle() {
        // TODO [Step 3.4]: Return the vehicle with highest maxSpeed, or null if list is empty
        return null;
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
}
