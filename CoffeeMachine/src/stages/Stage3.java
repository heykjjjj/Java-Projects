package stages;

import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        final int waterSupply = readInteger(scanner);

        System.out.println("Write how many ml of milk the coffee machine has:");
        final int milkSupply = readInteger(scanner);

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        final int coffeeBeansSupply = readInteger(scanner);

        System.out.println("Write how many cups of coffee you will need:");
        final int numCups = readInteger(scanner);

        int cupsCounter = calculateCupsOfCoffee(waterSupply, milkSupply, coffeeBeansSupply);

        if (numCups == cupsCounter) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numCups < cupsCounter) {
            int value = cupsCounter - numCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + value + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsCounter + " cup(s) of coffee");
        }
    }
    public static int readInteger(Scanner scanner) {
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter a valid input.");
        }
        return number;
    }
    public static int calculateCupsOfCoffee(int waterSupply, int milkSupply, int coffeeBeansSupply) {
        int cupsCounter = 0;
        while (true) {
            if (waterSupply >= 200 && milkSupply >= 50 && coffeeBeansSupply >= 15) {
                waterSupply = waterSupply - 200;
                milkSupply = milkSupply - 50;
                coffeeBeansSupply = coffeeBeansSupply - 15;
                cupsCounter++;
            } else {
                break;
            }
        }
        return cupsCounter;
    }
}
