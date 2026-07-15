package service;

import model.Booking;

public class PaymentService {

    // Simulate payment
    public void makePayment(Booking booking) {

        if (booking == null) {
            System.out.println("Invalid booking.");
            return;
        }

        if (booking.isPaymentStatus()) {
            System.out.println("Payment has already been completed.");
            return;
        }

        booking.setPaymentStatus(true);

        System.out.println("\n================================");
        System.out.println("     PAYMENT SUCCESSFUL");
        System.out.println("================================");
        System.out.println("Booking ID : " + booking.getBookingId());
        System.out.println("Amount Paid: ₹" + booking.getTotalAmount());
        System.out.println("Thank You!");
        System.out.println("================================");
    }
}
