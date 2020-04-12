/*
 * A non-empty array A consisting of N integers is given. The product of 
 * triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * 
 * For example, array A such that:
 * 
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * contains the following example triplets:
 * 
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A, returns the value of the maximal product 
 * of any triplet.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
*/

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
 * Score: 100%
 */
class Solution {
    public int solution(int[] A) {
        /*
         * If the array has 3 elements, don't bother sorting or finding
         * a maximum, just return the product of its 3 elements,
         */
        if(A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        /* Sort the array. */
        Arrays.sort(A);

        /* 
         * Get the product of the 3 largest values and the product of the 
         * largest value and the two smallest values in case the two 
         * smallest values are both negative.
         */
        int productOne = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int productTwo = A[0] * A[1] * A[A.length - 1];

        /*
         * Return the max product.
         */
        return Math.max(productOne, productTwo);
    }
}
