package in.ushatech.dsa;

import java.util.HashMap;
import java.util.Map;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5196026#overview
public class NumberFactor 
{
    // Top Down approach
	public int waysToGetNTopDown(int n) 
	{
	    //  terminal case or known cases
	    if(n<=0) return 0;
	    if(n==1|| n==3)
	    {
	        return 1;
	    }
	    if(n==4)
	    {
	        return 4;
	    }
	    
	    int way1 = waysToGetNTopDown(n-1);
	    int way3 = waysToGetNTopDown(n-3);
	    int way4 = waysToGetNTopDown(n-4);
	    
	    return way1+way3+way4;
	}

    public int waysToGetNTopDownWithDP(int n) 
	{
	    Map<Integer,Integer> dp = new HashMap();
	    // add terminal cases 
	    dp.put(1,1);
	    dp.put(3,1);
	    dp.put(4,4);
	    return helper(n,dp);
	    
	}
	private int helper(int n , Map<Integer,Integer> dp)
	{
	    //  terminal case or known cases
	    
	    if(n<=0) return 0;
	    
	    if(dp.containsKey(n))
	    {
	        return dp.get(n);
	    }
	    
	    int way1 = helper(n-1,dp);
	    int way3 = helper(n-3,dp);
	    int way4 = helper(n-4,dp);
	    
	    int totalNoOfWays = way1+way3+way4;
	    dp.put(n,totalNoOfWays);
	    return totalNoOfWays;
	}
}