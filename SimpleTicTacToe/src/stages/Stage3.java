package stages;

import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {
        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        int n = 0;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 2; j < board[i].length - 1; j+= 2) {
                board[i][j] = input.charAt(n);
                n++;
            }
        }

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

        printBoard(board);
        if (impossible) {
            System.out.println("Impossible");
        } else if (winX) {
            System.out.println("X wins");
        } else if (winO) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        } else if (gameNotFinished){
            System.out.println("Game not finished");
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
}
