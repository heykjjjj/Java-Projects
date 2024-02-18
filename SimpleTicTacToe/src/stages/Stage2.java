package stages;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        char[] choices = {input.charAt(0), input.charAt(1), input.charAt(2),
                input.charAt(3), input.charAt(4), input.charAt(5), input.charAt(6), input.charAt(7),
                input.charAt(input.length() - 1)};

        String result = String.format("""
                ---------
                | %c %c %c |
                | %c %c %c |
                | %c %c %c |
                ---------
                """, choices[0], choices[1], choices[2], choices[3], choices[4], choices[5], choices[6], choices[7], choices[choices.length - 1]);

        if (input.contains("X") || input.contains("O") || input.contains("_")) {
            System.out.println(result);
        } else {
            System.out.println("Please check your input");
        }
    }
}
