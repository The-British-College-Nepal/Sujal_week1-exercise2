package vehicles;

/**
 * Step 2: Complete the Car subclass.
 * Extends {@link Vehicle}.
 *
 * Requirements:
 * 1. Constructor: Car(String model, int maxSpeed, int passengerCapacity, int fuelLevelPercent)
 *    - Must call super(model, maxSpeed, passengerCapacity).
 *    - Must validate fuelLevelPercent is between 0 and 100 (inclusive); throw IllegalArgumentException otherwise.
 *    - Store fuelLevelPercent in private field.
 * 2. getFuelLevelPercent(): Return fuelLevelPercent.
 * 3. refuel(int amount):
 *    - Throw IllegalArgumentException if amount <= 0.
 *    - Increase fuelLevelPercent by amount, but cap at 100 (fuel cannot exceed 100%).
 * 4. calculateTravelTime(double distanceInKm):
 *    - Throw IllegalArgumentException if distanceInKm <= 0.
 *    - Return distanceInKm / getMaxSpeed().
 */
public class Car extends Vehicle {

    private int fuelLevelPercent;

    public Car(String model, int maxSpeed, int passengerCapacity, int fuelLevelPercent) {
        super(model, maxSpeed, passengerCapacity);

        // TODO [Step 2.1]: Validate fuelLevelPercent is between 0 and 100 (inclusive).
        // If fuelLevelPercent < 0 or fuelLevelPercent > 100, throw IllegalArgumentException

        // TODO [Step 2.2]: Assign fuelLevelPercent
    }

    public int getFuelLevelPercent() {
        // TODO [Step 2.3]: Return fuelLevelPercent
        return 0;
    }

    public void refuel(int amount) {
        // TODO [Step 2.4]: Check amount > 0. If amount <= 0, throw IllegalArgumentException

        // TODO [Step 2.5]: Add amount to fuelLevelPercent, capped at 100
        // Hint: this.fuelLevelPercent = Math.min(100, this.fuelLevelPercent + amount);
    }

    @Override
    public double calculateTravelTime(double distanceInKm) {
        // TODO [Step 2.6]: Check distanceInKm > 0. If distanceInKm <= 0, throw IllegalArgumentException

        // TODO [Step 2.7]: Return distanceInKm / getMaxSpeed()
        return 0.0;
    }
}
