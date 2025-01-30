import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Price per Night: $" + pricePerNight + ", Available: " + isAvailable;
    }
}

class Reservation {
    private Room room;
    private String guestName;
    private int numberOfNights;
    private double totalCost;

    public Reservation(Room room, String guestName, int numberOfNights) {
        this.room = room;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
        this.totalCost = room.getPricePerNight() * numberOfNights;
        room.setAvailable(false);
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Reservation for " + guestName + ": Room " + room.getRoomNumber() + " (" + room.getCategory() + "), " + numberOfNights + " nights, Total Cost: Rupees " + totalCost;
    }
}

public class Hotel_Reservation_System_Task4 {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel_Reservation_System_Task4() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 250));
        rooms.add(new Room(104, "Single", 100));
        rooms.add(new Room(105, "Double", 150));
    }

    public void searchAvailableRooms(String category) {
        System.out.println("Available rooms in category: " + category);
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(String guestName, int roomNumber, int numberOfNights) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Reservation reservation = new Reservation(room, guestName, numberOfNights);
                reservations.add(reservation);
                System.out.println("Reservation successful: " + reservation);
                processPayment(reservation.getTotalCost());
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    public void viewReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    private void processPayment(double amount) {
        System.out.println("Processing payment of Rupees: " + amount + ".");
        // Simulate payment processing
        System.out.println("Payment successful!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel_Reservation_System_Task4 system = new Hotel_Reservation_System_Task4();

        while (true) {
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("============================================== ");
                    System.out.print("Enter room category (Single/Double/Suite): ");
                    System.out.print("============================================== ");
                    String category = scanner.nextLine();
                    system.searchAvailableRooms(category);
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int numberOfNights = scanner.nextInt();
                    system.makeReservation(guestName, roomNumber, numberOfNights);
                    break;
                case 3:
                    system.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

