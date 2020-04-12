/*
 * An array A consisting of N integers is given. A triplet (P, Q, R) is 
 * triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * 
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns 1 if there exists a 
 * triangular triplet for this array and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * 
 *   A[0] = 10    A[1] = 50    A[2] = 5
 *   A[3] = 1
 * the function should return 0.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the 
 * range [−2,147,483,648..2,147,483,647].
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
        /* If the length of A is less than 3, there are no triangular elements. */
        if(A.length < 3) {
            return 0;
        }

        /* Sort the array. */
        Arrays.sort(A);

        /* Check every triplet and return 1 on the first triangular triplet. */
        for(int index = 0; index < A.length - 2; index++) {
            long p = A[index];
            long q = A[index + 1];
            long r = A[index + 2];

            /* 
             * Since p < q < r,
             * if p + q > r, then q + r > p and r + p > q.
             */ 
            if(p + q > r) {
                return 1;
            }
        }

        /* Did not find a triangular triple, return 0. */
        return 0;
    }
}
