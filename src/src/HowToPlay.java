/*
* Name: Brayden O'Neill, Martin Colclough
* Date: 20/11/2018
* Function: Display the rules
*/

package src;

public class HowToPlay 
{
    public void howTo() //display how to play the game and what each symbol on the grid means
    {
        System.out.println("---------------------How to Play---------------------");
        System.out.println("|                                                   |");
        System.out.println("|   Press any number to Roll the Dice               |");
        System.out.println("|   First Player to reach END wins                  |");
        System.out.println("|                                                   |");
        System.out.println("|   (D) / Dragon        /   +10 points              |");
        System.out.println("|   (d) / Baby Dragon   /    +3 points              |");
        System.out.println("|   (S) / Snake         /   -10 points              |");
        System.out.println("|   (s) / BabySnake     /    -3 points              |");
        System.out.println("|   (1) / Player 1      /    P1's current position  |");
        System.out.println("|   (2) / Player 2      /    P2's current position  |");
        System.out.println("|                                                   |");
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }//end of howTo
}//end of class
