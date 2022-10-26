//Kyle Antczak
import java.util.ArrayList;


public class BirthdayProgram 
{
    
    public double shareBirthday(int numOfPeople) // input number of people returns percent of how many people share a birthday 
    {
        int matchCounter = 0;
        
        ArrayList<Person> people = new ArrayList<>();
            
        for(int j = 0; j < numOfPeople; j++)
        {        
            people.add(new Person());    //loops number of people times and adds that many new people to an array list
        }
            
        for(int j = 0; j < people.size(); j++) //loops through number of people
        {
            if(sharesABirthday(people,people.get(j))) //checks to see if they share a birthday with someone else
            {
                matchCounter = matchCounter + 1; //if they do adds 1 to the count 
            }  
        }
        
        double matchCountDoub = matchCounter; 
        double numOfPeopDoub = numOfPeople;
        double shareABirthdayRate = matchCountDoub / numOfPeopDoub; // divides number of people who share a birthday with someone else by total number of people
            
        return shareABirthdayRate * 100.0;   
    }
    
    
    public boolean sharesABirthday(ArrayList<Person> people,Person pers)//method checks the list and returns true if pers shares a birthday with someone else
    {
        int shareCount = 0;
        boolean sharesWithSomeone = false;
        
        for(int j = 0; j < people.size(); j++) //loops through people list and count number of people who share a birthday with pers (includes pers in count)
        {
            //System.out.println("pers Birthday:" + pers.getMonth() +" " +pers.getDay() + " other Birthday: " + people.get(j).getMonth()+ " " + people.get(j).getDay() ); used for testing 
            
            if(pers.getDay() == people.get(j).getDay() && pers.getMonth() == people.get(j).getMonth())
            {
                shareCount = shareCount + 1;
            }    
        }
        
        if(shareCount > 1) //arraylist contains that person so shareCount will be at 1 if noone shares a birthday 
        {
            sharesWithSomeone = true; //if someone shares a birthbay with pers then true is returned
        }
        
        return sharesWithSomeone;
    }
    
    public double sharesBirthdayMultiTrials(int numOfPeople,int numOfTrials) //returns the average percent of number of people who share a birthday out of #ppl based off #trials ran
    {
        double trialsDoub = numOfTrials;
        double percentSum = 0;
        double aveOfTrials;
        
        for(int i = 0;i < numOfTrials;i++) //loops for the number of trials to be ran and sums all the percents 
        {
            percentSum = percentSum + shareBirthday(numOfPeople);
        
        }
        
        aveOfTrials = percentSum / trialsDoub; //divides sum of all the percernts by number of trials
        
        return aveOfTrials;
        
    }
    
    
    
}
