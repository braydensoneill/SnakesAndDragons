/*
* Name: Brayden O Neill & Martin Colclough
* Date 18/11/18
* Function: Create a menu for the game which contains 'PlayGame', 'Stats', 'How to Play' and 'Exit'
* UML is in the same folder as project
*/

package src;

import java.io.FileNotFoundException;
import java.util.Scanner;


public abstract class SnakesAndDragons 
{
    public static void main(String[]args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        int menuInput;
        
        do
        {
            System.out.println("----------MENU-----------");
            System.out.println("|   (1) Play Game       |");
            System.out.println("|   (2) Stats           |");
            System.out.println("|   (3) How to Play     |");
            System.out.println("|   (4) Exit            |");
            System.out.println("-------------------------");
        
            menuInput = scan.nextInt();
            System.out.println();
            
            switch(menuInput)
            {
                case 1: 
                    PlayGame p = new PlayGame();
                    p.play();
                    p.statCalculator();
                    break;
                case 2:
                    Stats s = new Stats();
                    s.showStats();
                    System.out.println();
                    break;
                case 3:
                    HowToPlay h = new HowToPlay();
                    h.howTo();
                    break;
                case 4:
                    System.out.println("Goodbye");  //due to it being a do while, this will be printed before it exits the loop
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Entry");
                    System.out.println();
                    break;
            }//end of switch
        }while(menuInput != 4);//end of while
    }//end of main
}//end of class#