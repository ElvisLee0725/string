// Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
// Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

// Find the min add to s to make the parentheses valid
// Edge Case: If s is "", return 0
// Variables: openP and closeP to record the number of unused parenthese. 
// Iterate the input string, if cur is an open P, add openP by 1
// Else if cur is a close P, check if the openP is 0? If not, reduce 1 from openP. Else, add 1 to closeP
// Return openP + closeP
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("()))(("));
    }
    public int minAddToMakeValid(String s) {
        int openP = 0;
        int closeP = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '(') {
                openP++;
            }
            else {
                if(openP > 0) {
                    openP--;
                }
                else {
                    closeP++;
                }
            }
        }
        return openP + closeP;
    }
}