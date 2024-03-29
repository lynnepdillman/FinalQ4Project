package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//taken from Shannon Robinson's Code
public class LeaderBoard
{
    private static int highScore=0;
    
    public LeaderBoard()
    {
        try {
            read();
        } catch (IOException ex) {
            Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void save(int s) throws IOException, FileNotFoundException
    {
        if(s > highScore)
        {
            highScore = s;
            FileWriter fileWriter = new FileWriter("src/highScore.dat");
            fileWriter.write(highScore+" ");
            fileWriter.close();
        }  
    }
    
    public void read() throws IOException, FileNotFoundException
    {
        Scanner sc = new Scanner(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchGame\\src\\finalproject\\highScore.dat"));
        highScore = sc.nextInt();
    }
    
    public String get()
    {
        return highScore+"";
    }
}
