package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class PamCard extends Square
{
	private Image image;
	private DmCard back; 

	public PamCard()
	{
		this(0,0);
	}

	public PamCard(int x, int y)
	{
		super(x, y);
		back = new DmCard(x, y);
		try
		{
			image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchGame\\src\\finalproject\\pam.JPG"));

		}
		catch(Exception e)
		{
			System.out.println("PamCard: error");
		}
	}


	public void draw( Graphics window )
	{
		window.drawImage(image,getxPos(),getyPos(),130,130,null);
	}

	public void drawBack(Graphics window)
	{
		back.draw(window);
	}
	
	public String toString()
	{
		return super.toString();
	}
}
