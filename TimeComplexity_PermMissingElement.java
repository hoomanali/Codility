/*
 * An array A consisting of N different integers is given. The array contains 
 * integers in the range [1..(N + 1)], which means that exactly 
 * one element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
*/
class Solution {
    public int solution(int[] A) {
        /*
         * Use long integers to avoid overflow errors with large N.
         */
        long lastNumber = A.length + 1;

        /*
         * Find what the complete sum of N+1 numbers should be.
         * This requires finding the sum of the infinite series of natural numbers.
         * NaturalNumbers = {N | N == 1, 2, 3, ..., +Infinite}
         * The sum of the first N natural numbers = [N * (N + 1)] / 2
         */
        long completeSum = (lastNumber * (lastNumber + 1))/2;

        /*
         * Subtract each number in the given array from the sum of what the
         * complete array should be. The difference is the missing number.
         */
        for(long number : A) {
            completeSum -= number;
        }

        /*
         * The remaining value in completeSum is the missing number.
         */
        return (int)completeSum;
    }
}
