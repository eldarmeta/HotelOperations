package org.pluralsight;

public class Main {
    public static void main(String[] args) {

        Room room = new Room(1, 99.0, false, false);
        System.out.println("available (start) = " + room.isAvailable());  // true

        room.checkIn();
        System.out.println("after checkIn: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty()); // true,true

        room.checkOut();
        System.out.println("after checkOut: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty()); // false,true

        room.cleanRoom();
        System.out.println("after cleanRoom: available = " + room.isAvailable()); // true


        System.out.println("\n EMPLOYEE PUNCH TEST ");

        Employee eldar = new Employee("ID3108", "Eldar", "Front Desk", 18.0);

        System.out.println("Eldar comes at 10:00 (punchIn 10.0)");
        eldar.punchIn(10.0);

        System.out.println("Eldar goes to break at 12:30 (punchOut 12.5)");
        eldar.punchOut(12.5);

        System.out.println("Eldar returns at 14:00 (punchIn 14.0)");
        eldar.punchIn(14.0);

        System.out.println("Eldar ends shift at 16:15 (punchOut 16.25)");
        eldar.punchOut(16.25);

        System.out.println("hoursWorked = " + eldar.getHoursWorked());
        System.out.println("regular     = " + eldar.getRegularHours());
        System.out.println("overtime    = " + eldar.getOvertimeHours());
        System.out.println("totalPay    = " + eldar.getTotalPay());


        System.out.println("\n  OVERTIME EXAMPLE  ");

        Employee aldoz = new Employee("ID3110", "Aldoz", "Housekeeping", 20.0);

        aldoz.punchIn(8.0);
        aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);
        aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);
        aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);
        aldoz.punchOut(18.0);

        aldoz.punchIn(8.0);
        aldoz.punchOut(13.0);

        System.out.println("hoursWorked = " + aldoz.getHoursWorked());   // 45
        System.out.println("regular     = " + aldoz.getRegularHours());  // 40
        System.out.println("overtime    = " + aldoz.getOvertimeHours()); // 5
        System.out.println("totalPay    = " + aldoz.getTotalPay());      // 40*20 + 5*(20*1.5) = 800 + 150 = 950

    }
}
