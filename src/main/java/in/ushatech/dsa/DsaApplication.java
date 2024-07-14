package in.ushatech.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
