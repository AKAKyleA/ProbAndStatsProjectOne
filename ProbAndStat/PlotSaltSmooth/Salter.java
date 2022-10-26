
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

public class Salter
{
    
    ArrayList<Point> points = new ArrayList<Point>(); // array of points
    
    
    
    public void csvToPoints(String fileLocation) throws Exception  //reads csv and puts points in array points
    {
        
        File file = new File(fileLocation);
        Scanner scn = new Scanner(file);
        
        while (scn.hasNextLine()) //reads each line of file
        {
            
            String line = scn.nextLine();
            
            int untilComma = line.indexOf(","); //marks where the comma is
            
            String xVal = line.substring(0,untilComma); // x value is the char before the comma
            
            String yVal = line.substring(untilComma+1); //y value is the char after the comma
            
            points.add(new Point(Double.valueOf(xVal),Double.valueOf(yVal))); // adds point to points
            
        } 
    }
    
    public void printPoints() //prints list of points
    {
        for(int i = 0;i < points.size();i++)
        {    
            System.out.println("Point " + (i + 1) + ": " + points.get(i).getX() + "," + points.get(i).getY());
        }
    }
    
    public void saltPoints(int minRange,int maxRange) //inputs range of random values and adds or subtracts a random number from that range to y value
    {
        Random rnd = new Random();
        
        for(int i = 0;i < points.size();i++)
        {
            int saltVal = rnd.nextInt(maxRange - minRange) + minRange;    //random value in range min to max
            
            int negOrPos = rnd.nextInt(2); // random value 0 or 1
            
            if(negOrPos == 0) //if 0 adds value to y
            {
               double y = points.get(i).getY();
               points.get(i).setY(y + saltVal);
            }
            else //else it subtracts value from y
            {
               double y = points.get(i).getY();
               points.get(i).setY(y - saltVal);   
            }
            
        }
        
        roundThreePlaces();
    }
    
    public void roundThreePlaces() //rounds all the points to 3 decimal places
    {
        for(int i = 0;i < points.size();i++)
        {     
            double newX = Math.round(points.get(i).getX()*1000.0)/1000.0;
            double newY = Math.round(points.get(i).getY()*1000.0)/1000.0;
            
              points.get(i).setX(newX);
              points.get(i).setY(newY);
 
        }
  
    }
    
    
    public void pointsToCsv(String fileLocation) throws IOException //writes the points to a csv file 
    {   
        
      //  FileWriter fw = new FileWriter("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testsaltplot.csv",true);
        FileWriter fw = new FileWriter(fileLocation);
        PrintWriter out = new PrintWriter(fw);
        
        
        for(int i = 0;i < points.size();i++)
        {
            out.println(points.get(i).getX() + "," + points.get(i).getY());
        }
        
        out.close();
        
        
    }
   
    
}
