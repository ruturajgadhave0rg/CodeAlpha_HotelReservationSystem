package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Booking;

public class FileManager {

    private static final String FILE_NAME = "data/bookings.txt";

    // Save all bookings to file
    public static void saveBookings(ArrayList<Booking> bookings) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Booking booking : bookings) {

                writer.write("====================================");
                writer.newLine();

                writer.write("Booking ID : " + booking.getBookingId());
                writer.newLine();

                writer.write("Customer Name : " + booking.getCustomer().getName());
                writer.newLine();

                writer.write("Phone : " + booking.getCustomer().getPhone());
                writer.newLine();

                writer.write("Email : " + booking.getCustomer().getEmail());
                writer.newLine();

                writer.write("Room Number : " + booking.getRoom().getRoomNumber());
                writer.newLine();

                writer.write("Category : " + booking.getRoom().getCategory());
                writer.newLine();

                writer.write("Days : " + booking.getNumberOfDays());
                writer.newLine();

                writer.write("Total Amount : ₹" + booking.getTotalAmount());
                writer.newLine();

                writer.write("Payment : " +
                        (booking.isPaymentStatus() ? "Paid" : "Pending"));
                writer.newLine();

                writer.write("====================================");
                writer.newLine();
                writer.newLine();
            }

            System.out.println("Bookings saved successfully to bookings.txt");

        } catch (IOException e) {

            System.out.println("Error saving bookings!");

            e.printStackTrace();
        }
    }
}