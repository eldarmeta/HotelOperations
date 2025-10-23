package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchFlow_addsWorkedHours_correctly() {
        Employee e = new Employee("ID3108", "Eldar", "Front Desk", 18.0);

        // 10:00 -> 12:30 = 2.5 часа
        e.punchIn(10.0);
        e.punchOut(12.5);

        // 14:00 -> 16:15 = 2.25 часа
        e.punchIn(14.0);
        e.punchOut(16.25);

        // Итого 4.75
        assertEquals(4.75, e.getHoursWorked(), 1e-9);
        assertEquals(4.75, e.getRegularHours(), 1e-9);
        assertEquals(0.0, e.getOvertimeHours(), 1e-9);
        assertEquals(85.5, e.getTotalPay(), 1e-9); // 4.75 * 18.0
    }

    @Test
    void punchOut_withoutPunchIn_doesNothing() {
        Employee e = new Employee("IDX", "X", "Dept", 20.0);
        e.punchOut(12.0); // игнорируется
        assertEquals(0.0, e.getHoursWorked(), 1e-9);
    }

    @Test
    void negativeInterval_isIgnored_byGuard() {
        Employee e = new Employee("IDY", "Y", "Dept", 20.0);
        e.punchIn(12.0);
        e.punchOut(11.5); // worked < 0 -> защита, не добавляем
        assertEquals(0.0, e.getHoursWorked(), 1e-9);
    }

    @Test
    void overtime_isCalculated_over40h() {
        Employee e = new Employee("ID3110", "Aldoz", "Housekeeping", 20.0);

        // 4 смены по 10 часов = 40
        e.punchIn(8.0);  e.punchOut(18.0);
        e.punchIn(8.0);  e.punchOut(18.0);
        e.punchIn(8.0);  e.punchOut(18.0);
        e.punchIn(8.0);  e.punchOut(18.0);

        // +5 часов = 45
        e.punchIn(8.0);  e.punchOut(13.0);

        assertEquals(45.0, e.getHoursWorked(), 1e-9);
        assertEquals(40.0, e.getRegularHours(), 1e-9);
        assertEquals(5.0, e.getOvertimeHours(), 1e-9);
        // 40*20 + 5*(20*1.5) = 800 + 150 = 950
        assertEquals(950.0, e.getTotalPay(), 1e-9);
    }
}
