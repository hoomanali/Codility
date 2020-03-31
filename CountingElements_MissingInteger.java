/*
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive 
 * integer (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

/*
 * Score: 100%
 */
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
        /*
         * Use a HashSet to store each number in A. Lookup time is O(1) and
         * the set stores a single instance of each number, no duplicates.
         */
        Set<Integer> numbers = new HashSet<>();

        /* Loop through each number in A and add it to the HashSet. */
        for(int number : A) {
            numbers.add(number);
        }

        /* Start number at 1 since we are only checking psoitive integers. */
        int number = 1;

        /* Keep incrementing number as long as it exists in the HashSet. */
        while(numbers.contains(number)) {
            /*
             * If number equals A's length (N), we have hit the end of the array.
             * A contains the first N natural numbers so increment number to the
             * next natural number and return it.
             */
            if(number == A.length) {
                number++;
                return number;
            }
            number++;
        }

        /* 
         * If the while loop exits and reaches this point, the first natural number
         * has been found, return it.
         */
        return number;
    }
}
