//Kyle Antczak
import java.util.ArrayList;
import java.math.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

public class Plotter 
{
    ArrayList<Point> points = new ArrayList<Point>(); //list of the points
    
    public void setPoints(int numOfPoints,double lowRange, double highRange) //inputs number of points wanted, range of x values
    {
       
        double pointInterval = (highRange - lowRange) / (numOfPoints - 1); //starting at low range for first point ending at high range for last point, gives interval between x values
        double currentX = lowRange;
        
        for(int i = 0; i < numOfPoints;i++) //loads all the point into an array list
        {
            points.add(new Point(currentX,getYfromX(currentX)));
            
            currentX = currentX + pointInterval;
        }
        
        roundThreePlaces(); // rounds the points to 3 decimal places
       // for(int i = 0;i < points.size();i++)
       // {    
       //     System.out.println("Point " + (i + 1) + ": " + points.get(i).getX() + "," + points.get(i).getY());
       // }
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
    
    public void printPoints() //prints out the points 
    {
        for(int i = 0;i < points.size();i++)
        {    
            System.out.println("Point " + (i + 1) + ": " + points.get(i).getX() + "," + points.get(i).getY());
        }
    }
    
    
    public double getYfromX(double xValue)  // sets the y value based on linear  
    {
        double m = 3.5; // slope  values can be changed 
        double b = 5; // sets b 
        
        return (m*xValue) + b; 
    }
    
    
    public void pointsToCsv(String file) throws IOException //writes the points to a csv file 
    {   
        
      //  FileWriter fw = new FileWriter("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testplot.csv",true);
      
       
      
        FileWriter fw = new FileWriter(file);
        PrintWriter out = new PrintWriter(fw);
        
        
        for(int i = 0;i < points.size();i++)
        {
            out.println(points.get(i).getX() + "," + points.get(i).getY()); //writes each line as a x point,y point
        }
        
        out.close();
        
        
    }
    

    
}
