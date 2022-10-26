//Kyle Antczak

import java.util.ArrayList;
import java.math.BigInteger;
import java.math.BigDecimal;

public class ProbAndStatsLibrary //This class has a solver for all the operations used in class so far
{
    
    public static double mean(int[] values) //Inputs an array of integers and returns the mean of the elements 
    {
        double count = 0; //used to calculate total sum of elements 
        int size = values.length; //num of elements in array
        
        for(int i = 0 ; i < size; i++) //loops through all elements of values array and adds them to count
        {
            count = count + values[i];
        }
         
        return count/size; //returns total value of all elements divided by amount of elements
    }
    
    
    public static double median(int[] values)
    {
        int size = values.length;   //num of elements in array
        double med = 0; // is the double for the median when found
        int[] valuesInOrder = putInAscendingOrder(values); //uses method to return an array with the elements is ascending order and sets it to valuesInOrder                         

        if(size % 2 == 0) //if there is an even number of elements, median is the average of the 2 middle values 
        {
            med = (valuesInOrder[size/2 - 1] + valuesInOrder[size/2]) / 2.0;
        }
        else //if there is an odd number of elements, median is the middle element in the list
        {
            med = valuesInOrder[(size-1)/2];
        }
        
        return med;  
    }
    
    
    public static int[] putInAscendingOrder(int[] values) //Used in Median Method. Puts Array of integers in Asending Order
    {   
        int size = values.length;
        int lowestVal = 0; //place holder for lowest value when looping
        int temp = 0; //temp value used when swaping 2 elements in the array
        
        for(int i = 0; i < size; i++) //loops through array to put the next lowest value at element i
        {
            lowestVal = values[i]; // initially sets the value at i as the lowest value 
            
            for(int j = i; j < size; j++)  //loops through element i to the end of the arraylist to find lowest value and sets it at i
            {
                if(values[j] < lowestVal) //checks if value at element j is lower than current lowest value(which is at i)
                {                           //if value at j is lower than value a i 
                    lowestVal = values[j];  //the lowestVal is set to the value at j
                    
                    temp = values[i];      //and the values at elements i and j are swapped
                    values[i] = values[j];
                    values[j] = temp;
                }
            }       
        }
         
        return values; //returns array 
    }
    
    
    public static int mode(int[] values) //inputs an array and outputs the mode of the values
    {
        
        int size = values.length;   //num of elements
        int tempMode;   // array element being counted 
        int counter = 0;  // number of times element appears in array
        int highestMode = 0; //element most occuring in array 
        int highestModeCount = 0;//number of times element occurs 
        
        for(int i = 0; i < size; i++)  //loops array to test each elements 
        {
            tempMode = values[i];  
            
            for(int j = 0; j < size; j++)  //loops array to count how many times element appears
            {
                if(tempMode == values[j]) 
                {
                    counter = counter + 1;
                }
            }
            
            if(counter > highestModeCount) //if current element appears more times then 
            {                              //previous highest element, current replaces as new highest
                highestMode = tempMode;
                highestModeCount = counter;
            }
            
            counter = 0;  //reset counter
        }
        
        return highestMode; //return the value with the highest frequency in the array; if there is more than 1 element that appears the same number of times in the array
    }                       // the one with the lowest index is returned
    
    
    public static BigInteger factorial(int num) //inputs a number and returns its factorial 
    {   
 
        
        BigInteger totalProduct = new BigInteger("1"); //used to toatal product when multipling by each i, with a starting value of 1
        
        for(int i = 2; i <= num; i++) //loop 2 through num times
        {
            totalProduct = totalProduct.multiply(BigInteger.valueOf(i));
        }
        
        return totalProduct;
    }
    
    
    public ArrayList<Integer> union(ArrayList<Integer> setA,ArrayList<Integer> setB) //inputs 2 arraylists and returns an array list of the union of the 2
    {
        ArrayList<Integer> result = new ArrayList<>(); //intizalizes unioned arraylist
        
        int sizeA = setA.size();
        int sizeB = setB.size();
        boolean inArray = false; //used to check if element in set B is already in result
        
        for(int i=0;i < sizeA;i++) //loops through set A and adds all its values to result
        {                          //assumes all elements in set A are unique
            result.add(setA.get(i));
        }
        
        for(int i = 0;i < sizeB;i++) //loops through set B to add all element of it not already in result to result
        {
            for(int j=0; j < result.size();j++) //loops through result to see if element at i in set B is already in result
            {
                if(setB.get(i) == result.get(j))//if element is already in result sets inArray to true
                {
                    inArray = true;
                }
            }
            
            if(inArray == false) //if the element is not already in result 
            {
                result.add(setB.get(i)); //adds that element to result
            }
            
            inArray = false; //resets inArray to false for start of next loop  
        }
        
        return result; //returns unioned arraylist
    }
    
    
    public ArrayList<Integer> intersect(ArrayList<Integer> setA,ArrayList<Integer> setB)//inputs arraylist sets A and B and returns arraylist of intersection A and B
    {
        ArrayList<Integer> result = new ArrayList<>(); //initalizes intersectioned arraylist
     
        boolean inArray = false;
        //boolean inResultArray = false;
        
        for(int i = 0;i < setA.size();i++) //loops through all values of set A to see if it is also in Set B
        {
            for(int j=0; j < setB.size();j++) //loops through set B to check if element at i is in B 
            {
                if(setA.get(i) == setB.get(j)) // if it is in both A and be in Array is set to true
                {
                    inArray = true;
                }
            }
            
            if(inArray == true)//if element in A is also in B
            {
               // for(int j=0; j < result.size();j++)
               // {
               //     if(setA.get(i) == result.get(j))  //all commented out code was to check if the value in both A and B was already in result
               //     {                                 //but realized all elements in a set are unique so this isn't needed
               //         inResultArray = true;
               //     } 
               // }
            
               // if(inResultArray == false)
               // {
                    result.add(setA.get(i)); //add element to result
               // }
 
               // inResultArray = false;     
            }
            
            inArray = false; //resets inArray to false for start of next loop          
        }
        
        return result; //returns intersected arraylist
    }
    
    
    public ArrayList<Integer> complement(ArrayList<Integer> fullset,ArrayList<Integer> setA) //inputs arraylists of the complete set and a set A, and returns complement of A
    {
        ArrayList<Integer> result = new ArrayList<>(); //initalizes complement set
        
        for(int i = 0;i < fullset.size();i++) // loops through fullset and copies it to result
        {
            result.add(fullset.get(i));
        }
        
        for(int i = 0;i < setA.size();i++) // loops through set A to compare elements in A to result
        {        
            for(int j = 0;j < result.size();j++) //loops through result
            {
                if(setA.get(i) == result.get(j)) //if element in A is in result(complete set has all elements so it will always remove an element)
                {
                    result.remove(j); //removes element from result
                }
            }
        }
           
        return result; //returns complement arraylist
    }
    
    
    public static double variance(int[] values) //inputs list of values and returns the variance
    {
        ArrayList<Double> result = new ArrayList<>();
        
        double addUp = 0; //used to get sum of all the values
        double variance = 0;
        
        
        for(int i = 0;i< values.length;i++) //loops through array of values and and makes them doubles and adds them to results
        {   
            double temp = values[i];
            result.add(temp);
        }
        
        for(int i=0;i<result.size();i++)//loops through values
        {
            result.set(i,result.get(i) - mean(values));//changes value to value - mean            
            result.set(i,result.get(i)*result.get(i)); //changes the values again by squaring it           
        }
        
        for(int i=0;i<result.size();i++) //loops through the values to get a sum of all the values
        {
            addUp = addUp + result.get(i);
            
        }
        
        variance = addUp / (values.length - 1); //divides the sum of the values by the amount - 1
        
        return variance;
    }
    
