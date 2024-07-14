package in.ushatech.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.comparator.Comparators;

@SpringBootApplication
public class DsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsaApplication.class, args);
	}

	public static int[] middle(int[] input)
    {
		if(input==null || input.length<=2)
		{
			return new int[]{};
		}
        int[] result = new int[input.length-2];
        for(int i=0 ; i< input.length; ++i)
        {
            if(i==0 || i== input.length-1)
            {
                continue;
            }
            result[i-1]=input[i];
        }
        return result;
    }
	public static int sumDiagonalElements(int[][] array) 
      {
         //edge case
         if(array==null)
         {
             return Integer.MIN_VALUE;
         }
         
         int len = array.length;
         if(len==0)
         {
			return Integer.MIN_VALUE;
         }
         int sum =0 ; 
         for(int i=0 ; i< len ; ++i)
         {
             for(int j=0 ; j< array[i].length ; ++j)
             {
                 if(i==j || (i+j-1)==len)
                 {
                     sum+=array[i][j];
                 }
             }
         }
        return sum;
    }
	public static int[] findTopTwoScores(int[] array)
	{
	  if(array==null || array.length<=1)
	  {
		  return new int[]{};
	  }
	  
	  int max1=Integer.MIN_VALUE;
	  int max2=Integer.MIN_VALUE;
	  
	  for(int num : array)
	  {
		  if(num>max1)
		  {
			  max2=max1;
			  max1=num;
			  continue;
		  }
		  
		  if(num>max2)
		  {
			  max2=num;
		  }
	  }
	  
	  return new int[]{max1,max2};
	}
  
	static int findMissingNumberInArray(int[] arr) 
   {
       if(arr==null || arr.length==0)
       {
           return Integer.MIN_VALUE;
       }
        long sum=0L;

        for(int num : arr)
        {
            sum+=num;
        }
        int n = arr.length+1;
        
        long sumFrom1ToN = (long)((n)*(n+1)/2);
        
        return (int)(sumFrom1ToN- sum);
  }
    
    
    
  }
}
