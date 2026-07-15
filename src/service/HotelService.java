package service;

import java.util.ArrayList;
import model.Room;

public class HotelService {

    private ArrayList<Room> rooms;

    // Constructor
    public HotelService() {

        rooms = new ArrayList<>();

        // Standard Rooms
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        // Deluxe Rooms
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));

        // Suite Rooms
        rooms.add(new Room(301, "Suite", 4000));
        rooms.add(new Room(302, "Suite", 4000));
    }

    // Display all rooms
    public void displayRooms() {

        System.out.println("\n========== ROOM LIST ==========");

        for (Room room : rooms) {
            System.out.println(room);
            System.out.println("------------------------------");
        }
    }

    // Search room by room number
    public Room searchRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }

        }

        return null;
    }

    // Return all rooms
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}