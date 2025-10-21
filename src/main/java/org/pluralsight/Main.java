package org.pluralsight;


public class Main {
    public static void main(String[] args){


                Room room = new Room(1, 99.0, false, false);

                System.out.println("available (start) = " + room.isAvailable());  // true

                room.checkIn();
                System.out.println("after checkIn: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty());
                // occupied=true, dirty=true

                room.checkOut();
                System.out.println("after checkOut: occupied=" + room.isOccupied() + ", dirty=" + room.isDirty());
                // occupied=false, dirty=true

                room.cleanRoom();
                System.out.println("after cleanRoom: available = " + room.isAvailable());
                // true (ready for next guest)
            }
        }




