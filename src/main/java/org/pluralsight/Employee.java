package org.pluralsight;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private Double startTime = null;

    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
    }

    public void punchIn(double time) {
        startTime = time;
    }

    public void punchOut(double time) {
        if (startTime == null) {
            return;
        }
        double worked = time - startTime;
        if (worked > 0) {
            hoursWorked += worked;
        }
        startTime = null;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) return hoursWorked;
        return 40;
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) return hoursWorked - 40;
        return 0;
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }
}
