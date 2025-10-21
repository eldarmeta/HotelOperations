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
        if (startTime == null) return;

        double workedHours = time - startTime;
        if (workedHours > 0) {
            hoursWorked += workedHours;
        }
        startTime = null;
    }

    public void punchTimeCard(double time) {
        if (startTime == null) {
            startTime = time;
        } else {
            double worked = time - startTime;
            if (worked > 0) hoursWorked += worked;
            startTime = null;
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours() {
        return hoursWorked <= 40 ? hoursWorked : 40;
    }

    public double getOvertimeHours() {
        return hoursWorked > 40 ? hoursWorked - 40 : 0;
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }
}
