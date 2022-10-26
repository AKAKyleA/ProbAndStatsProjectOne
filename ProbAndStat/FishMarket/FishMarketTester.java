

public class FishMarketTester
{
    
    public static void main(String[] args) throws Exception
    {
        
        FishMarket market = new FishMarket();
        FishMarket marketTwo = new FishMarket();
        FishMarket marketThree = new FishMarket();
        
        market.generateSeaFood(300);
        market.marketToCsv("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testfishmarket.csv");
        
        marketTwo.generateSeaFoodWeighted(300,5,30,25,40);
        marketTwo.marketToCsv("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testfishmarketTwo.csv");
        
        marketThree.csvToMarket("C:\\Users\\kylea\\OneDrive\\Desktop\\Plotter\\testfishmarketTwo.csv");
        marketThree.printMarket();
        
        
        
    }
    
    
    
    
    
    
}
