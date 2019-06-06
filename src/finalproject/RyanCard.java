package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class RyanCard extends Square
{
	private Image image;
	private DmCard back;

	public RyanCard()
	{
		this(0,0);
	}

	public RyanCard(int x, int y)
	{
		super(x, y);
		back = new DmCard(x, y);
		try
		{
			image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchGame\\src\\finalproject\\ryan.JPG"));

		}
		catch(Exception e)
		{
			System.out.println("RyanCard: error");
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
