//Kyle Antczak

import java.util.Random;
import java.util.ArrayList;


public class Person 
{
    int month;
    int day;
    
    public Person() //gives person random birth month and day
    {
        Random rand = new Random();
        
        month = rand.nextInt(12) + 1; // assigns random month 1-12
        
        if(month == 1 || month == 3 || month == 5|| month == 7|| month == 8 || month == 10 || month == 12) // if month has 31 days random day is 1-31
        {
            day = rand.nextInt(31) + 1;
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            day = rand.nextInt(30) + 1; //if month has 30 days 1-30
            
        }
        else
        {
            day = rand.nextInt(28) + 1;   //else month is febuary 1-28
        } 
        
         
    }

    public void getBirthday() //method returns birthday in print line
    {
        System.out.println("Month: " + month + " Day: " + day);
    }
    
    public int getMonth()  //method return birth month 
    {
        return month;
    }
    
    public int getDay() //method return birth day 
    {       
        return day;
    }
    
    
}
