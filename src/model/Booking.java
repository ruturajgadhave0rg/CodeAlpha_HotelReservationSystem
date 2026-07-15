package model;

public class Booking {

    private int bookingId;
    private Customer customer;
    private Room room;
    private int numberOfDays;
    private double totalAmount;
    private boolean paymentStatus;

    // Constructor
    public Booking(int bookingId, Customer customer, Room room, int numberOfDays) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.totalAmount = room.getPrice() * numberOfDays;
        this.paymentStatus = false;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    // Setter
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "\n========== BOOKING DETAILS ==========\n" +
               "Booking ID    : " + bookingId +
               "\nCustomer Name : " + customer.getName() +
               "\nRoom Number   : " + room.getRoomNumber() +
               "\nCategory      : " + room.getCategory() +
               "\nDays          : " + numberOfDays +
               "\nTotal Amount  : ₹" + totalAmount +
               "\nPayment       : " + (paymentStatus ? "Paid" : "Pending") +
               "\n=====================================";
    }
}