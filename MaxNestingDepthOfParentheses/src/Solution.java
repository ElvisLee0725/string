// A string is a valid parentheses string (denoted VPS) if it meets one of the following:
//It is an empty string "", or a single character not equal to "(" or ")",
//It can be written as AB (A concatenated with B), where A and B are VPS's, or
//It can be written as (A), where A is a VPS.
//We can similarly define the nesting depth depth(S) of any VPS S as follows:
//depth("") = 0
//depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
//depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
//depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
//For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

//Given a VPS represented as string s, return the nesting depth of s.


// Return the max depth of an VPS
// Use variables: max to store the max depth, openP to store the number of open parenthese
// Iterate the input string, if current char is '(', openP plus 1 and update max if openP is greater
// When current char is ')', openP should minus 1 since one depth is resolved
// Return max at the end
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    public int maxDepth(String s) {
        int max = 0;
        int openP = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openP++;
                max = Math.max(max, openP);
            }
            else if(s.charAt(i) == ')') {
                openP--;
            }
        }
        return max;
    }
}