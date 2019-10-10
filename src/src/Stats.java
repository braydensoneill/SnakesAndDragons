/*
 * Name: Brayden O'Neill, Martin Colclough
 * Date: 20/11/2018
 */
package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stats
{
    public void showStats() throws FileNotFoundException
    {
        String inputFileName = "Stats.txt";
        String inputText;
        
        File inputFile = new File(inputFileName);
        
        Scanner in = new Scanner(inputFile);
        
        while(in.hasNext())
        {
            inputText = in.nextLine();
            System.out.println(inputText);
        }//end of while
        
        in.close();
        
    }//end of showStats
}//end of class