    public static double standardDeviation(int[] values)//inputs an array of values and returns its standard deviation
    {
        return Math.sqrt(variance(values)); //returns the square root of the variance
    }
    
    public static BigInteger permutation(int n,int r)//inputs n and r and returns the permutaion n r
    {
        BigInteger perm = factorial(n); //sets perm to n!
        perm = perm.divide(factorial(n-r)); //sets perm to n!/(n-r)!
        
        return perm;
    }
    
    public static BigInteger combination(int n,int r)//inputs n and r and returns the combination n r
    {
        BigInteger comb = factorial(n); //sets comb to n!        
        BigInteger rFactorial = factorial(r); //sets r factorial to r!
        
        BigInteger denom = rFactorial.multiply(factorial(n-r)); //sets denom to r!(n-r)!
        comb = comb.divide(denom); //sets comb to n! / r!(n-r)!
        
        return comb;
    }
    
    public static BigDecimal binomialDistribution(int y,int n,double p) //inputs y n and p and returns the pmf for binomial distribution
    {   
        double q = 1 - p; //q is equel to 1 - p
       
        BigDecimal comb = new BigDecimal(combination(n,y)); //creates a big decimal for nCy
        
        BigDecimal pPOWy = new BigDecimal(Math.pow(p,y)); //creates a big decimal for p^y
        
        BigDecimal qPOWny = new BigDecimal(Math.pow(q,n-y)); //creates a big decimal for q^(n-y)
        
        BigDecimal pmf = comb.multiply(pPOWy); // nCy * p^y
        
        pmf = pmf.multiply(qPOWny); // (nCy * p^y) * q^(n-y)
        
        return pmf;
        
    }
    
