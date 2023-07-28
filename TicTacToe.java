import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void playGame() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            makeMove();
            printBoard();
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                switchPlayer();
            }
        }
    }

    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.print("Enter the row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Enter the column (0-2): ");
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move. Row and column must be between 0 and 2.");
            return false;
        }

        if (board[row][col] != '-') {
            System.out.println("Invalid move. That position is already occupied.");
            return false;
        }

        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        System.out.println("Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

