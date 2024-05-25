 Project Description: Tic Tac Toe Game with java

 Overview:
This project is a simple implementation of the classic Tic Tac Toe game using Java. It features both a commandline version and a graphical user interface (GUI) version. The GUI version is implemented using Swing, allowing players to interact with the game in a separate window.

 Components:
1. TicTacToe Class:
    Represents the game logic.
    Handles the game board, checks for available moves, makes moves, and determines the winner.
    Methods:
      printBoard(): Prints the current game board.
      printBoardNums(): Prints the board with numbered positions for reference.
      availableMoves(): Returns a list of available moves.
      emptySquares(): Checks if there are any empty squares left.
      numEmptySquares(): Returns the number of empty squares.
      makeMove(int square, char letter): Makes a move on the board.
      winner(int square, char letter): Checks if the move results in a win.
      getCurrentWinner(): Returns the current winner.

2. Main Class:
    Contains the main game loop for the commandline version.
    Handles user input and alternates turns between 'X' and 'O'.
    Methods:
      playGame(): Main game loop for playing the game.
      getMove(char letter): Gets a valid move from the user.
    Entry point of the application with the main method.

3. TicTacToeGUI Class:
    Extends JFrame to create a window for the game.
    Contains buttons representing the game board squares.
    Methods:
      initializeUI(): Sets up the GUI components.
      computerMove(): Handles the computer's move.
      resetBoard(): Resets the board after the game is over.
    Integrates with the TicTacToe class to manage game logic.

 How It Works:
1. CommandLine Version:
    The user plays against themselves in the console.
    The game prompts the user to enter a move, validates the move, updates the board, and checks for a winner or a tie.

2. GUI Version:
    A window is displayed with a 3x3 grid of buttons.
    The user clicks on a button to make a move.
    The game updates the board, checks for a winner or a tie, and allows the user to reset the game when it's over.

 Running the Project:
1. CommandLine Version:
    Run the Main class.
    Follow the prompts in the console to play the game.

2. GUI Version:
    Run the Main class.
    A window will appear where you can play the game by clicking the buttons.

This project serves as a basic example of how to implement a simple game in Java, demonstrating both consolebased interaction and GUIbased interaction using Swing.
