


public class PlotSaltSmoothTester 
{
    public static void main(String[] args)throws Exception
    {
        Plotter plot = new Plotter();
        
        plot.setPoints(500,-125,300); //plots 500 points from -125 to 300
        plot.pointsToCsv("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testplot.csv");
        
        
        Salter salt = new Salter();
        
        salt.csvToPoints("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testplot.csv");
        salt.saltPoints(1, 200); //salts a random value from 1 to 200
        salt.pointsToCsv("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testsaltplot.csv");
        
        Smoother smooth = new Smoother();
         
        smooth.csvToPoints("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testsaltplot.csv");
        smooth.smoothPoints(100); //smooths y value with average of 5 values around it
        smooth.pointsToCsv("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testsmoothplot.csv");
        
        
    }
    
    
    
    
    
    
}
