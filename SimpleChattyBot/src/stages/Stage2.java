package stages;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! My name is Kj Bot.");
        System.out.println("I was created in 2023.");
        System.out.println("Please, remind me your name.");
        String name = scanner.next();
        System.out.println("What a great name you have " + name + "!");
    }
}
