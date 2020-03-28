/*
 * A non-empty array A consisting of N integers is given. The array contains an odd 
 * number of elements, and each element of the array can be paired with another 
 * element that has the same value, except for one element that is left unpaired.
 * 
 * For example, in array A such that:
 * 
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers fulfilling the above conditions, 
 * returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */

import java.util.HashMap;
import java.util.Map;

/*
 * Score: 100%
 */
class Solution {
    public int solution(int[] A) {
        /*
         * Use a HashMap to store the count of each value.
         */
        Map<Integer, Integer> valueCount = new HashMap<>();

        /*
         * Iteratre through each number in the array.
         * Store each number as the key and increment its count (value).
         * If the number is not in the HashMap, add it with count 1.
         */
        for(int number : A) {
            valueCount.put(number, valueCount.getOrDefault(number, 0) + 1);
        }

        /*
         * Iterate through the HashMap and check each key's value.
         * If the key is odd, then it's the odd occurrence.
         * Return the key.
         */
        for(Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        /*
         * Program shouldn't reach this point. 
         */
        return 0;
    }
}
