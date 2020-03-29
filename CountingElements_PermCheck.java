/*
 * A non-empty array A consisting of N integers is given.
 * 
 * A permutation is a sequence containing each element from 1 to N once, and 
 * only once.
 * 
 * For example, array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 * 
 * The goal is to check whether array A is a permutation.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * 
 * For example, given array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 * 
 * Given array A such that:
 * 
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */

/*
 * Score: 100%
 */
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
        /*
         * Use a HashSet to track values since look up time is O(1) and
         * duplicates will not be stored.
         */
        Set<Integer> numbers = new HashSet<>();

        /*
         * Populate the HashSet with values from the input array.
         */
        for(int number : A) {
            numbers.add(number);
        }

        /*
         * Iterate through the number of indexes and check if that
         * index exists in the HashSet. If not, then the array is not
         * a permutation.
         */
        for(int index = 1; index <= A.length; index++) {
            /*
             * If index is not contained in the set, then it is not a perm.
             */
            if(!numbers.contains(index)) {
                return 0;
            }
        }

        /*
         * All indices found in HashSet, set is a permutation.
         */
        return 1;

    }
}
