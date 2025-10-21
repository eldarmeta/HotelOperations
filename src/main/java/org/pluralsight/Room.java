package org.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPrice() { return price; }
    public boolean isOccupied() { return occupied; }
    public boolean isDirty() { return dirty; }

    public boolean isAvailable() { return !dirty && !occupied; }

    public void checkIn() {
        if (!isAvailable()) return; // не пускаем, если недоступен
        occupied = true;
        dirty = true;
    }

    public void checkOut() {
        if (!occupied) return; // уже пустой
        occupied = false;
    }

    public void cleanRoom() {
        dirty = false;
    }
}
