// Reverse everything in parenthesis. The string inside of inner parenthesis should be reversed first
// Ex.
// abc(def) -> abcfed
// (abc(def)) -> (abcfed) -> defcba
// (((abc))) -> ((cba)) -> (abc) -> cba

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().reverseInParenthesis("(ab(cd(ef)))"));
    }
    // Use an index to iterate the string from index 0
    // If the current character is alpha-numeric or (, add it to stack
    // Else if it's a ), start poping from the stack until stack is empty or pop out an (
    // When poping out characters, use an empty string to add new char to the front
    // If poping out a ( , concatenate the temp + res, reverse whole string and break the inner while loop
    // Finally, if index reaches the end but stack is not empty, there are chars that no need to reverse
    // add them to the head of res string
    public String reverseInParenthesis(String s) {
        int i = 0;
        Deque<Character> stack = new LinkedList();
        String res = "";
        while(i < s.length()) {
            if(s.charAt(i) != ')') {
                stack.offerLast(s.charAt(i));
            }
            else {
                String temp = "";
                while(!stack.isEmpty()) {
                    Character cur = stack.pollLast();
                    if(cur != '(') {
                        temp = cur + temp;
                    }
                    else {
                        res = temp + res;
                        StringBuilder sb = new StringBuilder(res);
                        res = sb.reverse().toString();
                        break;
                    }
                }
            }
            i++;
        }

        while(!stack.isEmpty()) {
            res = stack.pollLast() + res;
        }
        return res;
    }
}
