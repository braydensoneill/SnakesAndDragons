/*
* Name: Brayden O Neill & Martin Colclough
* Date 18/11/18
* Function: Use an enum to print the winner's response depending on the score
*/

package src;

import java.util.Random;

public class TrashTalk extends PlayGame 
{
    Random rand = new Random();
    
    int num = 0;
    Responses response;
    
    public enum Responses
    {
        NICE, AVERAGE, MEAN
    }//end of enumWeapon
    
    public TrashTalk(Responses response)
    {
        this.response = response;
    }//end of WeaponType
    
    public void responseTypes()
    {
        switch(response)
        {
            case NICE:
                num = rand.nextInt(3) + 1;
                switch(num)
                {
                    case 1: System.out.println("Wow! that was a close game. Nice try"); break;
                    case 2: System.out.println("That was a good game! You played well!"); break;
                    case 3: System.out.println("You nearly had me! GG!"); break;
                }//end of num switch
                break;
            case AVERAGE:
                num = rand.nextInt(4) + 1;
                switch(num)
                {
                    case 1: System.out.println("Maybe next time!"); break;
                    case 2: System.out.println("Want a Rematch?"); break;
                    case 3: System.out.println("Where's my prize money?"); break;
                    case 4: System.out.println("I guess they never miss, huh?"); break;
                }//end of num switch
                break;
            case MEAN:
                num = rand.nextInt(13) + 1;
                switch(num)
                {
                    case 1: System.out.println("That was the easiest game of my life..."); break;
                    case 2: System.out.println("My grandmother plays better than you..."); break;
                    case 3: System.out.println("Are you even trying? Too easy..."); break;
                    case 4: System.out.println("Your IQ is lower than you Dice Rolls!"); break;
                    case 5: System.out.println("WOW! You're even worse than Michael Fogarty at CSGO!"); break;
                    case 6: System.out.println("Is your monitor even on? You're terrible!"); break;
                    case 7: System.out.println("Haha my eyes were closed and I still won!"); break;
                    case 8: System.out.println("You're even worse at this game than I am at Programming!"); break;
                    case 9: System.out.println("Remember that time I said I thought you were cool? I lied."); break;
                    case 10: System.out.println("Jesus might love you, but everyone else definitely thinks you’re an idiot."); break;
                    case 11: System.out.println("YOU'RE TRASH"); break;
                    case 12: System.out.println("SMASH!"); break;
                    case 13: System.out.println("I'm already Tracer!"); break;
                }//end of num switch
                break;
        }//end of response switch
    }//end of responseType method
}//end of class
