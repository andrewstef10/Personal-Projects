package TicTacToe;

import student.TestableRandom;

public class GameBackEnd {

    private char whosTurn;
    private char[][] gameBoard;
    private char winner;
    private boolean gameOver = false;

    /**
     * Sets up the back end of Tic Tac Toe
     */
    public GameBackEnd() {
        // Randomizes if 'X' or 'O' goes first
        TestableRandom random = new TestableRandom();
        int whoTurn = random.nextInt(2);
        if (whoTurn == 0) {
            whosTurn = 'X';
        }
        else {
            whosTurn = 'O';
        }

        // instantiates the game board as a 2D array
        gameBoard = new char[3][3];

        // instantiates the winner as a dash as no one has won yet
        winner = '-';
    }


    /**
     * Gets the game board
     * 
     * @return Returns the game board as a 2D array of char
     */
    public char[][] getGameBoard() {
        return gameBoard;
    }


    /**
     * Gets who's turn it is
     * 
     * @return Returns who's turn it is as a char 'X' or 'O'
     */
    public char getWhosTurn() {
        return whosTurn;
    }


    /**
     * Gets the winner of the game
     * 
     * @return The winner of the game as a char.
     *         Either 'X' or 'O'
     */
    public char getWinner() {
        return winner;
    }


    /**
     * Getter method to determine if the game is over
     * 
     * @return True if the game is over aka someone has won
     */
    public boolean getGameOver() {
        return gameOver;
    }


    /**
     * Makes a move in the Tic Tac Toe game
     * 
     * @param row
     *            The row the player is placing their X or O
     * @param column
     *            The column the player is placing their X or O
     */
    public void move(int row, int column) {
        if (!gameOver) {
            gameBoard[row][column] = whosTurn;
            if (whosTurn == 'X') {
                whosTurn = 'O';
            }
            else {
                whosTurn = 'X';
            }
        }
        gameOver = checkForWin();
    }


    /**
     * Resets the game to its original state. Only
     * difference is that the winner of the previous
     * game will go first in the next game.
     */
    public void resetGame() {
        whosTurn = winner;
        gameBoard = new char[3][3];
        winner = '-';
        gameOver = false;
    }


    /**
     * Determines if there is a three in a row anywhere on the board
     * 
     * @return True if someone has won
     */
    private boolean checkForWin() {
        char[] threeInARow = new char[3];

        // checks left column
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[i][0];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks middle column
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[i][1];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks right column
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[i][2];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks top row
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[0][i];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks middle row
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[1][i];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks bottom row
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[2][i];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks left diagonal
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[i][i];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        // checks right diagonal
        for (int i = 0; i < threeInARow.length; i++) {
            threeInARow[i] = gameBoard[i][2 - i];
        }
        if (checkThreeInARow(threeInARow)) {
            return true;
        }

        return false;

    }


    /**
     * Checks that an array of three characters are all the same character
     * 
     * @param threeInARow
     *            The array of char's
     * @return True if all three char's are the same
     */
    private boolean checkThreeInARow(char[] threeInARow) {
        if (threeInARow[0] == 'X' && threeInARow[1] == 'X'
            && threeInARow[2] == 'X') {
            winner = 'X';
            return true;
        }
        if (threeInARow[0] == 'O' && threeInARow[1] == 'O'
            && threeInARow[2] == 'O') {
            winner = 'O';
            return true;
        }
        return false;
    }

}
