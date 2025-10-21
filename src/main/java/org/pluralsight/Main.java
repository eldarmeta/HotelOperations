package org.pluralsight;


public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Reservation TEST ---");
        Reservation r1 = new Reservation("king", 3, true);
        System.out.println("r1 price per night = " + r1.getPrice());
        System.out.println("r1 total = " + r1.getReservationTotal());

        Reservation r2 = new Reservation("double", 2, false);
        System.out.println("r2 price per night = " + r2.getPrice());
        System.out.println("r2 total = " + r2.getReservationTotal());
    }
    }

