import java.util.Scanner;
public class Main {
    static char[][] board = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;
        // Initialize board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        System.out.println("===== TIC TAC TOE GAME =====");
        while (!gameOver) {
            printBoard();
             System.out.println("Player " + currentPlayer + 
                               " enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                if (checkWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " Wins!");
                    gameOver = true;
                } 
                else if (isBoardFull()) {
                    printBoard();
                    System.out.println("🤝 Game Draw!");
                    gameOver = true;
                } 
                else {
                    // Switch player
                    if (currentPlayer == 'X')
                        currentPlayer = 'O';
                    else
                        currentPlayer = 'X';
                }
            } 
            else {
                System.out.println("❌ Invalid move, try again.");
            }
        }
        sc.close();
    }
    // Print the board
    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("--+---+--");
        }
        System.out.println();
    }
    // Check if move is valid
    static boolean isValidMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == ' ')
                return true;
        }
        return false;
    }
     // Check winner
    static boolean checkWinner(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player)
                return true;
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player)
                return true;
        }
    // Check diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player)
            return true;
         if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player)
            return true;

        return false;
    }
    // Check if board is full
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
