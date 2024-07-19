package in.ushatech.dsa.divideandconquer;

public class BinarySearch {

    public int binarySearch(int[] arr, int value) {
        return helperBinarySearch(arr, value, 0, arr.length - 1);
    }

    private int helperBinarySearch(int[] arr, int value, int i, int j) {
        if (j < i)
            return -1 * i - 1;

        int mid = i + (j - i) / 2;
        if (arr[mid] == value)
            return mid;

        else if (arr[mid] < value)
            return helperBinarySearch(arr, value, mid + 1, j);

        else
            return helperBinarySearch(arr, value, i, mid-1);
    }
}
