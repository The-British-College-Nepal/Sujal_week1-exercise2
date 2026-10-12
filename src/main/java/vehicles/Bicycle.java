package vehicles;

/**
 * Step 1: Complete the Bicycle subclass.
 * Extends {@link Vehicle}.
 *
 * Requirements:
 * 1. Constructor: Bicycle(String model, int maxSpeed, int gearCount)
 *    - Must chain to super constructor with (model, maxSpeed, 1) because a standard bike has 1 passenger capacity.
 *    - Must check that gearCount > 0; throw IllegalArgumentException if gearCount <= 0.
 *    - Store gearCount in the private field.
 * 2. getGearCount(): Return the gearCount.
 * 3. calculateTravelTime(double distanceInKm):
 *    - Must throw IllegalArgumentException if distanceInKm <= 0.
 *    - Must return distanceInKm / getMaxSpeed().
 */
public class Bicycle extends Vehicle {

    private int gearCount;

    public Bicycle(String model, int maxSpeed, int gearCount) {
        super(model, maxSpeed, 1);

        // TODO [Step 1.1]: Validate gearCount > 0. If gearCount <= 0, throw IllegalArgumentException
        // Hint: if (gearCount <= 0) throw new IllegalArgumentException("Gear count must be positive");

        // TODO [Step 1.2]: Assign gearCount to this.gearCount
    }

    public int getGearCount() {
        // TODO [Step 1.3]: Return gearCount
        return 0;
    }

    @Override
    public double calculateTravelTime(double distanceInKm) {
        // TODO [Step 1.4]: Check distanceInKm > 0. If distanceInKm <= 0, throw IllegalArgumentException

        // TODO [Step 1.5]: Return distanceInKm / getMaxSpeed()
        return 0.0;
    }
}
