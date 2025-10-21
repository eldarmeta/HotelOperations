package org.pluralsight;


public class Main {
    public static void main(String[] args)

    {System.out.println("\n--- Employee TEST ---");
        Employee e1 = new Employee("ID3103", "Thomas Trump", "Housekeeping", 20.0, 46.5);
        System.out.println("reg hours: " + e1.getRegularHours());
        System.out.println("ot hours : " + e1.getOvertimeHours());
        System.out.println("total pay: " + e1.getTotalPay());

        System.out.println();

        Employee e2 = new Employee("ID3105", "Eldar Abd", "Front Desk", 180.5, 38.0);
        System.out.println("reg hours: " + e2.getRegularHours());
        System.out.println("ot hours : " + e2.getOvertimeHours());
        System.out.println("total pay: " + e2.getTotalPay());

    }
    }

