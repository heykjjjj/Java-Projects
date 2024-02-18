package stages;

import java.util.Scanner;

public class Stage5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int cash = 550;
        showMainMenu(input, water, milk, coffeeBeans, cups, cash);
    }

    public static void showMainMenu(Scanner input, int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String choice = input.nextLine();
        switch (choice) {
            case "buy" -> buyCoffee(input, water, milk, coffeeBeans, cups, cash);
            case "fill" -> fillCoffee(input, water, milk, coffeeBeans, cups, cash);
            case "take" -> {
                System.out.println("\nI gave you $" + cash + "\n");
                cash = 0;
                showMainMenu(input, water, milk, coffeeBeans, cups, cash);
            }
            case "remaining" -> {
                remainingResources(water, milk, coffeeBeans, cups, cash);
                showMainMenu(input, water, milk, coffeeBeans, cups, cash);
            }
            case "exit" -> {
                return;
            }
            default -> System.out.println("Invalid input. Please enter either 'buy', 'fill', 'take', 'remaining', or 'exit'.\n");
        }
    }

    public static void buyCoffee(Scanner input, int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        boolean isBuyCoffeeOpen = false;
        while (!isBuyCoffeeOpen) {
            String coffeeChoice = input.nextLine();
            switch (coffeeChoice) {
                case "1" -> {
                    if (water >= 250 && coffeeBeans >= 16) {
                        water -= 250;
                        coffeeBeans -= 16;
                        cups--;
                        cash += 4;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else if (water < 250) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (coffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    } else {
                        System.out.println("Sorry, not enough resources!\n");
                    }
                    isBuyCoffeeOpen = true;
                }
                case "2" -> {
                    if (water >= 350 && milk >= 75 && coffeeBeans >= 20) {
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        cups--;
                        cash += 7;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else if (water < 350) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk!\n");
                    } else if (coffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    } else {
                        System.out.println("Sorry, not enough resources!\n");
                    }
                    isBuyCoffeeOpen = true;
                }
                case "3" -> {
                    if (water >= 200 && milk >= 100 && coffeeBeans >= 12) {
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        cups--;
                        cash += 6;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else if (water < 200) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk!\n");
                    } else if (coffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    } else {
                        System.out.println("Sorry, not enough resources!\n");
                    }
                    isBuyCoffeeOpen = true;
                }
                case "back" -> isBuyCoffeeOpen = true;
                default -> System.out.println("Invalid input. Please enter either (1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu).");
            }
            showMainMenu(input, water, milk, coffeeBeans, cups, cash);
        }
    }

    public static void fillCoffee(Scanner input, int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.println("\nWrite how many ml of water you want to add: ");
        String addWater = input.nextLine();
        water += Integer.parseInt(addWater);

        System.out.println("Write how many ml of milk you want to add:");
        String addMilk = input.nextLine();
        milk += Integer.parseInt(addMilk);

        System.out.println("Write how many grams of coffee beans you want to add:");
        String addCoffeeBeans = input.nextLine();
        coffeeBeans += Integer.parseInt(addCoffeeBeans);

        System.out.println("Write how many disposable cups you want to add: ");
        String addCups = input.nextLine();
        cups += Integer.parseInt(addCups);

        System.out.println();
        showMainMenu(input, water, milk, coffeeBeans, cups, cash);
    }

    public static void remainingResources(int water, int milk, int coffeeBeans, int cups, int cash) {
        System.out.printf("""
                                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                                
                """, water, milk, coffeeBeans, cups, cash);
    }
}
