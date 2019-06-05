package finalproject;

import java.util.ArrayList;

public class Numbers {
	public Numbers() {
	}
	
	public ArrayList<Integer> removeint(ArrayList<Integer> arr, int r) {
		arr.remove(new Integer(r));
		return arr; 
	}
}