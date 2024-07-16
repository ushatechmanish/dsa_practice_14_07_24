package in.ushatech.dsa;
import java.util.*;
public class HouseRobber {
	public int maxMoneyTopDown(int[] houseNetWorth) 
	{
	    Map<Integer,Integer> dp = new HashMap();
	    int n = houseNetWorth.length;
	   return helperMaxMoneyTopDown(houseNetWorth,n,dp);
	}
	
	private int helperMaxMoneyTopDown(int[] houseNetWorth,int remainingHouses, Map<Integer,Integer> dp )
	{
	    int current=houseNetWorth.length-remainingHouses;
	    // if only one house is there , its worth is the max which can be stolen;
	    if(current>=houseNetWorth.length) return 0;

        if(remainingHouses==1) return houseNetWorth[current];
        
        if(dp.containsKey(remainingHouses))
        {
            return dp.get(remainingHouses);
        }

	    int robCurrent = houseNetWorth[current] + helperMaxMoneyTopDown(houseNetWorth,remainingHouses-2,dp);
	    int leaveCurrent = 0 + helperMaxMoneyTopDown(houseNetWorth,remainingHouses-1,dp);
	    
	    int maxValuePossibleForCurrentPosition= Math.max(robCurrent,leaveCurrent);
	    dp.put(remainingHouses,maxValuePossibleForCurrentPosition);
	    return maxValuePossibleForCurrentPosition;
	    
	}

    public int maxMoneyBottomUp(int[] wealth) 
    {
	    int[] dp = new int[wealth.length];
	    int lastIndex=wealth.length-1;
	    dp[lastIndex]=wealth[lastIndex];
	    dp[lastIndex-1]= Math.max(wealth[lastIndex-1],wealth[lastIndex]);
	    
	    // To simplify the dp code , put the edge cases first 
	    // or take 2 or 3 extra positions in dp to cater for index out of bounds
	    for(int i=lastIndex-2; i>=0; --i)
	    {
	        int robCurrent= wealth[i]+dp[i+2];
	        int leaveCurrent = dp[i+1];
	        dp[i]=Math.max(robCurrent,leaveCurrent);
	    }
	    
	    return dp[0];
	    
	}
}
