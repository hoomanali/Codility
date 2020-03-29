/*
 * You are given N counters, initially set to 0, and you have two possible 
 * operations on them:
 * 
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents 
 * consecutive operations:
 * 
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * 
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * 
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int N, int[] A); }
 * 
 * that, given an integer N and a non-empty array A consisting of M integers, 
 * returns a sequence of integers representing the values of the counters.
 * 
 * Result array should be returned as an array of integers.
 * 
 * For example, given:
 * 
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
/*
 * Score: 100%
 */
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] A) {
        /*
         * Create an array of N counters, each index is the counter number and
         * the value at that index is the counter's current count.
         */
        int[] counters = new int[N];

        /*
         * Java compilers will initialize int values to 0, but just in case...
         */
        Arrays.fill(counters, 0);

        /*
         * The minimum starting count for each counter. Initially 0, but this is
         * increased to maxCount whenever a maxCounters operation occurs.
         * maxCount is the current maximum counter value.
         */
        int startCount = 0;
        int maxCount = 0;
        
        /*
         * Loop through every operation in array A, if operation < N, then increment
         * counter (operation - 1).
         *
         * If the operation is greater than the range of counters, set the starting
         * count to the current maximum.
         *
         * If the counter being incremented hasn't been increased to the maximum
         * count, increase it then increment it.
         *
         * If the operation is within the range of counters, increment the counter.
         */
        for(int operation : A) {
            /*
             * Counters defined from input start at 1, the counters array starts
             * at 0. Decrement operation to get counter index.
             */
            int counter = operation - 1;
            
            if(operation > N) {
                startCount = maxCount;
            } else if(counters[counter] < startCount) {
                counters[counter] = startCount + 1;
            } else {
                counters[counter]++;
            }
            
            /*
             * If the operation is within the range of counters and the current
             * counter's value is greater than the current maximum, set the current
             * maximum to the counter's value.
             */
            if(operation <= N && counters[counter] > maxCount) {
                maxCount = counters[counter];
            }
        }
        
        /*
         * Some of the counters may be behind the current startCount, check the
         * array for these counters and increase them to the startCount.
         */
        for(int counter = 0; counter < counters.length; counter++) {
            if(counters[counter] < startCount) {
                counters[counter] = startCount;
            }
        }
        
        /*
         * Return the counters array.
         */
        return counters;
    }
}
