//Kyle Antczak

public class MonteCarloTester
{
    
     public static void main (String[] args)
     {
        
        MonteCarlo monte = new MonteCarlo();
  
        System.out.println(monte.noSwitchSimWinPercent(10000)); // prints % of wins of not switching doors over 10000 trials
        
        System.out.println(monte.switchSimWinPercent(10000)); // prints % of wins of switching doors over 10000 trials
        
        
    }
    

    
}
