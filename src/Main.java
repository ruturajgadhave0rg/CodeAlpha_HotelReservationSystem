import java.util.Scanner;
import model.Booking;
import model.Customer;
import model.Room;
import service.BookingService;
import service.HotelService;
import service.PaymentService;
import util.FileManager;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HotelService hotelService = new HotelService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        boolean exit = false;

        while (!exit) {

            System.out.println("\n======================================");
            System.out.println("     HOTEL RESERVATION SYSTEM");
            System.out.println("======================================");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search Room");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Booking Details");
            System.out.println("6. Make Payment");
            System.out.println("7. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                                case 1:

                    hotelService.displayRooms();
                    break;

                case 2:

                    System.out.print("Enter Room Number to Search: ");
                    int searchRoomNo = scanner.nextInt();

                    Room searchedRoom = hotelService.searchRoom(searchRoomNo);

                    if (searchedRoom != null) {
                        System.out.println("\nRoom Found:");
                        System.out.println(searchedRoom);
                    } else {
                        System.out.println("Room not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Customer Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Room Number: ");
                    int roomNo = scanner.nextInt();

                    Room room = hotelService.searchRoom(roomNo);

                    if (room == null) {

                        System.out.println("Room not found.");
                        break;

                    }

                    if (!room.isAvailable()) {

                        System.out.println("Room is already booked.");
                        break;

                    }

                    System.out.print("Enter Number of Days: ");
                    int days = scanner.nextInt();

                    Customer customer = new Customer(name, phone, email);

                    Booking booking =
                            bookingService.bookRoom(customer, room, days);

                    if (booking != null) {

                        System.out.println("\nBooking Successful!");
                        System.out.println(booking);

                        // Save booking to file
                        FileManager.saveBookings(
                                bookingService.getBookings());

                    }

                    break;

                case 4:

                    System.out.print("Enter Booking ID to Cancel: ");
                    int cancelId = scanner.nextInt();

                    if (bookingService.cancelBooking(cancelId)) {

                        System.out.println("Booking Cancelled Successfully.");

                        // Update file
                        FileManager.saveBookings(
                                bookingService.getBookings());

                    } else {

                        System.out.println("Booking ID not found.");

                    }

                    break;      
                    
                                case 5:

                    System.out.print("Enter Booking ID: ");
                    int bookingId = scanner.nextInt();

                    Booking bookingDetails = bookingService.searchBooking(bookingId);

                    if (bookingDetails != null) {

                        System.out.println(bookingDetails);

                    } else {

                        System.out.println("Booking not found.");

                    }

                    break;

                case 6:

                    System.out.print("Enter Booking ID: ");
                    int paymentBookingId = scanner.nextInt();

                    Booking paymentBooking =
                            bookingService.searchBooking(paymentBookingId);

                    if (paymentBooking != null) {

                        paymentService.makePayment(paymentBooking);

                        // Save updated payment status
                        FileManager.saveBookings(
                                bookingService.getBookings());

                    } else {

                        System.out.println("Booking not found.");

                    }

                    break;

                case 7:

                    exit = true;
                    System.out.println("\nThank you for using Hotel Reservation System!");
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }

        }

        scanner.close();

    }

}
