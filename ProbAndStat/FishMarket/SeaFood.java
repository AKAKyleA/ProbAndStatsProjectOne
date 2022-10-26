
import java.math.*;

public class SeaFood
{
    
    String fishType;
    double weight;
    double ppp;
    
    
    public SeaFood()
    {
       
        
        double randWeight = Math.random();
        
        randWeight = Math.round(randWeight*1000.0)/1000.0;
        
        weight = randWeight;
    }

    
    public double getPpp()
    {
        return ppp;
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    public String getFishType()
    {
        return fishType;
    }
    
    public void setPpp(double newPpp)
    {
        ppp = newPpp;
    }
    
    public void setWeight(double newWeight)
    {
        weight = newWeight;
    }
    
    public void setFishType(String newFishType)
    {
        fishType = newFishType;
    }
    
}
