/**
 * Simple implementation of cylic sort that involves only integers 0-n-1.
 */

 public class CyclicSort {
    // Infinite loop when there are duplicates
    public static void sort(int[] arr) {
        int start = 0;
        while (start < arr.length) {
            int curr = arr[start];
            if (curr != start) {
                int tmp = arr[curr];
                arr[curr] = arr[start];
                arr[start] = tmp;
            } else {
                start += 1;
            }
        }
    }

    // Algorithm can be easily adapted to find the missing non-negative number
    public static int findMissing(int[] arr) {
        int start = 0;
        while (start < arr.length) {
            int curr = arr[start];
            if (curr >= 0 && curr < arr.length && curr != start) {
                if (arr[curr] == curr) { // ignore duplicates of <curr>
                    start += 1;
                    continue;
                }
                int tmp = arr[curr];
                arr[curr] = arr[start];
                arr[start] = tmp;
            } else {
                start += 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i; // this is the missing non-negative element!
            }
        }
        return arr.length; // first missing non-negative element
    }
 }