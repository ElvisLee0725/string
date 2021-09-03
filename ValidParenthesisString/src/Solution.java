/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

 */

/*
- Case 1: Treat all * as (
    - Iterate from index 0 and count the number of open parenthesis.
        - If the current is * or (, increase the counter
        - Else, decrease it
        - At each point, if the counter is less than 0, we have more ) that can't be matched! return false
- After case 1, if count is 0. That means we have enough for balance, return true
- Case 2: Treat all * as )
    - Iterate from the last index and count the number of close parenthesis
        - If the current is * or ), increase the counter
        - Else, decrease it
        - At each point, if the counter is less than 0, we have more ( that can't be matched! return false
- Return true in the end
Time: O(N), Space: O(1)
*/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("((**)"));
        System.out.println(new Solution().checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
    public boolean checkValidString(String s) {
        int countOpen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                countOpen++;
            }
            else {
                countOpen--;
            }

            if(countOpen < 0) {
                return false;
            }
        }
        if(countOpen == 0) {
            return true;
        }

        int countClose = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ')' || s.charAt(i) == '*') {
                countClose++;
            }
            else {
                countClose--;
            }

            if(countClose < 0) {
                return false;
            }
        }
        return true;
    }
}
