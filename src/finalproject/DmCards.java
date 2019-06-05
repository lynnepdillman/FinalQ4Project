package finalproject;

import java.util.ArrayList;
import java.util.Random;

public class DmCards extends DmCard {

	private DmCard[][] p; 
	private ArrayList<Square> cardSet = new ArrayList<Square>();
	private ArrayList<Square> twoFlipCardsPair = new ArrayList<Square>();
	private ArrayList<Integer> cardIndex = new ArrayList<Integer>();
	private ArrayList<Integer> matchedCards = new ArrayList<Integer>();
	private Random randomGenerator = new Random();
	private int r1, r2;		
	
	public DmCards() {
	}
	
	public DmCards(int x, int y) {
		
		cardSet.add(new MichaelCard(200, 150));
		cardSet.add(new JimCard(400, 150));
		cardSet.add(new PamCard(600, 150));
		cardSet.add(new DwightCard(800, 150));
		cardSet.add(new AngelaCard(200, 300));
		cardSet.add(new RyanCard(400, 300));
		cardSet.add(new KellyCard(600, 300));
		cardSet.add(new AngelaCard(800, 300));
		cardSet.add(new PamCard(200, 450)); 
		cardSet.add(new AndyCard(400, 450));
		cardSet.add(new JimCard(600, 450));
		cardSet.add(new KellyCard(800, 450));
		cardSet.add(new DwightCard(200, 600));
		cardSet.add(new MichaelCard(400, 600));
		cardSet.add(new AndyCard(600, 600));
		cardSet.add(new RyanCard(800, 600));
		
		for (int i= 0; i <=15; i++)
		{
			cardIndex.add(i);
		}
		
		p = new DmCard[4][4];
//		System.out.println("PinkCards: xPos = " + x + ", yPos = " + y + ", p.length = " + p.length);
		
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				p[i][j] = new DmCard(x, y);
				x = x + 200;
			}
			x = 200; 
			y = y + 150; 
		}
	}
	
	public DmCard[][] pMatrix() { 
		return p;
	}
	
	public ArrayList<Square> rand() {
		boolean isR1Good = true, isR2Good = true;
		int increment1 = 0; 
		int increment2 = 0; 

		do 
		{
			r1 = randomGenerator.nextInt(16);
//			System.out.println("this is r1 " + r1);
			isR1Good = true; 
			if (matchedCards.size() > 0) {
				increment1 = 0; 
				do {
					if (r1 == matchedCards.get(increment1)) {
//						System.out.println("this is r1 when matched " + r1);
						isR1Good = false; 
					}
					increment1++; 
				} while (isR1Good == true && increment1 < matchedCards.size());
			}
		} 
		while(!isR1Good);

//		System.out.println("r1 good before r2");
		
		do 
		{
			r2 = randomGenerator.nextInt(16);
//			System.out.println("this is r2 " + r2);
			isR2Good = true; 
			if (r1 != r2) { 
				if (matchedCards.size() > 0) {
					increment2 = 0; 
					do {
						if ((r2 == matchedCards.get(increment2))) {
//							System.out.println("this is r2 when matched "+ r2);
							isR2Good = false; 
						}
						increment2++; 
					} while (isR2Good == true && increment2 < matchedCards.size());
				}
			}
			else {
				isR2Good = false; 
			}
		}
		while(!isR2Good);

		if((twoFlipCardsPair != null) && (twoFlipCardsPair.size() != 0)){
			twoFlipCardsPair.clear();
		}
		
		
		twoFlipCardsPair.add(cardSet.get(r1));
		twoFlipCardsPair.add(cardSet.get(r2));
		
		return twoFlipCardsPair;
	  
	}

	public ArrayList<Square> getTwoFlipCardsPair() {
		return twoFlipCardsPair;
	}
	
	public void addMatch() {
		matchedCards.add(new Integer(r1));
		matchedCards.add(new Integer(r2));
//		System.out.println(r1);
//		System.out.println(r2);
	}
	
//	public ArrayList<Square> removeInt(ArrayList<Square> arr, int num) {
//		arr.remove(new Integer(num));
//		return arr; 
//	}
//	
//	public int r1() {
//		return r1; 
//	}
//	
//	public int r2() {
//		return r2; 
//	}
//	
}