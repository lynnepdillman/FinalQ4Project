package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class DwightCard extends Square
{
	private Image image;
	private DmCard back;

	public DwightCard()
	{
		this(0,0);
	}

	public DwightCard(int x, int y)
	{
		super(x, y);
		back = new DmCard(x, y);
		try
		{
			image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchGame\\src\\finalproject\\dwight.jpg"));

		}
		catch(Exception e)
		{
			System.out.println("DwightCard: we have a problem!");
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
