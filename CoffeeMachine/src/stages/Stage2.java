package stages;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = scanner.nextInt();

        System.out.println("For " + numCups + " cups of coffee you will need:");
        System.out.println(getWater(numCups) + " ml of water");
        System.out.println(getMilk(numCups) + " ml of milk");
        System.out.println(getCoffeeBeans(numCups) + " g of coffee beans");
    }
    public static int getWater(int numCups) {
        return numCups * 200;
    }
    public static int getMilk(int numCups) {
        return numCups * 50;
    }
    public static int getCoffeeBeans(int numCups) {
        return numCups * 15;
    }
}