    public static double binomialExpectedMean(int n, double p)//inputs n and p and returns binomial expected mean
    {
        return n*p;
        
    }
    
    public static double binomialExpectedVariance(int n, double p)//inputs n and p and returns binomial expected variance
    {
        return n*p*(1-p);
        
    }
    
    public static BigDecimal geometricDistribution(int y, double p) //inputs p and y and returns the pmf for geometric distribution
    {
        double q = 1 - p; //q is equel to 1 - p
        
        BigDecimal qPOWy1 = new BigDecimal(Math.pow(q,y-1)); //sets qPOWy1 to q^(y-1)
        
        BigDecimal bigDecP = new BigDecimal(p);//sets p as a big decimal
        
        BigDecimal pmf = qPOWy1.multiply(bigDecP); //multipies q^(y-1) and p
        
        return pmf;
        
    }
    
    public static double geometricOnOrBeforeN(int n, double p)// inputs n, p and returns success on or before nth trial
    {
        return 1 - (Math.pow(1-p, n)); // 1 - (1-P)^n
    }
    
    
    public static double geometricBeforeN(int n, double p)// inputs n, p and returns success before nth trial
    {
        return 1 - (Math.pow(1-p, n - 1)); // 1 - (1-P)^n-1
    }
    
    
    public static double geometricOnOrAfterN(int n, double p)// inputs n, p and returns success on or after nth trial
    {
        return Math.pow(1-p, n -1);  //(1-P)^n-1
    }
    
    
    public static double geometricAfterN(int n, double p)// inputs n, p and returns success after nth trial
    {
        return Math.pow(1-p, n);  //(1-P)^n
    }
    
    
    public static double geometricExpectedMean(double p) //inputs p and returns geometric expected mean
    {
        return 1/p;
        
    }
    
    public static double geometricExpectedVariance(double p) //inputs p and returns geometric expected variance
    {
        return (1-p)/ (Math.pow(p,2));
        
    }
    
    
    public static BigDecimal hyperGeometricDistribution(int y,int r,int N,int n) //inputs y, r, n, N and returns the pmf for hypergeometric distribution
    {
        BigInteger rComby = combination(r,y); // rCy
        
        BigInteger NrCombny = combination(N-r,n-y); // N-rCn-y
                
        BigDecimal NCombn = new BigDecimal(combination(N,n)); // NCn
                
        BigDecimal pmf = new BigDecimal(rComby.multiply(NrCombny)); //rCy x N-rCn-y
        
        pmf = pmf.divide(NCombn); //(rCy x N-rCn-y) / NCn
        
        return pmf;
    }
    
    
    public static double hyperGeometricExpectedMean(int r,int n,int N) // inputs n, r, N and returns hypergeometric expected mean 
    {
        return (n*r) / N;
    }
   
    
    public static double hyperGeometricExpectedVariance(int r,int n,int N)// inputs n, r, N and returns hypergeometric expected variance
    {
        return n * (r/N) * ((N-r)/N) * ((N-n)/(N-1));
    }
    
    
    public static BigDecimal poissonDistribution(int y,int k,int n) //inputs y, k, n and returns poisson Distribution
    {
        double lambda = poissonExpectedMeanAndVar(k,n); //lambda = k/n
        
        BigDecimal lambdaPowy = new BigDecimal(Math.pow(lambda, y)); // lambda^y
        
        BigDecimal yFactorial = new BigDecimal(factorial(y)); // y!
        
        BigDecimal ePowLambda = new BigDecimal(Math.exp((0-lambda))); //e^-lambda
        
        
        BigDecimal poisson = lambdaPowy.divide(yFactorial); //lambda^y / y!
        
        poisson = poisson.multiply(ePowLambda); // (lambda^y / y!) * (e^-lambda)
        
        return poisson; 
    }
    
    
    public static double poissonExpectedMeanAndVar(int k, int n) // inputs k, n and returns lambda, which is also expected mean and expected variance
    {
        return k/n;
    }
    
    
    public static double tchebtsheffThm(int k) // inputs k and returns tchebtsheff thm
    {
        return 1 - ( 1/ Math.pow(k,2)); // 1 - (1/k^2)
    }
    
    
 
    
    
}
