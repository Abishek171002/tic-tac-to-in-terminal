package tictactoe;

import java.util.Scanner;

class TicTacToe {
    char[] board; // The game board represented as a 1D array
    char currentWinner; // To track the current winner

    public TicTacToe() {
        // Initialize the game board with empty spaces
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        currentWinner = ' '; // No winner initially
    }

    // Print the current state of the game board
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j] + " | ");
            }
            System.out.println();
        }
    }

    // Print the board with numbers to show the move options
    public void printBoardNums() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(i * 3 + j + " | ");
            }
            System.out.println();
        }
    }

    // Get a list of available moves
    public int[] availableMoves() {
        return java.util.stream.IntStream.range(0, 9)
                .filter(i -> board[i] == ' ')
                .toArray();
    }

    // Check if there are any empty squares left
    public boolean emptySquares() {
        return new String(board).contains(" ");
    }

    // Get the number of empty squares
    public int numEmptySquares() {
        return (int) new String(board).chars().filter(ch -> ch == ' ').count();
    }

    // Attempt to make a move on the board
    public boolean makeMove(int square, char letter) {
        if (board[square] == ' ') {
            board[square] = letter;
            if (winner(square, letter)) {
                currentWinner = letter;
            }
            return true;
        }
        return false;
    }

    // Check if the move is a winning move
    public boolean winner(int square, char letter) {
        // Check row
        int rowInd = square / 3;
        if (board[rowInd * 3] == letter && board[rowInd * 3 + 1] == letter && board[rowInd * 3 + 2] == letter) {
            return true;
        }

        // Check column
        int colInd = square % 3;
        if (board[colInd] == letter && board[colInd + 3] == letter && board[colInd + 6] == letter) {
            return true;
        }

        // Check diagonals
        if (square % 2 == 0) {
            if (board[0] == letter && board[4] == letter && board[8] == letter) {
                return true;
            }
            if (board[2] == letter && board[4] == letter && board[6] == letter) {
                return true;
            }
        }

        return false;
    }

    // Get the current winner
    public char getCurrentWinner() {
        return currentWinner;
    }
}

public class Main {
    TicTacToe ttt; // TicTacToe game instance
    Scanner scanner; // Scanner for user input

    public Main() {
        ttt = new TicTacToe();
        scanner = new Scanner(System.in);
    }

    // Main game loop
    public void playGame() {
        ttt.printBoardNums(); // Print the board with numbers
        char letter = 'X'; // Starting letter

        while (ttt.emptySquares()) {
            // Check for tie
            if (ttt.numEmptySquares() == 0) {
                System.out.println("It's a tie!");
                return;
            }

            // Get the move from the current player
            int square = getMove(letter);
            // Make the move and check if it was valid
            if (ttt.makeMove(square, letter)) {
                System.out.println(letter + " makes a move to square " + square);
                ttt.printBoard();

                // Check for a winner
                if (ttt.getCurrentWinner() == letter) {
                    System.out.println(letter + " wins!");
                    return;
                }

                // Alternate turns
                letter = (letter == 'X') ? 'O' : 'X';
            }
        }

        // If no winner and no empty squares, it's a tie
        if (ttt.getCurrentWinner() == ' ') {
            System.out.println("It's a tie!");
        }
    }
 // Get a valid move from the user
    public int getMove(char letter) {
        int square = -1;

        while (true) {
            System.out.print(letter + "'s turn. Input move (0-8): ");
            try {
                square = Integer.parseInt(scanner.nextLine());
                final int finalSquare = square; // Declare finalSquare as effectively final

                if (java.util.Arrays.stream(ttt.availableMoves()).anyMatch(x -> x == finalSquare)) {
                    break; // Valid square found, exit the loop
                } else {
                    System.out.println("Invalid square. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        return square;
    }


    

    // Main method to start the game
    public static void main(String[] args) {
        Main game = new Main();
        game.playGame();
    }
}
