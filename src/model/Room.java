package model;

public class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room No: " + roomNumber +
               "\nCategory: " + category +
               "\nPrice: ₹" + price +
               "\nAvailable: " + (available ? "Yes" : "No");
    }
}
