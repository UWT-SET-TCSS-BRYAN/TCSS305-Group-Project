package edu.uw.tcss.app;

import edu.uw.tcss.model.TetrisGame;

// TODO add a class Javadoc comment here, including @author and @version tags.
public class Sandbox {

    public static void main(final String[] args) {
        TetrisGame game = new TetrisGame();
        game.newGame();
        System.out.println(game);

        game.step();
        System.out.println(game);
        game.step();
        System.out.println(game);
        game.step();
        System.out.println(game);
        game.rotateCW();
        System.out.println(game);
        game.rotateCW();
        System.out.println(game);
        game.rotateCW();
        System.out.println(game);
        game.rotateCW();
        System.out.println(game);
        game.drop();
        System.out.println(game);

    }

}
