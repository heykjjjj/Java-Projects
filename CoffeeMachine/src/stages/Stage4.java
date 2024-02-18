package stages;

import java.util.Scanner;

public class Stage4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int cash = 550;

        printCoffeeMachine(water, milk, coffeeBeans, cups, cash);
        getAction(scanner, water, milk, coffeeBeans, cups, cash);
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
    public static void printCoffeeMachine(int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money""", water, milk, coffeeBeans, cups, cash);
    }
    public static void getAction(Scanner scanner, int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.println("\n\nWrite action (buy, fill, take):");
        boolean isActionOpen = false;

        while (!isActionOpen) {
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    boolean isCoffeeOpen = false;
                    while (!isCoffeeOpen) {
                        int coffeeChoice = readInteger(scanner);
                        switch (coffeeChoice) {
                            case 1 -> {
                                water -= 250;
                                coffeeBeans -= 16;
                                cups -= 1;
                                cash += 4;
                                isCoffeeOpen = true;
                            }
                            case 2 -> {
                                water = water - 350;
                                milk = milk - 75;
                                coffeeBeans = coffeeBeans - 20;
                                cups = cups - 1;
                                cash = cash + 7;
                                isCoffeeOpen = true;
                            }
                            case 3 -> {
                                water = water - 200;
                                milk = milk - 100;
                                coffeeBeans = coffeeBeans - 12;
                                cups = cups - 1;
                                cash = cash + 6;
                                isCoffeeOpen = true;
                            }
                            default -> System.out.println("Invalid input. Please choose between '1', '2', or '3'.");
                        }
                    }
                    isActionOpen = true;
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add: ");
                    int addWater = readInteger(scanner);
                    System.out.println("Write how many ml of milk you want to add:");
                    int addMilk = readInteger(scanner);
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int addCoffeeBeans = readInteger(scanner);
                    System.out.println("Write how many disposable cups you want to add: ");
                    int addCups = readInteger(scanner);
                    System.out.println();
                    water += addWater;
                    milk += addMilk;
                    coffeeBeans += addCoffeeBeans;
                    cups += addCups;
                    isActionOpen = true;
                }
                case "take" -> {
                    System.out.println("I gave you $ " + cash + "\n");
                    cash -= cash;
                    isActionOpen = true;
                }
                default -> System.out.println("Invalid input. Please enter either 'buy', 'fill', or 'take'.");
            }
        }
        printCoffeeMachine(water, milk, coffeeBeans, cups, cash);
    }
}
