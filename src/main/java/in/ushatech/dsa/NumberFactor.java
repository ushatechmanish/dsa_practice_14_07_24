package in.ushatech.dsa;

import java.util.HashMap;
import java.util.Map;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5196026#overview
// TODO test pending
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

    public int waysToGetNBottomUp(int n) 
  {
      int[] dp = new int[n+1];
      // if max number of elements is already known , an array can be prepared which can serve for all further requests
      // Important thing to note the bound of the value calulated . May have to change int to long if required 
        return helperWaysToGetNBottomUp(n,dp);    // 	  TODO
    }

    private int helperWaysToGetNBottomUp(int n , int[] dp)
    {
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=4;
        
        for(int i=5;i<=n;++i)
        {
            dp[n]=dp[n-1]+dp[n-3]+dp[n-4];
        }
        return dp[n];
    }
}