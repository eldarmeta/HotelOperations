package org.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public double getPrice() {
        double price;
        if (roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else {
            price = 124.00;
        }

        if (weekend) {
            price = price * 1.10;
        }

        return price;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
