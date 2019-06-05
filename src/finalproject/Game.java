package finalproject;

import javax.swing.JFrame;
import java.awt.Component;

public class Game extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static MatchingGame game;

    public Game()
    {
        super("MATCHING GAME");
        setSize(WIDTH,HEIGHT);

        game = new MatchingGame();
        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}