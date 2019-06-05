package finalproject;

import static java.lang.Character.toUpperCase;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class MatchingGame extends Canvas implements KeyListener, Runnable
{
    private DmCards pinks = new DmCards(200, 150);
    private DmCard[][] pinkmat; 
    public boolean initialized = false; 
    public boolean title = true; 
    public boolean match = false; 
    public boolean notMatch = false; 
    public boolean isCardFlipped = false; 
    public boolean gameStart = false;
    public int pairsleft = 8; 
    private int score;
    private LeaderBoard leaderBoard;
    private boolean[] keys;
    private BufferedImage back;

    public MatchingGame()
    {
        keys = new boolean[3];
        pinkmat = pinks.pMatrix(); 

        setBackground(Color.white);
        setVisible(true);
        
        this.addKeyListener(this);
	new Thread(this).start();
    }

    public void update(Graphics window)
    {
        paint(window);
    }
    
    public void paint(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null)
        {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();
        
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(350, 0, 200, 150);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("LEADERBOARD", 375, 10);
        graphToBack.drawString("CURRENT SCORE: " + score, 375, 50);
        graphToBack.drawString("HIGH SCORE: " + leaderBoard.get(), 375, 100);
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0, 450, 800, 200);
        
//        if(keys[0] == true && !initialized){
//			initialized = true;
			graphToBack.clearRect(0, 0, 800, 800);
			
			for (int i = 0; i < pinkmat.length; i++) {
				for (int j = 0; j < pinkmat[i].length; j++) {
					pinkmat[i][j].draw(graphToBack);
				}
			}
			
			graphToBack.drawString("Press F key to flip two cards", 25, 50 );
//        }
                
        if(keys[3] && !isCardFlipped){
			gameStart = true;
			isCardFlipped = true;
			ArrayList<Square> twoFlipCard = pinks.rand();
			twoFlipCard.get(0).draw(graphToBack);
			twoFlipCard.get(1).draw(graphToBack);
		}
            
            if(keys[1] && isCardFlipped){
			isCardFlipped = false;
			if(!pinks.getTwoFlipCardsPair().get(0).getClass().equals(pinks.getTwoFlipCardsPair().get(1).getClass()))
			{
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(0, 0, 1300, 1300);
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("YOU INCORRECTLY ANSWERED! THERE WAS NOT A MATCH!", 400, 300);
				return;
			}
			else
			{
				match = true;
				int xPos1 = pinks.getTwoFlipCardsPair().get(0).getxPos();
				int yPos1 = pinks.getTwoFlipCardsPair().get(0).getyPos();
				graphToBack.clearRect(xPos1, yPos1, 150, 150);
				
				int xPos2 = pinks.getTwoFlipCardsPair().get(1).getxPos();
				int yPos2 = pinks.getTwoFlipCardsPair().get(1).getyPos();
				graphToBack.clearRect(xPos2, yPos2, 150, 150);
				
				pairsleft = pairsleft - 1; 
				pinks.addMatch();
				
				graphToBack.clearRect(0, 0, 800, 50);
				graphToBack.drawString("Press F key to flip another two cards", 25, 50);
				
			}
			
		}
            
            if(keys[2] && isCardFlipped){
			isCardFlipped = false;
			if(pinks.getTwoFlipCardsPair().get(0).getClass().equals(pinks.getTwoFlipCardsPair().get(1).getClass()))
			{
//				System.out.println("But they are matching cards");
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(0, 0, 1300, 1300);
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("YOU INCORRECTLY ANSWERED. THERE WAS A MATCH!", 400, 300);
				return;
			}
			else
			{
				match = false;
				pinks.getTwoFlipCardsPair().get(0).drawBack(graphToBack);
				pinks.getTwoFlipCardsPair().get(1).drawBack(graphToBack);
				
				graphToBack.clearRect(0, 0, 800, 100);
				graphToBack.drawString("Press F key to flip another two cards", 25, 50);
				
				
			}
		}
		
		if (pairsleft == 0) {
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(0, 0, 1300, 1300);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("YOU WIN!", 400, 300);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
    }


    public void keyPressed(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case 'Y' : keys[1]=true; break;
            case 'N' : keys[2]=true; break;
            case 'F' : keys[3]=true; break;
        }
    repaint();
    }

    public void keyReleased(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case 'Y' : keys[1]=false; break;
            case 'N' : keys[2]=false; break;
            case 'F' : keys[3]=false; break; 
	}
        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
        
    }

    public void run()
    {
        try{
            while (true) {
                Thread.currentThread().sleep(5);
//                repaint();
            }
        } catch (Exception e) {
        }
    }
}
