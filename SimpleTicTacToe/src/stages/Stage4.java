package stages;

import java.util.Scanner;

public class Stage4 {
    public static void main(String[] args) {
        char[] symbols = {'X', 'O', '_', ' '};
        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        inputMove(board);
        printBoard(board);
        placeMove(board, symbols);
        printBoard(board);

        /*
        boolean winX = board[1][2] == 'X' && board[1][2] == board[1][4] && board[1][4] == board[1][6]
                || board[2][2] == 'X' && board[2][2] == board[2][4] && board[2][4] == board[2][6]
                || board[3][2] == 'X' && board[3][2] == board[3][4] && board[3][4] == board[3][6]

                || board[1][2] == 'X' && board[1][2] == board[2][2] && board[2][2] == board[3][2]
                || board[1][4] == 'X' && board[1][4] == board[2][4] && board[2][4] == board[3][4]
                || board[1][6] == 'X' && board[1][6] == board[2][6] && board[2][6] == board[3][6]

                || board[1][2] == 'X' && board[1][2] == board[2][4] && board[2][4] == board[3][6]
                || board[1][6] == 'X' && board[1][6] == board[2][4] && board[2][4] == board[3][2];

        boolean winO = board[1][2] == 'O' && board[1][2] == board[1][4] && board[1][4] == board[1][6]
                || board[2][2] == 'O' && board[2][2] == board[2][4] && board[2][4] == board[2][6]
                || board[3][2] == 'O' && board[3][2] == board[3][4] && board[3][4] == board[3][6]

                || board[1][2] == 'O' && board[1][2] == board[2][2] && board[2][2] == board[3][2]
                || board[1][4] == 'O' && board[1][4] == board[2][4] && board[2][4] == board[3][4]
                || board[1][6] == 'O' && board[1][6] == board[2][6] && board[2][6] == board[3][6]

                || board[1][2] == 'O' && board[1][2] == board[2][4] && board[2][4] == board[3][6]
                || board[1][6] == 'O' && board[1][6] == board[2][4] && board[2][4] == board[3][2];

        int counterX = 0;
        int counterO = 0;
        int emptySpaces = 0;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 2; j < board[i].length - 1; j+= 2) {
                n++;
                if (board[i][j] == 'X') {
                    counterX++;
                } else if (board[i][j] == 'O') {
                    counterO++;
                } else if (board[i][j] == '_' || board[i][j] == ' ') {
                    emptySpaces++;
                }
            }
        }
        boolean gameNotFinished = (!winX && !winO) && emptySpaces <= 9;
        boolean draw = !winX && !winO && emptySpaces == 0;

        boolean counter = counterX - counterO == 2 || counterO - counterX == 2;
        boolean impossible = (winX && winO) || counter;

        if (impossible) {
            printBoard(board);
            System.out.println("Impossible");
        } else if (winX) {
            printBoard(board);
            System.out.println("X wins");
        } else if (winO) {
            printBoard(board);
            System.out.println("O wins");
        } else if (draw) {
            printBoard(board);
            System.out.println("Draw");
        } else if (gameNotFinished){
            printBoard(board);
            System.out.println("Game not finished");
        } else {
            System.out.println("Input Error");
        }
        */
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void inputMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine().toUpperCase();
        int n = 0;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 2; j < board[i].length - 1; j+= 2) {
                board[i][j] = move.charAt(n);
                n++;
            }
        }
    }
    public static void placeMove(char[][] board, char[] symbols) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if ((x < 4 && y < 4) && (x > 0 && y > 0)) {
                    boolean topRow1 = x == 1 && y == 1;
                    boolean topRow2 = x == 1 && y == 2;
                    boolean topRow3 = x == 1 && y == 3;

                    boolean midRow1 = x == 2 && y == 1;
                    boolean midRow2 = x == 2 && y == 2;
                    boolean midRow3 = x == 2 && y == 3;

                    boolean botRow1 = x == 3 && y == 1;
                    boolean botRow2 = x == 3 && y == 2;
                    boolean botRow3 = x == 3 && y == 3;

                    if ((board[1][2] == symbols[2] || board[1][2] == symbols[3]) && topRow1) {
                        board[1][2] = symbols[0];
                        isValidInput = true;
                    } else if ((board[1][4] == symbols[2] || board[1][4] == symbols[3]) && topRow2) {
                        board[1][4] = symbols[0];
                        isValidInput = true;
                    } else if ((board[1][6] == symbols[2] || board[1][6] == symbols[3]) && topRow3) {
                        board[1][6] = symbols[0];
                        isValidInput = true;
                    } else if ((board[2][2] == symbols[2] || board[2][2] == symbols[3]) && midRow1) {
                        board[2][2] = symbols[0];
                        isValidInput = true;
                    } else if ((board[2][4] == symbols[2] || board[2][4] == symbols[3]) && midRow2) {
                        board[2][4] = symbols[0];
                        isValidInput = true;
                    } else if ((board[2][6] == symbols[2] || board[2][6] == symbols[3]) && midRow3) {
                        board[2][6] = symbols[0];
                        isValidInput = true;
                    } else if ((board[3][2] == symbols[2] || board[3][2] == symbols[3]) && botRow1) {
                        board[3][2] = symbols[0];
                        isValidInput = true;
                    } else if ((board[3][4] == symbols[2] || board[3][4] == symbols[3]) && botRow2) {
                        board[3][4] = symbols[0];
                        isValidInput = true;
                    } else if ((board[3][6] == symbols[2] || board[3][6] == symbols[3]) && botRow3) {
                        board[3][6] = symbols[0];
                        isValidInput = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }
}
