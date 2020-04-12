/*
 * Write a function
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns the number of 
 * distinct values in array A.
 * 
 * For example, given array A consisting of six elements such that:
 * 
 *  A[0] = 2    A[1] = 1    A[2] = 1
 *  A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in 
 * array A, namely 1, 2 and 3.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */


// you can also use imports, for example:
// import java.util.*;
import java.util.List;
import java.util.ArrayList;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
 * Score: 100%
 */
class Solution {
    public int solution(int[] A) {
        /*
         * A list of 0 elements has 0 unique elements and a list of 1
         * element as 1 unique element as is already sorted.
         */
        if(A.length < 1) {
            return 0;
        } else if(A.length == 1) {
            return 1;
        }

        /* Create a sorted array to return and a counter for unique values. */
        int[] sortedArray = sort(A);
        int uniqueValues = 1;

        /*
         * For each element in the sorted array, if the current element is not
         * equal to the previous element, increment the unique value counter.
         */
        for(int index = 1; index < sortedArray.length; index++) {
            if(sortedArray[index] != sortedArray[index - 1]) {
                uniqueValues++;
            }
        }

        /* Return the number of unique values. */
        return uniqueValues;
    }

    /* Recursive merge sort */
    private int[] sort(int[] array) {

        /* Base case, if the array is of size 1, it's sorted, return it. */
        if(array.length <= 1) {
            return array;
        }

        /* Split the array in half and get the size of each half. */
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;

        /* Create each half array. */
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        /* Add the first and second half of elements to its respective array. */
        for(int index = 0; index < leftSize; index++) {
            leftArray[index] = array[index];
        }
        for(int index = 0; index < rightSize; index++) {
            rightArray[index] = array[index + leftSize];
        }

        /* Return the merged an sorted arrays. */
        return merge(sort(leftArray), sort(rightArray));
    }

    /* Merge function for merge sort. */
    private int[] merge(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int[] mergedList = new int[leftSize + rightSize];

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        /* Compare each array's next element and add the least element. 
         * This initial add can be moved into the while loop.
         * I left this here after working on a solution that only adds
         * unique values. */
        if(left[leftIndex] <= right[rightIndex]) {
            mergedList[mergedIndex++] = left[leftIndex++];
        } else {
            mergedList[mergedIndex++] = right[rightIndex++];
        }

        while(leftIndex < leftSize && rightIndex < rightSize) {
            if(left[leftIndex] <= right[rightIndex]) {
                mergedList[mergedIndex++] = left[leftIndex++];
            } else {
                mergedList[mergedIndex++] = right[rightIndex++];
            }
        }

        /* Add the remaining values. */
        while(leftIndex < leftSize) {
            mergedList[mergedIndex++] = left[leftIndex++];

        }
        while(rightIndex < rightSize) {
            mergedList[mergedIndex++] = right[rightIndex++];
        }

        /* Return the merged list. */
        return mergedList;
    }
}
