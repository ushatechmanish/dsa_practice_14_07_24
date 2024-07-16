package in.ushatech.dsa;

public class DivideAndConquer {

    // 59
    // https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5215758#overview
    public static int countZeroes(int[] array) {
        return helperCountZeroes(array, 0);
    }

    static int helperCountZeroes(int[] array, int position) {
        if (position == array.length)
            return 0;

        if (array[position] == 0) {
            return 1 + helperCountZeroes(array, position + 1);
        }
        return helperCountZeroes(array, position + 1);
    }

    // 60
    // https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5228084#overview
    public static int sortedFrequency(int[] arr, int num) {
        int n = arr.length;
        return helperSortedFrequency(arr, num, 0, n);
    }

    private static int helperSortedFrequency(int[] arr, int num, int start, int end) {
        if (arr[start] > num)
            return 0;

        if (end == start) {
            if (arr[start] == num) {
                return 1;
            }
            return 0;

        }
        int mid = (int) (start + (end - start) / 2);
        return helperSortedFrequency(arr, num, start, mid) + helperSortedFrequency(arr, num, mid + 1, end);
    }

    // 61
    // https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5228796#overview
    public static int findRotatedIndex(int[] arr, int num) {
        return helperFindRotatedIndex(arr, num, 0, arr.length);
    }

    static int helperFindRotatedIndex(int[] arr, int num, int start, int end) {
        if (end < start)
            return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == num)
            return mid;

        // else divide the arr in 2 parts
        // out of which atleast one will be definitely sorted
        // we can just check if the num lies in the sorted part or not by comparing the
        // end elements to the num . If it does , we can safely ignore the other part
        // it it does not lie in the sorted part on the other part we further divide in
        // 2 parts

        // Here we are optimizing the search by ignoring the unsorted array if num lies
        // in the sorted part

        if (arr[start] <= arr[mid])/* left sorted */
        {
            if (num >= arr[start] && num <= arr[mid]) {
                // ignore the unsorted part
                // continue searching in the sorted part
                return helperFindRotatedIndex(arr, num, start, mid - 1);
            } else {
                return helperFindRotatedIndex(arr, num, mid + 1, end);
            }
        }

        if (arr[mid + 1] <= arr[end])/* right sorted */
        {
            if (num >= arr[mid + 1] && num <= arr[end]) {
                // ignore the unsorted part
                // continue searching in the sorted part
                return helperFindRotatedIndex(arr, num, mid + 1, end);
            } else {
                return helperFindRotatedIndex(arr, num, start, mid - 1);
            }
        }

        return -1;
    }

}
