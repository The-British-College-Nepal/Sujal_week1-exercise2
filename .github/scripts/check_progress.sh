#!/usr/bin/env bash
# Automated Evaluation & Step Advancement Script
# Emulates GitHub Skills interactive tutorial mechanics

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
STEP_FILE="$REPO_ROOT/.github/current_step.txt"
STEPS_DIR="$REPO_ROOT/.github/steps"
README_FILE="$REPO_ROOT/README.md"

cd "$REPO_ROOT"

# Determine current step (defaults to 1)
CURRENT_STEP=1
if [ -f "$STEP_FILE" ]; then
  CURRENT_STEP=$(cat "$STEP_FILE" | tr -d '[:space:]')
fi

echo "============================================================"
echo "🤖 SSD Interactive Lab Evaluator"
echo "   Current Step: $CURRENT_STEP"
echo "============================================================"

ADVANCED=false

if [ "$CURRENT_STEP" = "1" ]; then
  echo "🔍 Evaluating Step 1: Bicycle Implementation..."
  if mvn -B test -Dtest=Step1BicycleTest; then
    echo "✅ Step 1 tests passed!"
    echo "2" > "$STEP_FILE"
    cp "$STEPS_DIR/step-2.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 2: Implement Car.java"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 1 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great job implementing \`Bicycle.java\`! Your repository has been updated with instructions for **Step 2: Implement Car.java**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 1 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 1 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your implementation in \`src/main/java/vehicles/Bicycle.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`super(model, maxSpeed, 1)\` is called." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`gearCount <= 0\` throws \`IllegalArgumentException\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`calculateTravelTime\` validates distance > 0 and returns \`distance / maxSpeed\`." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "2" ]; then
  echo "🔍 Evaluating Step 2: Car Implementation..."
  if mvn -B test -Dtest=Step1BicycleTest,Step2CarTest; then
    echo "✅ Step 2 tests passed!"
    echo "3" > "$STEP_FILE"
    cp "$STEPS_DIR/step-3.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 3: Implement FleetManager.java"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 2 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great work on \`Car.java\`! Your repository has been updated with instructions for **Step 3: Implement FleetManager.java**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 2 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 2 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your implementation in \`src/main/java/vehicles/Car.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure fuel level is validated between 0 and 100." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`refuel(amount)\` throws on \`amount <= 0\` and caps at 100%." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "3" ]; then
  echo "🔍 Evaluating Step 3: FleetManager Implementation..."
  if mvn -B test; then
    echo "✅ Step 3 tests passed! Exercise fully completed!"
    echo "completed" > "$STEP_FILE"
    cp "$STEPS_DIR/completed.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Exercise Completed"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🏆 100% Complete! All Steps Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "You have successfully completed Week 1 Exercise 2! Your repository README has been updated to the completion badge." >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 3 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 3 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your implementation in \`src/main/java/vehicles/FleetManager.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`addVehicle(null)\` throws \`IllegalArgumentException\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`getTotalPassengerCapacity()\` loops over all vehicles polymorphically." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`findFastestVehicle()\` returns null on empty list or vehicle with highest maxSpeed." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

else
  echo "🎉 Lab was already completed. Verifying all tests remain green..."
  mvn -B test
  if [ -n "$GITHUB_STEP_SUMMARY" ]; then
    echo "## ✅ All Tests Passing (Lab Complete)" >> "$GITHUB_STEP_SUMMARY"
  fi
fi

# If the step advanced, commit and push changes back to the student repo
if [ "$ADVANCED" = "true" ]; then
  echo "🚀 Committing updated README and advancing step to: $NEXT_STEP"
  git config user.name "github-actions[bot]"
  git config user.email "github-actions[bot]@users.noreply.github.com"
  git add "$README_FILE" "$STEP_FILE"
  git commit -m "🤖 [GitHub Skills] Advance to $NEXT_STEP [skip ci]"
  git push origin main
  echo "✅ Step successfully unlocked!"
fi
