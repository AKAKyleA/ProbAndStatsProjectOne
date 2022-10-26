import java.util.Random;
import java.util.ArrayList; 
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;



public class FishMarket
{
    ArrayList<SeaFood> fishList = new ArrayList<>();

    
    public void generateSeaFood(int amount) //generates amount num of fish and all fish are equally likley to be added to market
    {
        for(int i = 0;i < amount;i++)
        {
            Random rand = new Random();
            int randFishType;
        
            randFishType = rand.nextInt(4);
            
            if(randFishType == 0)
            {
                fishList.add(new Shrimp());
            }
            else if(randFishType == 1)
            {
                fishList.add(new Crab());
            }
            else if(randFishType == 2)
            {
                fishList.add(new Scallop());
            }
            else
            {
                fishList.add(new Fish()); 
            }
        }
    }
    
    
    public void printMarket() //prints out the points 
    {
        for(int i = 0;i < fishList.size();i++)
        {    
            System.out.println("Type : " + fishList.get(i).getFishType() + " Weight: " + fishList.get(i).getWeight() + " PPP: " + fishList.get(i).getPpp());
        }
    }
    
    
    public void marketToCsv(String fileLocation) throws IOException
    {
        FileWriter fw = new FileWriter(fileLocation);
        PrintWriter out = new PrintWriter(fw);
        
        out.println("Index,Type,Weight,Ppp");
        
        for(int i =0;i < fishList.size();i++)//loops through fish list and prints them index,type,weight,ppp
        {
            out.println((i+1) + "," + fishList.get(i).getFishType() + "," + fishList.get(i).getWeight() +  "," + fishList.get(i).getPpp());
        }
        
        out.close();
    }
    
    
    public void generateSeaFoodWeighted(int numOfSeaFood, int shrimpPercent, int fishPercent, int scallopPercent, int crabPercent) // takes in amount of fish wanted and set 1-100% chance of fish being a certain type
    {
        if(shrimpPercent + fishPercent + scallopPercent + crabPercent != 100) //all percents added up need to be 100 for weights to work properly
        {
            System.out.println("Percents need to be inputed as integers and adds to 100");
        }
        else
        {
            for(int i = 0;i < numOfSeaFood;i++)
            {
                Random rand = new Random();
                int randFishType;
        
                randFishType = rand.nextInt(100) + 1; //gets a num from 1-100
            
                if(randFishType <= shrimpPercent) //gives each fish a set number of numbers from 1-100 based of percents 
                {
                    fishList.add(new Shrimp());
                }
                else if(randFishType <= (shrimpPercent + crabPercent) && randFishType > shrimpPercent)
                {
                    fishList.add(new Crab());
                }
                else if(randFishType <= (shrimpPercent + crabPercent + scallopPercent) && randFishType > (shrimpPercent + crabPercent))
                {
                    fishList.add(new Scallop());
                }
                else
                {
                    fishList.add(new Fish());
                }
            
            }
        }
 
    }
    
    
    public void csvToMarket(String fileLocation) throws Exception //reads a csv and adds fish to fishmarket
    {
        File file = new File(fileLocation);
        Scanner scn = new Scanner(file);
        boolean firstLine = true;
        
        while(scn.hasNextLine()) //loops all csv lines
        {
            String line = scn.nextLine();
            
            if(firstLine == true) // used to skip first line
            {
                firstLine = false;
            }
            else
            {
                int untilFirstComma = line.indexOf(",");
                String index = line.substring(0,untilFirstComma);    //string of the index
                String noindex = line.substring(untilFirstComma+1);   // string of everything after index,
                
                int untilSecondComma = noindex.indexOf(",");
                String type = noindex.substring(0,untilSecondComma); //string of type
                String noType = noindex.substring(untilSecondComma+1);//string of everything after type,
                
                int untilThirdComma = noType.indexOf(","); 
                String weight = noType.substring(0,untilThirdComma); //string of weight
                String ppp = noType.substring(untilThirdComma+1);   //string of ppp
                
                if(type.equals("Shrimp"))
                {
                    fishList.add(new Shrimp());
                }
                else if(type.equals("Crab"))   //checks to see what type of fish to add to fish market
                {
                    fishList.add(new Crab());
                }
                else if(type.equals("Scallop"))
                {
                    fishList.add(new Scallop());
                }
                else
                {
                    fishList.add(new Fish());
                }
                
                fishList.get(fishList.size()-1).setWeight(Double.valueOf(weight));  //changes the weight of the fish from random to what it is in csv
            }
        }
    }
}
