# UAT Test Execution Results — Week 5 Fuel Calculator

**Project:** Fuel Calculator (week5-jenkins)
**Version:** 1.0
**Execution Date:** 21/04/2026
**Executed by:** Miska Voutilainen

---

### TC-01 — Default Run Produces Output

| Field | Detail |
|---|---|
| **Name** | 1. Application should run and produce output with default values |
| **Design Date** | 07/04/2026 |
| **Preconditions** | Project is built, JAR is available or IDE is configured |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Build the project with Maven (`mvn package`) | Build succeeds with no errors | Pass | |
| 2 | Run `Main.main()` with default inputs (500 km, 7.5 L/100km, 1.85 EUR/L) | Application starts without exceptions | Pass | |
| 3 | Observe console / log output | Log output contains "Fuel Calculator \| Miska Voutilainen" | Pass | |

**Post-condition:** Application exits cleanly with exit code 0

---

### TC-02 — Fuel Amount Calculation Is Correct

| Field | Detail |
|---|---|
| **Name** | 2. Calculator should compute total fuel used correctly |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(100, 10, 2.0)` | Method executes without exception | Pass | |
| 2 | Read `result.getTotalFuel()` | Returns 10.0 L (100 km × 10 L/100 km ÷ 100) | Pass | |

**Post-condition:** `CalculationRecord.totalFuel` equals 10.0

---

### TC-03 — Total Cost Calculation Is Correct

| Field | Detail |
|---|---|
| **Name** | 3. Calculator should compute total fuel cost correctly |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(100, 10, 2.0)` | Method executes without exception | Pass | |
| 2 | Read `result.getTotalCost()` | Returns 20.0 EUR (10 L × 2.0 EUR/L) | Pass | |

**Post-condition:** `CalculationRecord.totalCost` equals 20.0

---

### TC-04 — Full Record Fields Are Stored Correctly

| Field | Detail |
|---|---|
| **Name** | 4. CalculationRecord should store all input and output fields |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(500, 7.5, 1.85)` | Method executes without exception | Pass | |
| 2 | Read `result.getDistance()` | Returns 500.0 | Pass | |
| 3 | Read `result.getConsumption()` | Returns 7.5 | Pass | |
| 4 | Read `result.getPrice()` | Returns 1.85 | Pass | |
| 5 | Read `result.getTotalFuel()` | Returns 37.5 L | Pass | |
| 6 | Read `result.getTotalCost()` | Returns 69.375 EUR | Pass | |

**Post-condition:** All six getters return the expected values

---

### TC-05 — Short Trip Calculation Is Accurate

| Field | Detail |
|---|---|
| **Name** | 5. Calculator should handle small distances accurately |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(1, 5, 1.5)` | Method executes without exception | Pass | |
| 2 | Read `result.getTotalFuel()` | Returns 0.05 L | Pass | |
| 3 | Read `result.getTotalCost()` | Returns 0.075 EUR | Pass | |

**Post-condition:** Floating-point precision is within 0.001 tolerance

---

### TC-06 — Zero Distance Is Rejected

| Field | Detail |
|---|---|
| **Name** | 6. Calculator should reject zero distance input |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(0, 7.5, 1.85)` | `IllegalArgumentException` is thrown | Pass | |
| 2 | Catch the exception and read its message | Message states all inputs must be positive | Pass | |

**Post-condition:** No `CalculationRecord` is created for invalid input

---

### TC-07 — Negative Distance Is Rejected

| Field | Detail |
|---|---|
| **Name** | 7. Calculator should reject negative distance input |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(-50, 7.5, 1.85)` | `IllegalArgumentException` is thrown | Pass | |
| 2 | Catch the exception | Exception is of type `IllegalArgumentException` | Pass | |

**Post-condition:** No `CalculationRecord` is created for invalid input

---

### TC-08 — Zero or Negative Consumption Is Rejected

| Field | Detail |
|---|---|
| **Name** | 8. Calculator should reject zero or negative fuel consumption input |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(100, 0, 1.85)` | `IllegalArgumentException` is thrown | Pass | |
| 2 | Invoke `calculate(100, -1, 1.85)` | `IllegalArgumentException` is thrown | Pass | |

**Post-condition:** No `CalculationRecord` is created for invalid input

---

### TC-09 — Zero or Negative Price Is Rejected

| Field | Detail |
|---|---|
| **Name** | 9. Calculator should reject zero or negative price input |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` class is available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Invoke `calculate(100, 7.5, 0)` | `IllegalArgumentException` is thrown | Pass | |
| 2 | Invoke `calculate(100, 7.5, -1)` | `IllegalArgumentException` is thrown | Pass | |

**Post-condition:** No `CalculationRecord` is created for invalid input

---

### TC-10 — Output Format Contains All Required Fields

| Field | Detail |
|---|---|
| **Name** | 10. CalculationRecord.toString() should display all required fields and units |
| **Design Date** | 07/04/2026 |
| **Preconditions** | `FuelCalculator` and `CalculationRecord` classes are available |
| **Executed by** | Miska Voutilainen |
| **Execution date** | 21/04/2026 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
|---|---|---|---|---|
| 1 | Create `CalculationRecord(100, 10, 2.0, 10.0, 20.0)` | Object is created successfully | Pass | |
| 2 | Call `record.toString()` | Returns a non-null string | Pass | |
| 3 | Check string contains distance in km | String contains "100.0 km" | Pass | |
| 4 | Check string contains consumption in L/100km | String contains "10.0 L/100km" | Pass | |
| 5 | Check string contains price in EUR/L | String contains "2.00 EUR/L" | Pass | |
| 6 | Check string contains fuel used in L | String contains "10.00 L" | Pass | |
| 7 | Check string contains total cost in EUR | String contains "20.00 EUR" | Pass | |

**Post-condition:** All five data fields with correct units are present in the string output
