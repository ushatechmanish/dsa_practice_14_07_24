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
    // 60 https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5228084#overview
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
}
