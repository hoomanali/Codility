/*
 * A non-empty array A consisting of N integers is given. The consecutive elements 
 * of array A represent consecutive cars on a road.
 * 
 * Array A contains only 0s and/or 1s:
 * 
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), 
 * where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is 
 * traveling to the west.
 * 
 * For example, consider array A such that:
 * 
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the number of pairs of 
 * passing cars.
 * 
 * The function should return −1 if the number of pairs of passing cars 
 * exceeds 1,000,000,000.
 * 
 * For example, given:
 * 
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following 
 * values: 0, 1.
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
 * Score: 100%
 */

class Solution {
    public int solution(int[] A) {
        /* Some words for readability */
        final int EASTBOUND = 0;
        final int WESTBOUND = 1;
        final int BILLION = 1000000000;

        /* Keep track of cars moving east and cars passed */
        int eastBoundCars = 0;
        int carsPassed = 0;
        
        /* Iterate through every car */
        for(int car = 0; car < A.length; car++) {
            /* If the car is moving east, increment eastbound car count. */
            if(A[car] == EASTBOUND) {
                eastBoundCars++;
            }
            
            /* 
             * If a westbound car is discovered, it will pass all previously
             * discovered eastbound cars, so 
             * carsPassed = carsPassed + eastBoundCars 
             */
            if(A[car] == WESTBOUND) {
                carsPassed += eastBoundCars;
            }
            
            /*
             * Per instructions, if the count goes over 1 billion, end the
             * program (and for() loop) and return -1.
             */
            if(carsPassed > BILLION) {
                return -1;
            }
        }
        
        /* Return total number of cars passed. */
        return carsPassed;
    }
}
