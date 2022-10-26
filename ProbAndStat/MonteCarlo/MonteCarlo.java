//Kyle Antczak


import java.util.Random;
public class MonteCarlo
{
   
    Random rnd = new Random();
    
    private String door1;
    private String door2; 
    private String door3;
    
    private int noMovingWins;
    private int movingWins;
    
    public int getnoMovingWins() // counter of not switching doors during game wins
    {
        return noMovingWins;
    }
     
    public int getMovingWins() // counter of switching doors during game wins 
    {
        return movingWins;
    }
    
    public void playMonteCarloNoSwitch()//method simulates picking 1 of 3 doors then not switch after one door is revealed; if won adds 1 to win counter
    {
        int three = 3;//integer set to 3
        int zeroToTwo = rnd.nextInt(three); //Random to choose where cars and nothing go
        
        if(zeroToTwo == 0)
        {
            door1 = "Car";              //randomly sets which room has car and nothing
            door2 = "Nothing";
            door3 = "Nothing";
        }
        else if(zeroToTwo == 1)
        {
            door1 = "Nothing";
            door2 = "Car";
            door3 = "Nothing";
        }
        else if(zeroToTwo == 2)
        {
            door1 = "Nothing";
            door2 = "Nothing";
            door3 = "Car";
        }
        
        int randomPick = rnd.nextInt(three); // Random to choose door
        
        //for the simulation at this point one of the 2 doors not chosen is revealed to have nothing 
        
        if(randomPick == 0 && door1.equals("Car")) //if you don't move, only way to win is if the original door choosen has the car
        {          
            noMovingWins = noMovingWins + 1;
        }
        else if(randomPick == 1 && door2.equals("Car"))
        {
            noMovingWins = noMovingWins + 1;
        }
        else if(randomPick == 2 && door3.equals("Car"))
        {
            noMovingWins = noMovingWins + 1;
        }
             
    }
    
    public void playMonteCarloSwitch()//method simulates choosing 1 of 3 doors, then one door not choosen is revealed to have nothing and player switches to the other unchoosen door; if won adds 1 to win counter
    {
        int three = 3;//integer set to 3
        int zeroToTwo = rnd.nextInt(three); //Random to choose where car and nothing go
        
        if(zeroToTwo == 0)
        {
            door1 = "Car";
            door2 = "Nothing";                     //randomly sets which room has car and nothing
            door3 = "Nothing";
        }
        else if(zeroToTwo == 1)
        {
            door1 = "Nothing";
            door2 = "Car";
            door3 = "Nothing";
        }
        else if(zeroToTwo == 2)
        {
            door1 = "Nothing";
            door2 = "Nothing";
            door3 = "Car";
        }
        
        int randomPick = rnd.nextInt(three); // Random to choose players door
        
        if(randomPick == 0 ) // if you pick door one
        {                    
            if(door2.equals("Nothing") && door3.equals("Car"))  //if nothing is in door 2 and car is in 3: door 2 is revealed and player switchs to door 3 winning 
            {    
                movingWins = movingWins + 1;   
            }
            else if(door3.equals("Nothing") && door2.equals("Car")) //if nothing is in door 3 and car is in 3: door 3 is revealed and player switchs to door 2 winning
            {  
                movingWins = movingWins + 1;                
            }                                     //the only other option is if the car is in door 1, in which case you cant win because door 2 or 3 is revealed as nothing and you have to switch to the other nothing 
        }
        else if(randomPick == 1)  // if you pick door two
        {               
            if(door1.equals("Nothing") && door3.equals("Car"))//if nothing is in door 1 and car is in door 3, door 1 is revealed and player switches to door 3 winning 
            {
                movingWins = movingWins + 1;   
            }
            else if(door3.equals("Nothing") && door1.equals("Car")) //if nothing is in door 3 and car is in door 1, door 3 is revealed and player switches to door 1 winning 
            {
                movingWins = movingWins + 1;                //only other option doesnt result in a win of car being in door 2, making it so doors 1 or 3 are revealed and the player switches to the other nothing door
            }  
        }
        else if(randomPick == 2)// if you pick door three
        {      
            if(door1.equals("Nothing") && door2.equals("Car"))
            {
                movingWins = movingWins + 1;                      //same as other 2 sinarios, winning if not orignaly picking the door with the car and switching to it
            }
            else if(door2.equals("Nothing") && door1.equals("Car"))
            {
                movingWins = movingWins + 1;                
            }     
        }        
    }
    
 
    public double noSwitchSimWinPercent(int trials) //returns the win rate of winning no switching doors trial # of times
    {
        double winRate;
        double numTrials = trials; //sets trials as double
        
        for (int i = 0; i < trials; i++)//runs game int trials # of times times
        {   
            playMonteCarloNoSwitch();
        }
        
        winRate = noMovingWins / numTrials; 
        
        noMovingWins = 0; // after simulation resets win count to 0
        
        
        return winRate * 100.0;
    }
    
    public double switchSimWinPercent(int trials)//returns the win rate of winning switching doors trial # of times
    {
        double winRate;
        double numTrials = trials; //sets trials as double
        
        for (int i = 0; i < trials; i++)//runs game int trials # of times times
        {   
            playMonteCarloSwitch();
        }
        
        winRate = movingWins / numTrials; 
        
        movingWins = 0; // after simulation resets win count to 0
        
        
        return winRate * 100.0;
    }
    
}
