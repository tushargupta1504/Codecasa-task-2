import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isReserved;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public boolean isRoomAvailable(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isReserved()) {
                return true;
            }
        }
        return false;
    }

    public void reserveRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.reserve();
                System.out.println("Room " + roomNumber + " has been reserved.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not available for reservation.");
    }

    public void cancelRoomReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.cancelReservation();
                System.out.println("Reservation for room " + roomNumber + " has been canceled.");
                return;
            }
        }
        System.out.println("Invalid room number.");
    }
}

public class ReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(10); // Create a hotel with 10 rooms

        while (true) {
            System.out.println("1. Check room availability");
            System.out.println("2. Reserve a room");
            System.out.println("3. Cancel room reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    if (hotel.isRoomAvailable(roomNumber)) {
                        System.out.println("Room " + roomNumber + " is available.");
                    } else {
                        System.out.println("Room " + roomNumber + " is not available.");
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to reserve: ");
                    int reserveRoomNumber = scanner.nextInt();
                    hotel.reserveRoom(reserveRoomNumber);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    hotel.cancelRoomReservation(cancelRoomNumber);
                    break;
                case 4:
                    System.out.println("Exiting the reservation system. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
