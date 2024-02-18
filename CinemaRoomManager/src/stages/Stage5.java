package stages;

import java.util.Scanner;

public class Stage5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = readInteger(scanner, 1, 9);
        System.out.println("Enter the number of seats in each row:");
        int rowSeats = readInteger(scanner, 1, 9);

        showMenu(scanner, rows, rowSeats);
    }
    public static int readInteger(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int number = scanner.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Wrong input!");
                }
            } catch (Exception e) {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }
    }
    public static void showMenu(Scanner scanner, int rows, int rowSeats) {
        char[] numbers = {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'S', 'B'};
        char[][] seats = new char[rows + 1][rowSeats + 1];
        fillSeats(rows, rowSeats, seats, numbers);

        int rowNumber = 0;
        int seatNumber = 0;

        int totalSeats = rows * rowSeats;
        int ticketsPurchased = 0;
        int currentIncome = 0;
        int totalIncome = calculateTotalIncome(rows, rowSeats, totalSeats);

        boolean isMenuOpen = false;

        while (!isMenuOpen) {
            System.out.println("""
                \n1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");

            int options = readInteger(scanner, 0, 3);
            switch (options) {
                case 0 -> isMenuOpen = true;
                case 1 -> showCinemaSeats(rows, rowSeats, seats, numbers, rowNumber, seatNumber);
                case 2 -> {
                    while (true) {
                        System.out.println("\nEnter a row number:");
                        rowNumber = readInteger(scanner, 1, rows);
                        System.out.println("Enter a seat number in that row:");
                        seatNumber = readInteger(scanner, 1, rowSeats);

                        if (seats[rowNumber][seatNumber] != numbers[11]) {
                            seats[rowNumber][seatNumber] = numbers[11];
                            int ticketPrice = calculateTicketPrice(totalSeats, rows, rowNumber);
                            currentIncome += ticketPrice;
                            ticketsPurchased++;
                            System.out.println("\nTicket Price: $" + ticketPrice);
                            break;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    }
                }
                case 3 -> showStatistics(ticketsPurchased, totalSeats, currentIncome, totalIncome);
            }
        }
    }
    public static void showCinemaSeats(int rows, int rowSeats, char[][] seats, char[] numbers, int rowNumber, int seatNumber) {
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rowSeats; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void fillSeats(int rows, int rowSeats, char[][] seats, char[] numbers) {
        for (int i = 0; i <= rows; i++) {
            seats[i][0] = numbers[i];
            for (int j = 0; j <= rowSeats; j++) {
                seats[0][j] = numbers[j];
            }
        }
        for (int i = 1; i <= rows; i++) {
            seats[i][1] = numbers[10];
            for (int j = 1; j <= rowSeats; j++) {
                seats[i][j] = numbers[10];
            }
        }
    }
    public static int calculateTicketPrice(int totalSeats, int rows, int rowNumber) {
        int ticketPrice;
        int half = rows / 2;
        if (totalSeats > 60) {
            if (rowNumber <= half) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        } else {
            ticketPrice = 10;
        }
        return ticketPrice;
    }
    public static int calculateTotalIncome(int rows, int rowSeats, int totalSeats) {
        int totalIncome;
        int half = rows / 2;

        if (totalSeats > 60) {
            if (rows % 2 == 0) {
                totalIncome = (10 * (half * rowSeats)) + (8 * (half * rowSeats));
            } else {
                totalIncome = (10 * (half * rowSeats)) + (8 * ((half + 1) * rowSeats));
            }
        } else {
            totalIncome = 10 * totalSeats;
        }
        return totalIncome;
    }
    public static void showStatistics(int ticketsPurchased, int totalSeats, int currentIncome, int totalIncome) {
        double percentage = (ticketsPurchased / (double) totalSeats) * 100;
        System.out.println("\n number of purchased tickets: " + ticketsPurchased);
        System.out.printf("Percentage: %.2f%%", percentage);
        System.out.println("\nCurrent income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
