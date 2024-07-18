package in.ushatech.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgorithm 
{
    public static void main(String[] args) {
        coinChangeProblem(new int[]{1,2,5,10,20,50,100,1000}, 2035);
    }
    static void activitySelection(ArrayList<Activity> activityList)
    {
        Collections.sort(activityList,Comparator.comparing(Activity::finishTime));
        Activity prev = activityList.get(0);
        System.out.println(activityList.get(0));
        for(int i=1; i<activityList.size(); ++i)
        {
            if(activityList.get(i).startTime() > prev.finishTime())
            {
                prev=activityList.get(i);
                System.out.println(prev);
            }
        }
    }

    static void coinChangeProblem(int[] coins, int N)
    {
        Arrays.sort(coins);
        int required =N;
        // Infinite Supply of denomination [1,2,5,10,20,50,100,1000]
        int lastIndex=coins.length-1;
        while (lastIndex>=0 && required!=0) 
        {
            int lastValue= coins[lastIndex];
            while (lastValue<=required) 
            {
                System.out.println(lastValue);
                required-=lastValue;   
            }
            --lastIndex;
        }
        
    }
}
record Activity(String name, int startTime, int finishTime){}
