# 🚗 SSD Interactive Lab: Vehicle Hierarchy & Object-Oriented Design
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University)**

```
Progress: [████████████░░░░░░] Step 2 of 3 (In Progress)
```

---

## ✅ Step 1 Complete! Excellent job on `Bicycle.java`!

You successfully implemented constructor chaining with `super()`, encapsulated `gearCount`, and enforced defensive invariants.

Now let's move on to Step 2.

---

## 🏎️ Step 2: Implement `Car.java`

Open [`src/main/java/vehicles/Car.java`](src/main/java/vehicles/Car.java) in your IDE.

In this step, you will implement a motorized vehicle with fuel level tracking and refuel domain logic.

### Your Tasks:
1. **Extend `Vehicle`:** `Car` must inherit from `Vehicle`.
2. **Encapsulate `fuelLevelPercent`:**
   - Store `int fuelLevelPercent` (0 to 100) as a private field.
   - Provide a getter: `public int getFuelLevelPercent()`.
3. **Constructor Chaining & Range Invariants:**
   - In `Car(String model, int maxSpeed, int passengerCapacity, int fuelLevelPercent)`:
     - Call `super(model, maxSpeed, passengerCapacity)`.
     - Validate that `fuelLevelPercent >= 0 && fuelLevelPercent <= 100`. If outside this range, throw an `IllegalArgumentException("Fuel level must be between 0 and 100")`.
     - Assign `this.fuelLevelPercent = fuelLevelPercent`.
4. **Implement Refuel Logic (`refuel(int amount)`):**
   - Check input: if `amount <= 0`, throw an `IllegalArgumentException("Refuel amount must be positive")`.
   - Add `amount` to `fuelLevelPercent`, but cap at **100%** (a fuel tank cannot be more than 100% full):
     ```java
     this.fuelLevelPercent = Math.min(100, this.fuelLevelPercent + amount);
     ```
5. **Implement `calculateTravelTime(double distanceInKm)`:**
   - Check input: if `distanceInKm <= 0`, throw an `IllegalArgumentException("Distance must be positive")`.
   - Return `distanceInKm / (double) getMaxSpeed()`.

---

## 🧪 How to Verify Step 2 Locally

Run both Step 1 and Step 2 tests:

```bash
mvn test -Dtest=Step1BicycleTest,Step2CarTest
```
*(Or run `Step2CarTest.java` directly in your IDE).*

You should see all **6 tests pass**:
* `testCarInitialization`
* `testCalculateTravelTime`
* `testThrowsOnInvalidFuelLevel`
* `testRefuel`
* `testRefuelRejectsInvalidAmount`
* `testThrowsOnInvalidDistance`

---

## 🚀 How to Advance to Step 3

Once your local tests are passing:

```bash
git add src/main/java/vehicles/Car.java
git commit -m "Step 2: Completed Car implementation"
git push origin main
```

> [!TIP]
> After pushing, wait ~15 seconds and refresh this page on GitHub (or run `git pull` locally).  
> GitHub Actions will verify your solution and update this `README.md` to unlock **Step 3: Polymorphic Fleet Manager**!
