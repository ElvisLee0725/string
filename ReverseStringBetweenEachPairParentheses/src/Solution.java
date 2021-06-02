// You are given a string s that consists of lower case English letters and brackets.
//
// Reverse the strings in each pair of matching parentheses, starting from the innermost one.
//
// Your result should not contain any brackets.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// Stack:
// Iterate the input string and insert every '(' and letters into the stack
// When current char is ')', pop out from the stack until '(' to form a string -> it is reversed!
// Insert the new string's characters back to stack
// Repeat previous 2 steps until we reach the end of input string
// Finally, convert all letters inside of stack back to a string and return
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(ed(et(oc))el)"));
    }
    public String reverseParentheses(String s) {
        Deque<Character> stack = new LinkedList();
        Queue<Character> q = new LinkedList();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                q.clear();
                while(stack.peekLast() != '(') {
                    q.offer(stack.pollLast());
                }
                stack.pollLast(); // Remove the '('
                while(!q.isEmpty()) {
                    stack.offerLast(q.poll());
                }
            }
            else {
                stack.offerLast(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
