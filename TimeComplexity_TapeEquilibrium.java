/*
 * A non-empty array A consisting of N integers is given. Array A represents numbers 
 * on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty 
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 * The difference between the two parts is the 
 * value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first 
 * part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 * 
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the minimal difference 
 * that can be achieved.
 * 
 * For example, given:
 * 
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
*/
import java.lang.Long;
import java.lang.Math;

/*
 * Score: 100%
 */
class Solution {
    public int solution(int[] A) {
        /*
         * Keep a running total of the left and right sums of the array.
         */
        long leftSum = 0;
        long rightSum = 0;

        /*
         * Initialize minDifference to the maximum value of Long so when the first
         * minimum is found, it will be less than the initialized minimum..
         */
        long minDifference = Long.MAX_VALUE;

        /*
         * Sum the values of A and add them to the right hand sum.
         */
        for(int number : A) {
            rightSum += number;
        }


        /*
         * Loop through each value of the array and subtract that sum from the
         * right hand sum and add it to the left hand sum, then take the difference.
         */
        for(int index = 0; index < A.length - 1; index++) {
            /*
             * Subtract the current index's value from the right hand sum and add
             * it to the left hand sum.
             */
            leftSum += A[index];
            rightSum -= A[index];

            /*
             * Find the absolute value of the difference between the left hand sum
             * and right hand sum.
             */
            long difference = 0;
            difference = Math.abs(leftSum - rightSum);

            /*
             * If the difference is lower than the minimum difference, then it is
             * the new minimum difference.
             */
            if(difference < 0) {
                difference = -difference;
            }
            if(difference < minDifference) {
                minDifference = difference;
            }
        }

        return (int)minDifference;
    }
}
