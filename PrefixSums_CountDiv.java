/*
 * Write a function:
 * 
 * class Solution { public int solution(int A, int B, int K); }
 * 
 * that, given three integers A, B and K, returns the number of integers within 
 * the range [A..B] that are divisible by K, i.e.:
 * 
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * 
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, 
 * because there are three numbers divisible by 2 within the range [6..11], 
 * namely 6, 8 and 10.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
*/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/* 
 * Score: 100%
 */

class Solution {
    public int solution(int A, int B, int K) {
        /*
         * If A is divisible by K, add 1. Otherwise compute difference.
         *
         * There are a total of A/K integers divisible by K in A.
         * There are a total of B/K integers divisible by K in B.
         *
         * Number of integers divisible by K between A an B is the difference
         * of their totals, (B/K) - (A/K).
         */
        if(A % K == 0) {
            return (B / K) - (A / K) + 1;
        } else {
            return (B / K) - (A / K);
        }
    }
}
