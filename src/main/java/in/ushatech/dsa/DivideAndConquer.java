package in.ushatech.dsa;

public class DivideAndConquer {
    
    // 59 https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5215758#overview
    public static int countZeroes(int[] array) {
        return helperCountZeroes(array,0);
      }
      static int helperCountZeroes(int[] array, int position)
      {
          if(position==array.length) return 0 ;
          
          if(array[position]==0) 
          {
              return 1+ helperCountZeroes(array,position+1);
          }
          return helperCountZeroes(array,position+1);
      }
}
