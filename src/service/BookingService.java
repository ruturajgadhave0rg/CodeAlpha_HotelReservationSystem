package service;

import java.util.ArrayList;
import model.Booking;
import model.Customer;
import model.Room;

public class BookingService {

    private ArrayList<Booking> bookings;
    private int bookingCounter;

    // Constructor
    public BookingService() {
        bookings = new ArrayList<>();
        bookingCounter = 1001;
    }

    // Book a room
    public Booking bookRoom(Customer customer, Room room, int days) {

        if (!room.isAvailable()) {
            System.out.println("Room is already booked.");
            return null;
        }

        room.setAvailable(false);

        Booking booking = new Booking(bookingCounter++, customer, room, days);

        bookings.add(booking);

        return booking;
    }

    // Cancel booking
    public boolean cancelBooking(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {

                booking.getRoom().setAvailable(true);

                bookings.remove(booking);

                return true;
            }
        }

        return false;
    }

    // Search booking
    public Booking searchBooking(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {
                return booking;
            }

        }

        return null;
    }

    // Display all bookings
    public void displayBookings() {

        if (bookings.isEmpty()) {

            System.out.println("\nNo bookings found.");

            return;
        }

        for (Booking booking : bookings) {

            System.out.println(booking);

        }
    }

    // Return booking list
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

}