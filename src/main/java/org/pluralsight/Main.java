package org.pluralsight;

public class Main {
    public static void main(String[] args) {

        // ====== ROOM FLOW ======
        System.out.println("--- ROOM FLOW TEST ---");
        Room room = new Room(1, 99.0, false, false);
        System.out.println("available (start) = " + room.isAvailable());  // true
        room.checkIn();
        System.out.println("after checkIn: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty()); // true,true
        room.checkOut();
        System.out.println("after checkOut: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty()); // false,true
        room.cleanRoom();
        System.out.println("after cleanRoom: available = " + room.isAvailable()); // true

        // ====== EMPLOYEE (вариант A: две функции punchIn/punchOut с параметрами) ======
        System.out.println("\n--- EMPLOYEE PUNCH TEST (param) ---");
        Employee eldar = new Employee("ID3108", "Eldar", "Front Desk", 18.0);
        eldar.punchIn(10.0);   // 10:00
        eldar.punchOut(12.5);  // 12:30  -> +2.5h
        eldar.punchIn(14.0);   // 14:00
        eldar.punchOut(16.25); // 16:15  -> +2.25h
        System.out.println("hoursWorked = " + eldar.getHoursWorked());   // 4.75
        System.out.println("regular     = " + eldar.getRegularHours());  // 4.75
        System.out.println("overtime    = " + eldar.getOvertimeHours()); // 0.0
        System.out.println("totalPay    = " + eldar.getTotalPay());      // 85.5

        // ====== EMPLOYEE (одна кнопка: punchTimeCard) ======
        System.out.println("\n--- EMPLOYEE ONE-BUTTON (punchTimeCard) ---");
        Employee toffer = new Employee("ID3200", "Toffer", "Front Desk", 17.0);
        toffer.punchTimeCard(9.0);   // IN  09:00
        toffer.punchTimeCard(12.0);  // OUT 12:00 -> +3.0
        System.out.println("Toffer hoursWorked = " + toffer.getHoursWorked()); // 3.0

        // ====== EMPLOYEE (перегрузки без аргументов — текущее время) ======
        System.out.println("\n--- EMPLOYEE NO-ARG (uses LocalDateTime.now) ---");
        Employee live = new Employee("ID3399", "LiveClock", "Front Desk", 18.0);
        live.punchIn();    // возьмёт текущее время
        // ... через пару минут ...
        live.punchOut();   // возьмёт текущее время
        System.out.println("LiveClock hoursWorked ≈ " + live.getHoursWorked()); // зависит от реального времени

        // ====== EMPLOYEE OVERTIME (Aldoz) ======
        System.out.println("\n--- EMPLOYEE OVERTIME (Aldoz) ---");
        Employee aldoz = new Employee("ID3110", "Aldoz", "Housekeeping", 20.0);
        // 4 дня по 10 часов = 40
        aldoz.punchIn(8.0);  aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);  aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);  aldoz.punchOut(18.0);
        aldoz.punchIn(8.0);  aldoz.punchOut(18.0);
        // Пятый день: 5 часов -> overtime
        aldoz.punchIn(8.0);  aldoz.punchOut(13.0);
        System.out.println("hoursWorked = " + aldoz.getHoursWorked());   // 45
        System.out.println("regular     = " + aldoz.getRegularHours());  // 40
        System.out.println("overtime    = " + aldoz.getOvertimeHours()); // 5
        System.out.println("totalPay    = " + aldoz.getTotalPay());      // 950

        // ====== RESERVATION quick check ======
        System.out.println("\n--- RESERVATION QUICK CHECK ---");
        Reservation r1 = new Reservation("king", 3, true);
        System.out.println("r1 price/night = " + r1.getPrice());            // 152.9
        System.out.println("r1 total       = " + r1.getReservationTotal()); // 458.7
        Reservation r2 = new Reservation("double", 2, false);
        System.out.println("r2 price/night = " + r2.getPrice());            // 124.0
        System.out.println("r2 total       = " + r2.getReservationTotal()); // 248.0

        // ====== HOTEL demo ======
        System.out.println("\n--- HOTEL DEMO ---");
        Hotel h = new Hotel("Ocean View", 5, 20); // 5 suites, 20 basic
        System.out.println("Suites available: " + h.getAvailableSuites()); // 5
        System.out.println("Rooms  available: " + h.getAvailableRooms());  // 20
        System.out.println("Book 2 suites -> " + h.bookRoom(2, true));     // true
        System.out.println("Book 25 rooms -> " + h.bookRoom(25, false));   // false
        System.out.println("Book 3 rooms  -> " + h.bookRoom(3, false));    // true
        System.out.println("Suites available now: " + h.getAvailableSuites()); // 3
        System.out.println("Rooms  available now: " + h.getAvailableRooms());  // 17
    }
}
