# 🚗 SSD Interactive Lab: Vehicle Hierarchy & Object-Oriented Design
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University)**

```
Progress: [██████████████████] Step 3 of 3 (In Progress)
```

---

## ✅ Step 2 Complete! Great work on `Car.java`!

You successfully handled bounded range invariants (`0 <= fuel <= 100`) and encapsulated state updates.

Now, for the final challenge, you will implement a **Polymorphic Fleet Manager**.

---

## 🏢 Step 3: Implement `FleetManager.java`

Open [`src/main/java/vehicles/FleetManager.java`](src/main/java/vehicles/FleetManager.java) in your IDE.

Polymorphism allows you to treat different subclasses (`Bicycle`, `Car`, etc.) uniformly as `Vehicle` objects without needing `instanceof` or casting.

### Your Tasks:
1. **Implement `addVehicle(Vehicle vehicle)`:**
   - Add defensive check: if `vehicle == null`, throw an `IllegalArgumentException("Vehicle cannot be null")`.
   - Add the vehicle to the internal `vehicles` list.
2. **Implement `getTotalPassengerCapacity()`:**
   - Loop over `vehicles` and sum `v.getPassengerCapacity()` for each vehicle.
   - Return the total capacity.
   - *Notice how this works polymorphically: whether it's a Bicycle (1 passenger) or a Car (5 passengers), Java calls the correct method via dynamic dispatch!*
3. **Implement `findFastestVehicle()`:**
   - If `vehicles` is empty, return `null`.
   - Otherwise, iterate through `vehicles` and find the vehicle with the highest `getMaxSpeed()`.
   - Return that `Vehicle`.

---

## 🧪 How to Verify Step 3 Locally

Run all unit tests across the entire project:

```bash
mvn test
```
*(Or right-click the `src/test/java` folder and select **Run 'All Tests'**).*

All tests across `Step1BicycleTest`, `Step2CarTest`, and `Step3FleetTest` should pass!

---

## 🚀 How to Finish the Lab

Once all your tests pass locally:

```bash
git add src/main/java/vehicles/FleetManager.java
git commit -m "Step 3: Completed FleetManager implementation"
git push origin main
```

> [!TIP]
> After pushing, wait ~15 seconds and refresh this page on GitHub (or run `git pull` locally).  
> GitHub Actions will verify your entire lab and grant you the **Week 1 Exercise 2 Completion Badge**!
