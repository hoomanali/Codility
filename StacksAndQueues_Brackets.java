/*
 * A string S consisting of N characters is considered to be properly nested if 
 * any of the following conditions is true:
 * 
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly 
 * nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given 
 * S = "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: 
 * "(", "{", "[", "]", "}" and/or ")".
 */

/*
 * Score: 100%
 */
import java.util.Stack;

class Solution {
    public int solution(String S) {
        /*
         * Use final values for 1 and 0 to represent NESTED and NOT_NESTED
         * strings and avoid magic numbers.
         */
        final int NESTED = 1;
        final int NOT_NESTED = 0;

        /*
         * If the string is empty, it's nested.
         */
        if(S.equals("")) {
            return NESTED;
        }

        /*
         * Use a stack to keep track of brackets.
         */
        Stack<Character> brackets = new Stack<>();

        /*
         * Loop through each character in the string.
         *
         * If the current character is a left bracket, push its corresponding
         * right bracket onto the stack.
         *
         * If the stack is not empty and the top element is equal to the current
         * right brack, pop it. This else-if block could be handled more efficiently:
         * if !isEmpty && pop != c, return NOT_NESTED.
         *
         * Else the string is not nested.
         */
        for(char c : S.toCharArray()) {
            if(c == '(') {
                brackets.push(')');
            } else if(c == '[') {
                brackets.push(']');
            } else if(c == '{') {
                brackets.push('}');
            } else if(!brackets.isEmpty() && brackets.peek() == c) {
                brackets.pop();
            } else {
                return NOT_NESTED;
            }
        }

        /*
         * If matching left and right brackets were found, and the stack is now
         * empty, then the string is nested.
         */
        if(brackets.isEmpty()) {
            return NESTED;
        } else {
            return NOT_NESTED;
        }
    }
}
