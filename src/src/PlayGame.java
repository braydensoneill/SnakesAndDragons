/*
* Name: Brayden O'Neill, Martin Colclough
* Date: 20/11/2018
* Function: Play the game
*/

package src;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class PlayGame implements PlayGameInterface
{
    private int player1Pos;
    private int player2Pos;
    private int dice;
    private int dRoll;
    private int round;
    private int D1; //these count the amount of times an obstacle is hit
    private int d1;
    private int S1;
    private int s1;
    private int b1;
    private int totalDiceRoll = 0;
    private int diceRollsUsed = 0;
    
    public PlayGame() 
    {
        player1Pos = 0;
        player2Pos = 0;
        dice = 0;
        dRoll = 0;
        round = 1;
    }//end of constructor1

    public PlayGame(int player1Pos, int player2Pos, int dice, int dRoll, int round) 
    {
        this.player1Pos = player1Pos;
        this.player2Pos = player2Pos;
        this.dice = dice;
        this.dRoll = dRoll;
        this.round = round;
    }//end of constructor2

    public void setPlayer1Pos(int player1Pos) 
    {
        this.player1Pos = player1Pos;
    }//end of setPlayer1Pos

    public void setPlayer2Pos(int player2Pos) 
    {
        this.player2Pos = player2Pos;
    }//end of setPlayer2Pos

    public void setDice(int dice) 
    {
        this.dice = dice;
    }//end of setDice
    
    public void setDRoll(int dRoll)
    {
        this.dRoll = dRoll;
    }//end of serDRoll
    
    public void setRound(int round)
    {
        this.round = round;
    }//end of setRound

    public int getPlayer1Pos() 
    {
        return player1Pos;
    }//end of getPlayer1Pos

    public int getPlayer2Pos() 
    {
        return player2Pos;
    }//end of getPlayer2Pos

    public int getDice() 
    {
        return dice;
    }//end of getDice
    
    public int getDRoll()
    {
        return dRoll;
    }//end of getDice
    
    public int getRound()
    {
        return round;
    }//end of getRound
    
    public void play()
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("--------Play Game--------");
        printGrid();
        System.out.println();
        System.out.println();
        
        while(player1Pos < 99 && player2Pos < 99)
        {
            System.out.println("------Player 1's turn-----");
            System.out.println("Round: " + round);
            System.out.println("Current Position: " + player1Pos);
            System.out.println("Press any number to roll the dice");
            
            dice = scan.nextInt();
            dRoll = rand.nextInt(6)+1;
            diceRollsUsed++;
            totalDiceRoll = totalDiceRoll + dRoll;
            
            System.out.println("Dice: " + dRoll);
            player1Pos = player1Pos + dRoll;
            interact1();
            
            if(player1Pos > 99)
            {
                player1Pos = 99;
            }//end of if higher than 99
                
            System.out.println("New Position: " + player1Pos);
            System.out.println();
            
            printGrid();
            System.out.println();
            System.out.println();
            
            System.out.println("------Player 2's turn-----");
            System.out.println("Round: " + round);
            System.out.println("Current Position: " + player2Pos);
            System.out.println("Press any number to roll the dice");
            dice = scan.nextInt();
            dRoll = rand.nextInt(6)+1;
            
            System.out.println("Dice: " + dRoll);
            player2Pos = player2Pos + dRoll;
            interact2();
            
            if(player2Pos > 99)
            {
                player2Pos = 99;
            }//end of if higher than 99
            
            System.out.println("New Position: " + player2Pos);
            System.out.println();
            
            printGrid();
            System.out.println();
            System.out.println();
            
            round++;
        }//end of gameWhile
        
        System.out.println();
        pickWinner();
    }//end of play
    
    public void printGrid()
    {
        Grid g1 = new Grid();
        g1.makeGrid(g1.getSnake(), g1.getBabySnake(), g1.getDragon(), g1.getBabyDragon(), g1.getBlackHole(), g1.getEmpty(),g1.getBeginning(), g1.getEnd());
        
        g1.playerLocations(player1Pos, player2Pos);
        
        for(int position = 0; position < g1.grid.length; position++)
        {
            if(position % 10 == 0)
            {
                System.out.print("\n");
            }//end of new line

            System.out.print(g1.grid[position]);
        }    
        System.out.println();
        
    }
    
    public void interact1()
    {
        Grid g2 = new Grid();
        
        if(player1Pos == 1 || player1Pos == 37 || player1Pos == 65 || player1Pos == 72)
        {
            player1Pos += 10;
            System.out.println("Hit a Dragon");
            D1++;
        }//dragon
        else if(player1Pos == 23 || player1Pos == 54 || player1Pos == 61 || player1Pos == 94)
        {
            player1Pos -= 10;
            System.out.println("Hit a Snake");
            S1++;
        }//snake
        else if(player1Pos == 9 || player1Pos == 42 || player1Pos == 77 || player1Pos == 96)
        {
            player1Pos -= 3;
            System.out.println("Hit a Baby Snake");
            s1++;
        }//babySnake
        else if(player1Pos == 14 || player1Pos == 26 || player1Pos == 34 || player1Pos == 46)
        {
            player1Pos += 3;
            System.out.println("Hit a Baby Dragon");
            d1++;
        }//baby Dragon
        else if(player1Pos == 98)
        {
            player1Pos = 0;
            System.out.println("Hit THE BLACK HOLE");
            b1++;
        }//black hole
        else
        {
            player1Pos = player1Pos;
            System.out.println("No obstacles hit");
        }//end of no obstacles hit
    }
    
    public void interact2()
    {
        Grid g2 = new Grid();
        
        if(player2Pos == 1 || player2Pos == 37 || player2Pos == 65 || player2Pos == 72)
        {
            player2Pos += 10;
            System.out.println("Hit a Dragon");
            D1++;
        }//dragon
        else if(player2Pos == 23 || player2Pos == 54 || player2Pos == 61 || player2Pos == 94)
        {
            player2Pos -= 10;
            System.out.println("Hit a Snake");
            S1++;
        }//snake
        else if(player2Pos == 9 || player2Pos == 42 || player2Pos == 77 || player2Pos == 96)
        {
            player2Pos -= 3;
            System.out.println("Hit a Baby Snake");
            s1++;
        }//babySnake
        else if(player2Pos == 14 || player2Pos == 26 || player2Pos == 34 || player2Pos == 46)
        {
            player2Pos += 3;
            System.out.println("Hit a Baby Dragon");
            d1++;
        }//baby Dragon
        else if(player2Pos == 98)
        {
            player2Pos = 0;
            System.out.println("Hit THE BLACK HOLE");
            b1++;
        }//black hole
        else
        {
            player2Pos = player2Pos;
            System.out.println("No obstacles hit");
        }//end of no obstacles hit
    }//end of interact
    
    public void pickWinner()
    {
        if(player1Pos >= 99)
        {
            System.out.println("Game Over, Player 1 wins");
            
            System.out.print("Winner's response: ");
            decideResponse1();
            
            System.out.println();
        }//end of player 1 Win
        
        else if(player2Pos >= 99)
        {
            System.out.println("Game Over, Player 2 wins");
            
            System.out.print("Winner's response: ");
            decideResponse2();
            
            System.out.println();
        }//end of player 2 Win
        
        else if(player1Pos >=99 && player2Pos >= 99)
        {
            System.out.println("Game Over, it is a tie.");            
            System.out.println();
        }//end of tie
    }//end of pickWinner
    
    public void decideResponse1()
    {
        PlayGame p1 = new PlayGame();
        
        if(player1Pos >= 99 && player2Pos >= 89)
        {
            TrashTalk t1 = new TrashTalk(TrashTalk.Responses.NICE);
            t1.responseTypes();
        }//end of close win with nice repsonse
        
        else if(player1Pos >= 99 && (player2Pos >= 74 && player2Pos <= 88))
        {
            TrashTalk t2 = new TrashTalk(TrashTalk.Responses.AVERAGE);
            t2.responseTypes();
        }//end of average win with average response
        
        else
        {
            TrashTalk t3 = new TrashTalk(TrashTalk.Responses.MEAN);
            t3.responseTypes();
        }//end of average win with average response
    }//end of decideType
    
    public void decideResponse2()
    {
        PlayGame p = new PlayGame();
        
        if(player2Pos >= 99 && player1Pos >= 89)
        {
            TrashTalk t1 = new TrashTalk(TrashTalk.Responses.NICE);
            t1.responseTypes();
        }//end of close win with nice repsonse
        
        else if(player2Pos >= 99 && (player1Pos >=74 && player1Pos <= 88))
        {
            TrashTalk t2 = new TrashTalk(TrashTalk.Responses.AVERAGE);
            t2.responseTypes();
        }//end of average win with average response
        
        else
        {
            TrashTalk t3 = new TrashTalk(TrashTalk.Responses.MEAN);
            t3.responseTypes();
        }//end of average win with averawdawwwwwwwwwge response
    }//end of decideResponse2
    
    public void statCalculator() throws FileNotFoundException
    {
        int sumOfObstacles = d1 + D1 + s1 + S1 + b1;
        int averageDiceRoll = totalDiceRoll / diceRollsUsed;
        
        String outputFileName = "Stats.txt";
        
        PrintWriter out = new PrintWriter(outputFileName);
        
        out.println("-------Stats of Last Game-------");
        out.println("|  Number of Rounds: " + round + "        |");
        out.println("|  Player 1 Position: " + player1Pos + "       |");
        out.println("|  Player 2 Position: " + player2Pos + "       |");
        out.println("|  Obstacles Hit: "  + sumOfObstacles + "           |");
        out.println("|  Sum Dice Roll: "  + totalDiceRoll + "          |");
        out.println("|  Times Dice was rolled: " + diceRollsUsed + "   |");
        out.println("|  Average Dice Roll: "  + averageDiceRoll + "        |");
        out.println("--------------------------------");

        out.close();
        
    }//end of statCalculator
    
}//end of class