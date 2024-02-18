package stages;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int rowSeats = scanner.nextInt();

        int totalSeats = rows * rowSeats;
        int ticketPrice = 10;
        int backRowPrice = 8;
        int totalPrice;
        int half;

        if (totalSeats < 60) {
            totalPrice = ticketPrice * totalSeats;
        } else {
            half = rows / 2;
            if (rows % 2 == 0) {
                totalPrice = (ticketPrice * (half * rowSeats)) + (backRowPrice * (half * rowSeats));
            } else {
                totalPrice = (ticketPrice * (half * rowSeats)) + (backRowPrice * ((half + 1) * rowSeats));
            }
        }
        System.out.println("Total income:\n" + "$" + totalPrice);
    }
}
