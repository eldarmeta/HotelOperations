package org.pluralsight;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- ROOM FLOW TEST ---");
        Room room = new Room(1, 99.0, false, false);
        System.out.println("Room available at start: " + room.isAvailable());

        System.out.println("Guest checks in...");
        room.checkIn();
        System.out.println("Occupied: " + room.isOccupied() + ", Dirty: " + room.isDirty());

        System.out.println("Guest checks out...");
        room.checkOut();
        System.out.println("Occupied: " + room.isOccupied() + ", Dirty: " + room.isDirty());

        System.out.println("Housekeeping cleans room...");
        room.cleanRoom();
        System.out.println("Room available now: " + room.isAvailable());


        System.out.println("\n--- EMPLOYEE WORKFLOW TEST ---");

        Employee eld = new Employee("ID3108", "Eldar", "Front Desk", 18.0);

        System.out.println("Eldar arrives at 10:00 and starts shift");
        eld.punchIn(10.0);

        System.out.println("Eldar goes on break at 12:30");
        eld.punchOut(12.5);

        System.out.println("Eldar returns at 14:00 and continues shift");
        eld.punchIn(14.0);

        System.out.println("Eldar ends his shift at 16:15");
        eld.punchOut(16.25);

        System.out.println("Total hours Eldar worked today: " + eld.getHoursWorked());
        System.out.println("Regular hours: " + eld.getRegularHours());
        System.out.println("Overtime hours: " + eld.getOvertimeHours());
        System.out.println("Total pay = " + eld.getTotalPay());
    }
}
