import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;





public class Smoother 
{
    
     ArrayList<Point> points = new ArrayList<Point>();
    
     public void csvToPoints(String fileLocation) throws Exception //reads csv and puts points in array points
    {
        
        File file = new File(fileLocation);
        Scanner scn = new Scanner(file);
 
        
        while (scn.hasNextLine())//reads each line of file
        {
            
            String line = scn.nextLine();
            
            int untilComma = line.indexOf(",");//marks where the comma is
            
            String xVal = line.substring(0,untilComma);// x value is the char before the comma
            
            String yVal = line.substring(untilComma+1);//y value is the char after the comma
            
            points.add(new Point(Double.valueOf(xVal),Double.valueOf(yVal)));// adds point to points
            
        }
    }
    
    public void smoothPoints(int range)
    {   
        boolean isOdd = true;
        
        
        if(points.size() % 2 == 0 )
        {
            isOdd = false;
        }
        
        if(isOdd == true && range > (points.size()+1) / 2  || isOdd == false && range > (points.size() / 2) - 1)
        {
            System.out.println("Enter a lower range");
        }
        else
        {
            
            for(int i = 1; i < points.size() + 1;i++) //loops through the values changing the y to the ave of ones around it 
            {
                double sumVal = 0;
                double pointCount = 0;
                
                
                
                if(i < range + 1 && i != 1)  //handels first points that range isnt big enough yet
                {
                    
                    for(int j = i-2; j > -1; j--)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        
                        pointCount = pointCount + 1;
                        
                    }
                    
                    double lowRange = pointCount;
                    
                    for(int j = i; j < i + lowRange; j++)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        pointCount = pointCount + 1;
                        
                    }
                    
                    
                    points.get(i-1).setY(sumVal/pointCount);
                    
                    
                }
                else if(points.size() - i < range && i != points.size())
                {
                    
                    for(int j = i; j < points.size();j++)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        
                        pointCount = pointCount + 1;
                        
                    }
                    
                    double highRange = pointCount;
                    
                    for(int j = i-2; j > i - highRange - 2; j--)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        
                        pointCount = pointCount + 1;
                        
                    }
                    
                    points.get(i-1).setY(sumVal/pointCount);
        
                }
                else if(i > range && points.size() - i > range)  // else if the point has enough values in range
                {
                    for(int j = i-2; j > i - range - 2; j--)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        
                        pointCount = pointCount + 1;
                        
                    }
                    
                    double lowRange = pointCount;
                    
                    for(int j = i; j < i + range; j++)
                    {
                        sumVal = sumVal + points.get(j).getY();
                        pointCount = pointCount + 1;
                        
                    }
                    
                    
                    points.get(i-1).setY(sumVal/pointCount);
                }
                
            }
           
            
        }
        
        roundThreePlaces();
    }
     
     
     
     
     
     
     
    public void printPoints() //prints points 
    {
        for(int i = 0;i < points.size();i++)
        {    
            System.out.println("Point " + (i + 1) + ": " + points.get(i).getX() + "," + points.get(i).getY());
        }
    }
     
     
    public void roundThreePlaces()  //rounds all the points to 3 decimal places
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
