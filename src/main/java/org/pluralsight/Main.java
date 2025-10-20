package org.pluralsight;


public class Main {
    public static void main(String[] args) {
        System.out.println("HotelOperations started");

        Room r = new Room(2, 159.99, false, false);
        System.out.println("beds=" + r.getNumberOfBeds());
        System.out.println("price=" + r.getPrice());
        System.out.println("occupied=" + r.isOccupied());
        System.out.println("dirty=" + r.isDirty());
        System.out.println("available=" + r.isAvailable());
    }
}

