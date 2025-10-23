package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_setsOccupiedAndDirty_whenAvailable() {
        Room room = new Room(1, 99.0, false, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());
    }

    @Test
    void checkIn_doesNothing_whenAlreadyOccupied() {
        Room room = new Room(1, 99.0, true, false);
        room.checkIn(); // недоступен -> метод ничего не делает
        assertTrue(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    void checkIn_doesNothing_whenDirty() {
        Room room = new Room(1, 99.0, false, true);
        room.checkIn(); // недоступен -> метод ничего не делает
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkOut_freesRoom_butKeepsDirty() {
        Room room = new Room(1, 99.0, true, true);
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty()); // всё ещё грязный
    }

    @Test
    void cleanRoom_makesRoomAvailable_ifNotOccupied() {
        Room room = new Room(1, 99.0, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    void cleanRoom_canBeCalledWhileOccupied_inCurrentImplementation() {
        // В ТВОЕЙ текущей реализации cleanRoom() не запрещает уборку у занятого номера.
        Room room = new Room(1, 99.0, true, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
        // он останется занятым, т.е. всё ещё not available:
        assertFalse(room.isAvailable());
    }

    // Если ХОЧЕШЬ запретить уборку при занятом номере,
    // измени реализацию и поменяй ожидания в этом тесте
    // на assertTrue(room.isDirty()) или бросай исключение.
}
