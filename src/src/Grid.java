/*
* Name: Brayden O' Neill / Martin Colclough
* Date: 20/11/18
* Function: Setup the grid (but not print). It prints in PlayGame
*/

package src;

public class Grid 
{   //variables
    public String[] grid = new String[100];
    private String snake;
    private String babySnake;
    private String dragon;
    private String babyDragon;
    private String blackHole;
    private String empty;
    private String player1;
    private String player2;
    private String player12;
    private String beginning;   //this won't be printed on the first round because player 1 and 2 are on that square
    private String end;

    public Grid()   //these are the values that will be printed on the grid
    {
        snake = "  S  ";
        babySnake = "  s  ";
        dragon = "  D  ";
        babyDragon = "  d  ";
        blackHole = "  B  ";
        empty = " ___ ";
        player1 = "  1  ";
        player2 = "  2  ";
        player12 = " 1/2 "; //this is what will be printed if player1 and player2 are on the same slot
        beginning = " BGN ";
        end = " END ";
    }//end of constructor1
    
    public Grid(String snake, String babySnake, String dragon, String babyDragon, String blackHole, String empty, String player1, String player2, String player12,String beginning, String end) 
    {
        this.snake = snake;
        this.babySnake = babySnake;
        this.dragon = dragon;
        this.babyDragon = babyDragon;
        this.blackHole = blackHole;
        this.empty = empty;
        this.player1 = player1;
        this.player2 = player2;
        this.player12 = player12;
        this.beginning = beginning;
        this.end = end;
    }//end of constructor2

    public void setSnake(String snake) 
    {
        this.snake = snake;
    }

    public void setBabySnake(String babySnake) 
    {
        this.babySnake = babySnake;
    }

    public void setDragon(String dragon) 
    {
        this.dragon = dragon;
    }

    public void setBabyDragon(String babyDragon) 
    {
        this.babyDragon = babyDragon;
    }

    public void setBlackHole(String blackHole) 
    {
        this.blackHole = blackHole;
    }

    public void setEmpty(String empty) 
    {
        this.empty = empty;
    }

    public void setPlayer1(String player1) 
    {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) 
    {
        this.player2 = player2;
    }

    public void setPlayer12(String player12) 
    {
        this.player12 = player12;
    }
    
    public void setBeginning(String beginning)
    {
        this.beginning = beginning;
    }
    
    public void setEnd(String end)
    {
        this.end = end;
    }
   
    public String getSnake() 
    {
        return snake;
    }

    public String getBabySnake() 
    {
        return babySnake;
    }

    public String getDragon() 
    {
        return dragon;
    }

    public String getBabyDragon() 
    {
        return babyDragon;
    }

    public String getBlackHole() 
    {
        return blackHole;
    }

    public String getEmpty() 
    {
        return empty;
    }

    public String getPlayer1() 
    {
        return player1;
    }

    public String getPlayer2() 
    {
        return player2;
    }

    public String getPlayer12() 
    {
        return player12;
    }
    
    public String getEnd()
    {
        return end;
    }
    
    public String getBeginning()
    {
        return beginning;
    }
    
    public String[] makeGrid(String snake, String babySnake, String dragon, String babyDragon, String blackHole, String empty, String beginning, String end)  //place the obstacles on the grid
    {
        for(int position = 0; position < grid.length; position++)
        {
                if(position == 98)  //position of the black hole
                {
                    grid[position] = getBlackHole();
                }//if blackHole
                
                else if(position == 1 || position == 37 || position == 65 || position == 72)    //positions of all the dragons
                {
                    grid[position] = getDragon();
                }//if dragon
                
                else if(position == 23 || position == 54 || position == 61 || position == 94)   //positions of all the snakes
                {
                    grid[position] = getSnake();
                }//if snake
                
                else if(position == 9 || position == 42 || position == 77 || position == 96)    //positions of all the baby snakes
                {
                    grid[position] = getBabySnake();
                }//if babySnake
                
                else if(position == 14 || position == 26 || position == 34 || position == 46)   //positions of all the baby dragons
                {
                   grid[position] = getBabyDragon();
                }//if babyDragon
                
                else if(position == 0)
                {
                    grid[position] = getBeginning();
                }//if beginning
                
                else if(position == 99)
                {
                    grid[position] = getEnd();
                }//end of END
                
                else
                {
                    grid[position] = empty; //fill everything else with an empty slot
                }//if empty
        }//end of position  
        return grid;
    }//end of makeGrid
    
    public void playerLocations(int player1Pos, int player2Pos) //this will set the players' current position on the grid
    {
        for(int position = 0; position < grid.length; position++)   //forloop to check where the players are
        {
            if(position == player1Pos && position == player2Pos)    //if player 1 and player 2 are on the same spor
            {
                grid[position] = getPlayer12(); 
            }//end of same spot
            
            else if(position == player1Pos) //if player 1 is on this spot
            {
                grid[position] = getPlayer1();
            }//end of player1
            
            else if(position == player2Pos) //if player 2 is on this spot
            {
                grid[position] = getPlayer2();
            }//end of player2
        }//end of forLoop
    }//end of playerLocations

}//end of class
