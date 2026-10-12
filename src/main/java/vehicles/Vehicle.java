package vehicles;

/**
 * Abstract base class representing a generic Vehicle.
 * Demonstrates:
 * - Encapsulation (private fields with invariant checking)
 * - Constructor initialization
 * - Abstraction (abstract method to be fulfilled by subclasses)
 */
public abstract class Vehicle {

    private String model;
    private int maxSpeed;           // in km/h
    private int passengerCapacity;

    /**
     * Constructs a new Vehicle with defensive invariant validation.
     *
     * @param model              the vehicle model name (must not be null or blank)
     * @param maxSpeed           the maximum speed in km/h (must be greater than 0)
     * @param passengerCapacity  the maximum number of passengers (must be greater than 0)
     */
    public Vehicle(String model, int maxSpeed, int passengerCapacity) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Max speed must be greater than zero");
        }
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be greater than zero");
        }
        this.model = model.trim();
        this.maxSpeed = maxSpeed;
        this.passengerCapacity = passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Calculates travel time in hours for a given distance.
     * Concrete subclasses must implement this based on their travel dynamics.
     *
     * @param distanceInKm the distance in kilometers (must be positive)
     * @return the time in hours
     */
    public abstract double calculateTravelTime(double distanceInKm);

    @Override
    public String toString() {
        return String.format("%s [model=%s, maxSpeed=%d km/h, capacity=%d]",
                getClass().getSimpleName(), model, maxSpeed, passengerCapacity);
    }
}
