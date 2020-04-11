/*
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), 
 * such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice 
 * contains at least two elements). The average of a slice (P, Q) is the sum 
 * of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, 
 * the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the starting 
 * position of the slice with the minimal average. If there is more than one slice 
 * with a minimal average, you should return the smallest starting position of 
 * such a slice.
 * 
 * For example, given array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
*/
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
 * Score: 100%
 */

class Solution {
    public int solution(int[] A) {
        /*
         * minimumAverage is the absolute minimum found amongst slices.
         * minimumIndex is the starting index of the absolute minimum slice.
         */ 
        float minimumAverage = Integer.MAX_VALUE;
        int minimumIndex = 0;

        /* 
         * Track the index outside of the while loop to account for the case
         * in which index == A.length - A, to avoid index out of bounds error.
         */
        int index = 0;

        /*
         * While index < A.length - 2, this is because (index + 2) will be used,
         * which would lead to an array out of bounds error if index == A.length - 1.
         */
        while(index < A.length - 2) {
            /*
             * Get the average of a slice of 2 and a slice of 3,
             * larger slices will produce larger sums and therefore averages,
             * Cast result to floating point in case division has remainder.
             */
            float avgOfTwo = (float)(A[index] + A[index + 1]) / 2;
            float avgOfThree = (float)(A[index] + A[index + 1] + A[index + 2]) / 3;

            /* Get the minimum of the two averages. */
            float currentMinAverage = Math.min(avgOfTwo, avgOfThree);

            /*
             * Set the new minimum if the local current minimum is less.
             * Keep track of the new minimum index.
             */
            if(currentMinAverage < minimumAverage) {
                minimumAverage = currentMinAverage;
                minimumIndex = index;
            }

            index++;
        }

        /*
         * The while loops above stops before index == A.length - 1.
         * Calculate the case for index == A.length - 1 since this last slice
         * is just a pair of 2 integers.
         */
        int avgOfTwo = (A[index] + A[index + 1]) / 2;
        if(avgOfTwo < minimumAverage) {
            minimumAverage = avgOfTwo;
            minimumIndex = index;
        }

        /* Return the start index of the minimum slice. */
        return minimumIndex;
    }
}
