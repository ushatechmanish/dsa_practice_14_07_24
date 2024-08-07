package in.ushatech.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.comparator.Comparators;

@SpringBootApplication
public class DsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsaApplication.class, args);
		System.out.println("removeDuplicates" + removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(maxProduct(new int[] { 10, 20, 30, 40, 50 }));
	}

	public static int[] middle(int[] input) {
		if (input == null || input.length <= 2) {
			return new int[] {};
		}
		int[] result = new int[input.length - 2];
		for (int i = 0; i < input.length; ++i) {
			if (i == 0 || i == input.length - 1) {
				continue;
			}
			result[i - 1] = input[i];
		}
		return result;
	}

	public static int sumDiagonalElements(int[][] array) {
		// Edge case
		if (array == null) {
			return Integer.MIN_VALUE;
		}
	
		int len = array.length;
		if (len == 0) {
			return Integer.MIN_VALUE;
		}
	
		int sum = 0;
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				if (i == j || (i + j) == (len - 1)) {
					sum += array[i][j];
				}
			}
		}
		return sum;
	}
	

	public static int[] findTopTwoScores(int[] array) {
		if (array == null || array.length <= 1) {
			return new int[] {};
		}

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int num : array) {
			if (num > max1) {
				max2 = max1;
				max1 = num;
				continue;
			}

			if (num > max2) {
				max2 = num;
			}
		}

		return new int[] { max1, max2 };
	}

	static int findMissingNumberInArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		long sum = 0L;

		for (int num : arr) {
			sum += num;
		}
		int n = arr.length + 1;

		long sumFrom1ToN = (long) ((n) * (n + 1) / 2);

		return (int) (sumFrom1ToN - sum);
	}

	public static int removeDuplicates(int[] nums) {
		// System.out.println(Arrays.toString(nums));
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}

		// int uniqueCount=0; This is wrong as the iteration is starting from 2nd number
		// Dry run was not done for the algorithm
		int uniqueCount = 1;
		int prevNumber = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == prevNumber) {
				continue;
			}
			prevNumber = nums[i];
			++uniqueCount;
		}

		return uniqueCount;
	}

	public static int maxProfit(int[] prices) // [7, 1, 5, 3, 6, 4]
	{
		int currentProfit = 0; // 2
		int maxProfit = 0; // 4
		int currentMin = prices[0]; // 1

		for (int i = 1; i < prices.length; ++i) // i=3
		{
			int price = prices[i]; // 3
			if (price > currentMin) // profit exists // 3>1 true
			{
				currentProfit = price - currentMin; // 3-1=2
				if (currentProfit > maxProfit) // false
				{
					maxProfit = currentProfit;
					continue;
				}
			}

			if (price < currentMin) // 1<7 false
			{
				currentMin = price;
			}

		}

		return maxProfit;

	}

	public  static int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return new int[] { -1, -1 };

		for (int i = 0; i < nums.length; ++i) {
			int current = nums[i];
			int required = target - current;
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[j] == required)
					return new int[] { i, j };
			}
		}
		return new int[] { -1, -1 };
	}

	public  static int searchInArray(int[] intArray, int valueToSearch) {
		for (int i = 0; i < intArray.length; ++i) {
			if (intArray[i] == valueToSearch)
				return i;
		}
		return -1;
	}

	public static String maxProduct(int[] intArray) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int num : intArray) {
			if (num > max1) {
				max2 = max1;
				max1 = num;
				continue;
			}
			if (num > max2) {
				max2 = num;
			}
		}

		// return String.format("({},{})",max2,max1); // wrong syntax
		// It doesn't return correct expected:<[60,50]> but was:<[({},{})]>
		// correct options are given below
		String result = String.format("%d,%d", max1,max2);
		// String result = """
		// 		%d,%d
		// 		""".formatted(max1, max2);
		return result;

	}

	public static boolean isUnique(int[] intArray) {
		return Arrays.stream(intArray).distinct().count() == intArray.length;
	}

	public static boolean permutation(int[] array1, int[] array2)
    {
		Map<Integer, Long> map = Arrays.stream(array1).boxed().collect(Collectors.groupingBy(i->{return i;}, Collectors.counting()));
		for(int num : array2)
		{
			if(map.containsKey(num))
			{
				map.put(num,map.get(num)-1);
				if(map.get(num)==0)
				{
					map.remove(num);
				}
			}
		}
		return map.isEmpty();
    }
	public static void rotateMatrix(int[][] matrix) {
        
        // To roate a matrix , first transpose the matrix and then reverse the rows . 
        
        // Transpose the matrix
        for(int row=0 ; row< matrix.length; ++row)
        {
            for(int col=row ; col< matrix.length; ++col) // important col should start from row to avoid transposing the elements again for row!=col
            {
                int temp = matrix[row][col];
                matrix[row][col]= matrix[col][row];
                matrix[col][row]= temp;
            }
        }
        
        // reverse the row
        for(int row=0 ; row< matrix.length; ++row)
        {
            for(int col=0 ; col< matrix.length/2 ; ++col)
            {
                int temp = matrix[row][col];
                matrix[row][col]= matrix[row][matrix.length-col-1];
                matrix[row][matrix.length-col-1]= temp;
            }
        }
        
    }


}
