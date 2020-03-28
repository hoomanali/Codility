// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        /*
         * Discard any trailing zeros in N.
         * Shift N to the right (unsigned) by the number of trailing zeros.
         * The unsigned shift operator fills the highest order bits with 0.
         */
        N >>>= Integer.numberOfTrailingZeros(N);
        
        /* Size of largest gap. */
        int gap = 0;
        
        /*
         * Fill in the gaps with 1s
         * Count each time a gap's bit is filled in.
         * The maximum number of 1s filled in the largest binary gap.
         */
        while((N & (N + 1)) != 0) {
            N |= N >>> 1;
            gap++;
        }
        return gap;
    }
}
