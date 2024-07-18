package in.ushatech.dsa;

import java.util.*;

public class SortingMethods {
    /**
     * the largest value comes up like bubble
     * 
     * @param arr
     * @return int[]
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) // number of loops
        {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; ++j) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * repeatedly increase the length of sorted part of the array
     * 
     * @param arr
     */
    public static void selectionSort(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        // we divide the array in 2 parts one sorted another unsorted
        // we move the smallest element of unsorted element to the beginning of the
        // unsorted
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i; // No need to track min value
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }

    }
    public static void quickSort(int[] arr)
    {
        if(arr==null || arr.length<=1) return ;
        for(int i=0 ; i< arr.length-1 ; ++i) 
        {
            while(arr[i]!=i+1)
            {
                swap(arr,i,arr[i]-1);
            }
        }

    }

    public void insertionSort(int [] arr)
    {
        if(arr==null || arr.length<=1) return ;
        for(int i=1; i<arr.length ; ++i) 
        {
            // find the correct position of current index element in the sorted part i.e 0-(i-1)
            int value = arr[i];
            // int position = Arrays.binarySearch(arr, 0, i-1, value); Here toIndex is exclusive so it will be checked till toIndex-1
            int position = Arrays.binarySearch(arr, 0, i-1, value);
            if(position<0)
            {
                position= -1*position-1;
            }
            moveElementRightBy1(arr, position, i);
            arr[position]=value;
        }
    }
    public void moveElementRightBy1(int[] arr, int startIndex, int endIndex)
    {
        for(int i=endIndex; i>startIndex ; --i) 
        {
            arr[i]= arr[i-1];
        }
    }
    //TODO
    public void bucketSort(int[] arr, int maxValueInInput)
    {

    }

    //TODO
    public void mergeSort(int[] arr)
    {

    }

    //TODO
    public void heapSort(int[] arr)
    {
        
    }
    
    public static void main(String[] args) 
    {
        // int[] input = new int[] { 2, 1, 3 };
        // System.out.println("input: " + Arrays.toString(input));
        // // bubbleSort(input);
        // selectionSort(input);
        // System.out.println("result: " + Arrays.toString(input));

        // int[] quickSortInput = new int[] { 2, 1, 3 };
        // System.out.println("input1: " + Arrays.toString(quickSortInput));
        // quickSort(quickSortInput);
        // System.out.println("result: " + Arrays.toString(quickSortInput));


        int[] insertionSortInput = new int[] { 2, 1, 3 };
        System.out.println("input1: " + Arrays.toString(insertionSortInput));
        quickSort(insertionSortInput);
        System.out.println("result: " + Arrays.toString(insertionSortInput));

    }
}
