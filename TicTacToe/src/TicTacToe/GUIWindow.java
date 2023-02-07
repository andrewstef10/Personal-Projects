package TicTacToe;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class GUIWindow {
    private Window window;
    private Button quit;
    private Button reset;
    private Button[] boardButtons;
    private static final int SIZE_FACTOR = 3;
    private GameBackEnd game;
    private TextShape whosTurnText;

    public GUIWindow(GameBackEnd game) {
        this.game = game;

        // window setup
        window = new Window();
        window.setSize(window.getGraphPanelWidth() * SIZE_FACTOR, window
            .getGraphPanelHeight() * SIZE_FACTOR);
        window.setTitle("Tic Tac Toe");
        quit = new Button();
        quit.setTitle("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);

        reset = new Button();
        reset.setTitle("Reset Game");
        reset.onClick(this, "clickedReset");
        window.addButton(reset, WindowSide.SOUTH);

        // board setup
        int windowWidth = window.getGraphPanelWidth();
        int windowHeight = window.getGraphPanelHeight();

        Shape verticalBarL = new Shape(((windowWidth / 2) - (30 * SIZE_FACTOR)),
            (windowHeight / 7), 2, 200 * SIZE_FACTOR, Color.BLACK);
        Shape verticalBarR = new Shape(((windowWidth / 2) + (30 * SIZE_FACTOR)),
            (windowHeight / 7), 2, 200 * SIZE_FACTOR, Color.BLACK);
        Shape horizontalBarT = new Shape(windowWidth / 3, (windowHeight / 2)
            - (30 * SIZE_FACTOR), 200 * SIZE_FACTOR, 2, Color.BLACK);
        Shape horizontalBarB = new Shape(windowWidth / 3, (windowHeight / 2)
            + (30 * SIZE_FACTOR), 200 * SIZE_FACTOR, 2, Color.BLACK);
        window.addShape(verticalBarL);
        window.addShape(verticalBarR);
        window.addShape(horizontalBarT);
        window.addShape(horizontalBarB);

        // displays who's turn it is in the top right
        whosTurnText = new TextShape(1, 1, Character.toString(game
            .getWhosTurn()), Color.black, 40 * SIZE_FACTOR);
        window.addShape(whosTurnText);

        // button setup
        boardButtons = new Button[9];
        for (int i = 0; i < boardButtons.length; i++) {
            boardButtons[i] = new Button();
            boardButtons[i].setTitle(String.valueOf(i + 1));
            boardButtons[i].onClick(this, "move" + String.valueOf(i + 1));
            window.addButton(boardButtons[i], WindowSide.NORTH);
        }

    }


    /**
     * Closes out of the window
     * 
     * @param button
     *            The quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Resets the game
     * 
     * @param button
     *            The reset button
     */
    public void clickedReset(Button button) {
        game.resetGame();
        GUIWindow newWindow = new GUIWindow(game);
    }


    /**
     * adds and X or O to the board depending
     * on who's turn it is
     * 
     * @param button
     *            The button indicating the location
     *            of the X or O
     */
    public void move1(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(0, 0);

        displaySymbol(1, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move2(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(0, 1);

        displaySymbol(2, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move3(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(0, 2);

        displaySymbol(3, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move4(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(1, 0);

        displaySymbol(4, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move5(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(1, 1);

        displaySymbol(5, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move6(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(1, 2);

        displaySymbol(6, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move7(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(2, 0);

        displaySymbol(7, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move8(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(2, 1);

        displaySymbol(8, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    public void move9(Button button) {
        char currentTurn = game.getWhosTurn();
        game.move(2, 2);

        displaySymbol(9, currentTurn);
        displayWhosTurn(game.getWhosTurn());

        if (game.getGameOver()) {
            displayWinner(game.getWinner());
        }
    }


    /**
     * Displays the the symbol of who's turn it is in the specified location
     * 
     * @param location
     *            The location on the 3x3 grid
     * @param symbol
     *            Either 'X' or 'O'
     */
    private void displaySymbol(int location, char symbol) {
        TextShape text = new TextShape(1, 1, Character.toString(symbol),
            Color.black, 40 * SIZE_FACTOR);

        // setting x location
        if (location == 1 || location == 4 || location == 7) {
            text.setX(((window.getGraphPanelWidth() / 2) - (text.getWidth()
                / 2)) - (60 * SIZE_FACTOR));
        }
        if (location == 2 || location == 5 || location == 8) {
            text.setX((window.getGraphPanelWidth() / 2) - (text.getWidth()
                / 2));
        }
        if (location == 3 || location == 6 || location == 9) {
            text.setX(((window.getGraphPanelWidth() / 2) - (text.getWidth()
                / 2)) + (60 * SIZE_FACTOR));
        }

        // setting y location
        if (location == 1 || location == 2 || location == 3) {
            text.setY(((window.getGraphPanelHeight() / 2) - (text.getHeight()
                / 2)) - (60 * SIZE_FACTOR));
        }
        if (location == 4 || location == 5 || location == 6) {
            text.setY((window.getGraphPanelHeight() / 2) - (text.getHeight()
                / 2));
        }
        if (location == 7 || location == 8 || location == 9) {
            text.setY(((window.getGraphPanelHeight() / 2) - (text.getHeight()
                / 2)) + (60 * SIZE_FACTOR));
        }

        window.addShape(text);
    }


    /**
     * Displays the winner of the game
     * 
     * @param winner
     *            The winner of the game. Either 'X' or 'O'
     */
    private void displayWinner(char winner) {
        TextShape text = new TextShape((window.getGraphPanelWidth() / 2) - ((388
            * SIZE_FACTOR) / 2), window.getGraphPanelHeight() / 8, "WINNER",
            Color.black, (80 * SIZE_FACTOR));
        window.addShape(text);
        if (winner == 'X') {
            TextShape x = new TextShape(1, 1, "X", Color.black, 80
                * SIZE_FACTOR);
            x.setX((window.getGraphPanelWidth() / 2) - (x.getWidth() / 2));
            x.setY(window.getGraphPanelHeight() / 2);
            window.addShape(x);
        }
        else {
            TextShape o = new TextShape(1, 1, "O", Color.black, 80
                * SIZE_FACTOR);
            o.setX((window.getGraphPanelWidth() / 2) - (o.getWidth() / 2));
            o.setY(window.getGraphPanelHeight() / 2);
            window.addShape(o);
        }
    }


    /**
     * Displays which players turn it is on the screen
     * 
     * @param whosTurn
     */
    private void displayWhosTurn(char whosTurn) {
        whosTurnText.setText(Character.toString(whosTurn));
    }

}
