package stages;

import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowNumber = 0;
        int seatNumber = 0;

        System.out.println("Enter the number of rows:");
        int rows = readInteger(scanner, 1, 9);
        System.out.println("Enter the number of seats in each row:");
        int rowSeats = readInteger(scanner, 1, 9);
        printCinema(rows, rowSeats, rowNumber, seatNumber);

        System.out.println("Enter a row number:");
        rowNumber = readInteger(scanner, 1, rows);
        System.out.println("Enter a seat number in that row:");
        seatNumber = readInteger(scanner, 1, rowSeats);
        printTicketPrice(rows, rowSeats, rowNumber);
        printCinema(rows, rowSeats, rowNumber, seatNumber);
    }

    public static int readInteger(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int number = scanner.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer number.");
                scanner.nextLine();
            }
        }
    }

    public static void printCinema(int rows, int rowSeats, int rowNumber, int seatNumber) {
        char[] numbers = {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'S', 'B'};
        char[][] seats = new char[rows + 1][rowSeats + 1];

        System.out.println();
        System.out.println("Cinema:");
        for (int i = 1; i <= rows; i++) {
            seats[i][1] = numbers[10];
            for (int j = 1; j <= rowSeats; j++) {
                seats[i][j] = numbers[10];
                seats[rowNumber][seatNumber] = numbers[11];
            }
        }
        for (int i = 0; i <= rows; i++) {
            seats[i][0] = numbers[i];
            for (int j = 0; j <= rowSeats; j++) {
                seats[0][j] = numbers[j];
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTicketPrice(int rows, int rowSeats, int rowNumber) {
        int totalSeats = rows * rowSeats;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;
        int ticketPrice;

        if (totalSeats > 60) {
            int half = rows / 2;
            if (rowNumber <= half) {
                ticketPrice = frontHalfPrice;
            } else {
                ticketPrice = backHalfPrice;
            }
        } else {
            ticketPrice = frontHalfPrice;
        }
        System.out.println();
        System.out.println("Ticket Price: $" + ticketPrice);
    }
}
