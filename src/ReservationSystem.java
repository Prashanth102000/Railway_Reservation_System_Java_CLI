import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
        ArrayList<String> availableStations = new ArrayList<>();
        ArrayList<Train> trains = new ArrayList<>();

        public ReservationSystem() {
                availableStations.add("Delhi");
                availableStations.add("Jaipur");
                availableStations.add("Prayagraj");
                availableStations.add("Mumbai");

                trains.add(new Train("Mumbai Superfast", "13:05", 50, 1010));
                trains.add(new Train("Delhi SuperFast", "7:00", 50, 2013));
                trains.add(new Train("Prayagraj EXP", "10:00", 50, 3045));
        }

        public ArrayList<Train> getAvailableTrains(String source, String destination, String date) {
                ArrayList<Train> availableTrains = new ArrayList<>();
                for (Train train : trains) {
                        if (availableStations.contains(source) && availableStations.contains(destination)) {
                                availableTrains.add(train);
                        }
                }
                return availableTrains;
        }

        public int getAvailableSeats(int trainNumber) {
                for (Train train : trains) {
                        if (train.trainNumber == trainNumber) {
                                return train.passengerStrength;
                        }
                }
                return -1; // Train not found
        }

        public void bookTicket(int trainNumber, String passengerName, int seatNumber) {
                for (Train train : trains) {
                        if (train.trainNumber == trainNumber) {
                                if (seatNumber > 0 && seatNumber <= train.passengerStrength) {
                                        train.passengerStrength--;
                                        System.out.println("Ticket booked for " + passengerName + ". Seat Number: " + seatNumber);
                                        return;
                                } else {
                                        System.out.println("Invalid seat number.");
                                        return;
                                }
                        }
                }
                System.out.println("Invalid train number.");
        }

        public void cancelTicket(int trainNumber, String passengerName, int seatNumber) {
                for (Train train : trains) {
                        if (train.trainNumber == trainNumber) {
                                train.passengerStrength++;
                                System.out.println("Ticket cancelled for " + passengerName + ". Seat Number: " + seatNumber);
                                return;
                        }
                }
                System.out.println("Invalid train number.");
        }

        public void displayTicket(int trainNumber) {
                for (Train train : trains) {
                        if (train.trainNumber == trainNumber) {
                                System.out.println(train);
                                return;
                        }
                }
                System.out.println("Invalid train number.");
        }

                public static void main(String[] args) {
                        ReservationSystem reservationSystem = new ReservationSystem();
                        Scanner scanner = new Scanner(System.in);

                        while (true) {
                                System.out.println("\nRailway Reservation System");
                                System.out.println("1. View Available Trains");
                                System.out.println("2. Check Seat Availability");
                                System.out.println("3. Book a Ticket");
                                System.out.println("4. Cancel a Ticket");
                                System.out.println("5. Display Ticket Details");
                                System.out.println("6. Exit");
                                System.out.print("Enter your choice: ");

                                int choice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                switch (choice) {
                                        case 1:
                                                System.out.print("Enter Source Station: ");
                                                String source = scanner.nextLine();
                                                System.out.print("Enter Destination Station: ");
                                                String destination = scanner.nextLine();
                                                System.out.print("Enter Date of Travel (YYYY-MM-DD): ");
                                                String date = scanner.nextLine();

                                                ArrayList<Train> availableTrains = reservationSystem.getAvailableTrains(source, destination, date);
                                                for (Train train : availableTrains) {
                                                        System.out.println(train);
                                                }
                                                break;

                                        case 2:
                                                System.out.print("Enter Train Number: ");
                                                int trainNumber = scanner.nextInt();
                                                int availableSeats = reservationSystem.getAvailableSeats(trainNumber);
                                                if (availableSeats >= 0) {
                                                        System.out.println("Available seats for train " + trainNumber + ": " + availableSeats);
                                                } else {
                                                        System.out.println("Invalid train number.");
                                                }
                                                break;

                                        case 3:
                                                System.out.print("Enter Train Number: ");
                                                int bookTrainNumber = scanner.nextInt();
                                                scanner.nextLine(); // Consume newline
                                                System.out.print("Enter Passenger Name: ");
                                                String passengerName = scanner.nextLine();
                                                System.out.print("Enter Seat Number: ");
                                                int seatNumber = scanner.nextInt();
                                                reservationSystem.bookTicket(bookTrainNumber, passengerName, seatNumber);
                                                break;

                                        case 4:
                                                System.out.print("Enter Train Number: ");
                                                int cancelTrainNumber = scanner.nextInt();
                                                scanner.nextLine(); // Consume newline
                                                System.out.print("Enter Passenger Name: ");
                                                String cancelPassengerName = scanner.nextLine();
                                                System.out.print("Enter Seat Number: ");
                                                int cancelSeatNumber = scanner.nextInt();
                                                reservationSystem.cancelTicket(cancelTrainNumber, cancelPassengerName, cancelSeatNumber);
                                                break;

                                        case 5:
                                                System.out.print("Enter Train Number: ");
                                                int displayTrainNumber = scanner.nextInt();
                                                reservationSystem.displayTicket(displayTrainNumber);
                                                break;

                                        case 6:
                                                scanner.close();
                                                System.exit(0);

                                        default:
                                                System.out.println("Invalid choice. Please try again.");
                                                break;
                                }
                        }
                }
}
