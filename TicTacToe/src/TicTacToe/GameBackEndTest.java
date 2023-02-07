package TicTacToe;

import student.TestableRandom;

public class GameBackEndTest extends student.TestCase {

    // Fields..............................................
    private GameBackEnd game;

    // Methods ............................................
    public void setUp() {
        game = new GameBackEnd();

    }


    public void testMove() {
        assertEquals('X', game.getWhosTurn());
        game.move(0, 0);
        char[][] board = game.getGameBoard();
        assertEquals('X', board[0][0]);
        assertEquals('O', game.getWhosTurn());
        assertFalse(game.getGameOver());

        // X winning the game with the back slash diagonal
        game.move(0, 1);
        game.move(1, 1);
        game.move(0, 2);
        game.move(2, 2);

        assertTrue(game.getGameOver());
        assertEquals('X', game.getWinner());

        // Testing the reset game feature
        game.resetGame();
        assertEquals('X', game.getWhosTurn());
        assertEquals('-', game.getWinner());
        assertFalse(game.getGameOver());
    }

}
