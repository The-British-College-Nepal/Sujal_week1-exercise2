# 🚗 SSD Interactive Lab: Vehicle Hierarchy & Object-Oriented Design
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University)**

```
Progress: [██████░░░░░░░░░░░░] Step 1 of 3 (In Progress)
```

---

## 🎯 Welcome to Your Interactive Lab!

Welcome! In this hands-on exercise, you will practice core Object-Oriented principles in Java by building a **Vehicle Hierarchy**.

Just like GitHub Skills exercises:
1. You complete the task described in this README.
2. Commit and push your changes to `main`.
3. GitHub Actions automatically runs tests and checks your progress.
4. If your code passes, **this README automatically updates to reveal Step 2!**

---

## 🚲 Step 1: Implement `Bicycle.java`

Open [`src/main/java/vehicles/Bicycle.java`](src/main/java/vehicles/Bicycle.java) in your IDE.

Notice that the abstract base class [`Vehicle.java`](src/main/java/vehicles/Vehicle.java) has already been provided for you with encapsulated state (`model`, `maxSpeed`, `passengerCapacity`) and invariant validation.

### Your Tasks:
1. **Extend `Vehicle`:** `Bicycle` must inherit from `Vehicle`.
2. **Encapsulate `gearCount`:**
   - Store `int gearCount` as a private field.
   - Provide a getter: `public int getGearCount()`.
3. **Constructor Chaining with `super()`:**
   - In `Bicycle(String model, int maxSpeed, int gearCount)`:
     - Call `super(model, maxSpeed, 1)` because a standard bicycle carries **1** passenger.
     - Add defensive invariant check: if `gearCount <= 0`, throw an `IllegalArgumentException("Gear count must be positive")`.
     - Assign `this.gearCount = gearCount`.
4. **Implement `calculateTravelTime(double distanceInKm)`:**
   - Validate input: if `distanceInKm <= 0`, throw an `IllegalArgumentException("Distance must be positive")`.
   - Return `distanceInKm / (double) getMaxSpeed()`.

---

## 🧪 How to Verify Step 1 Locally

Before pushing, verify your implementation with the provided unit test:

```bash
mvn test -Dtest=Step1BicycleTest
```
*(Or right-click `Step1BicycleTest.java` in IntelliJ / VS Code and click **Run**).*

You should see **5 passing tests**:
* `testBicycleInitialization`
* `testCalculateTravelTime`
* `testThrowsOnInvalidGearCount`
* `testThrowsOnInvalidDistance`
* `testInheritsBaseValidation`

---

## 🚀 How to Advance to Step 2

Once your local tests are passing:

```bash
git add src/main/java/vehicles/Bicycle.java
git commit -m "Step 1: Completed Bicycle implementation"
git push origin main
```

> [!TIP]
> After pushing, wait ~15 seconds and refresh this page on GitHub (or run `git pull` locally).  
> GitHub Actions will verify your solution and update this `README.md` to unlock **Step 2: Implement Car.java**!
