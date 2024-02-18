package stages;

import java.util.Scanner;

public class Stage5 {
    public static void main(String[] args) {
        char[] symbols = {'X', 'O', '_', ' '};
        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}};

        boolean gameNotFinished = false;
        int counter = 0;

        while (!gameNotFinished) {
            printBoard(board);
            placeMove(board, symbols, counter);
            counter++;

            boolean winX = board[1][2] == symbols[0] && board[1][2] == board[1][4] && board[1][4] == board[1][6]
                    || board[2][2] == symbols[0] && board[2][2] == board[2][4] && board[2][4] == board[2][6]
                    || board[3][2] == symbols[0] && board[3][2] == board[3][4] && board[3][4] == board[3][6]

                    || board[1][2] == symbols[0] && board[1][2] == board[2][2] && board[2][2] == board[3][2]
                    || board[1][4] == symbols[0] && board[1][4] == board[2][4] && board[2][4] == board[3][4]
                    || board[1][6] == symbols[0] && board[1][6] == board[2][6] && board[2][6] == board[3][6]

                    || board[1][2] == symbols[0] && board[1][2] == board[2][4] && board[2][4] == board[3][6]
                    || board[1][6] == symbols[0] && board[1][6] == board[2][4] && board[2][4] == board[3][2];

            boolean winO = board[1][2] == symbols[1] && board[1][2] == board[1][4] && board[1][4] == board[1][6]
                    || board[2][2] == symbols[1] && board[2][2] == board[2][4] && board[2][4] == board[2][6]
                    || board[3][2] == symbols[1] && board[3][2] == board[3][4] && board[3][4] == board[3][6]

                    || board[1][2] == symbols[1] && board[1][2] == board[2][2] && board[2][2] == board[3][2]
                    || board[1][4] == symbols[1] && board[1][4] == board[2][4] && board[2][4] == board[3][4]
                    || board[1][6] == symbols[1] && board[1][6] == board[2][6] && board[2][6] == board[3][6]

                    || board[1][2] == symbols[1] && board[1][2] == board[2][4] && board[2][4] == board[3][6]
                    || board[1][6] == symbols[1] && board[1][6] == board[2][4] && board[2][4] == board[3][2];

            int emptySpaces = 0;
            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 2; j < board[i].length - 1; j+= 2) {
                    if (board[i][j] == '_' || board[i][j] == ' ') {
                        emptySpaces++;
                    }
                }
            }
            boolean draw = (!winX && !winO) && emptySpaces == 0;

            if (winX) {
                printBoard(board);
                System.out.println("X wins");
                gameNotFinished = true;
            } else if (winO) {
                printBoard(board);
                System.out.println("O wins");
                gameNotFinished = true;
            } else if (draw) {
                printBoard(board);
                System.out.println("Draw");
                gameNotFinished = true;
            }
        }
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    public static void placeMove(char[][] board, char[] symbols, int counter) {
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
                        if (counter % 2 == 0) {
                            board[1][2] = symbols[0];
                        } else {
                            board[1][2] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[1][4] == symbols[2] || board[1][4] == symbols[3]) && topRow2) {
                        if (counter % 2 == 0) {
                            board[1][4] = symbols[0];
                        } else {
                            board[1][4] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[1][6] == symbols[2] || board[1][6] == symbols[3]) && topRow3) {
                        if (counter % 2 == 0) {
                            board[1][6] = symbols[0];
                        } else {
                            board[1][6] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[2][2] == symbols[2] || board[2][2] == symbols[3]) && midRow1) {
                        if (counter % 2 == 0) {
                            board[2][2] = symbols[0];
                        } else {
                            board[2][2] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[2][4] == symbols[2] || board[2][4] == symbols[3]) && midRow2) {
                        if (counter % 2 == 0) {
                            board[2][4] = symbols[0];
                        } else {
                            board[2][4] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[2][6] == symbols[2] || board[2][6] == symbols[3]) && midRow3) {
                        if (counter % 2 == 0) {
                            board[2][6] = symbols[0];
                        } else {
                            board[2][6] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[3][2] == symbols[2] || board[3][2] == symbols[3]) && botRow1) {
                        if (counter % 2 == 0) {
                            board[3][2] = symbols[0];
                        } else {
                            board[3][2] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[3][4] == symbols[2] || board[3][4] == symbols[3]) && botRow2) {
                        if (counter % 2 == 0) {
                            board[3][4] = symbols[0];
                        } else {
                            board[3][4] = symbols[1];
                        }
                        isValidInput = true;
                    } else if ((board[3][6] == symbols[2] || board[3][6] == symbols[3]) && botRow3) {
                        if (counter % 2 == 0) {
                            board[3][6] = symbols[0];
                        } else {
                            board[3][6] = symbols[1];
                        }
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
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }
}
