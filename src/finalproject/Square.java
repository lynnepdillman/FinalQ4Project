package finalproject;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Square implements Locatable {

	private int xPos;
	private int yPos;

	public Square()
	{
		setxPos(0); 
		setyPos(0); 
	}

	public Square(int x, int y)
	{
		setxPos(x); 
		setyPos(y);
	}
	
	public void setPos(int x, int y)
	{
		xPos = x;
		yPos = y;
	}

	
	public abstract void draw(Graphics window);
	public abstract void drawBack(Graphics window);
	
	public String toString()
	{
		return "xPos = " + xPos + "; yPos = " + yPos;
	}
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}