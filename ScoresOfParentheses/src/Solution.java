// Recursion:
// At each level of parentheses, count the total score at that level.
// Case 1: There is no open and cur is open, mark open parenthese to true
// Case 2: There is no open and cur is closing, this means this level is finished, score times 2
// Case 3: Has an open and cur is closing, find a pair () so score plus 1
// Case 4: Has an open and cur is open, need to go next level. Set open to false first.
// Return the scores in the end
class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().scoreOfParentheses("(()(()))"));
    }
    int i = 0;
    public int scoreOfParentheses(String S) {
        int score = 0;
        boolean open = false;
        while(i < S.length()) {
            if(open && S.charAt(i) == ')') {
                // For regular "()", just increase score by 1
                score++;
                open = false;
            }
            else if(!open && S.charAt(i) == '(') {
                // Getting the first '(' at current level
                open = true;
            }
            else if(!open && S.charAt(i) == ')') {
                // When current level is finished, score needs to x 2 and return
                return score * 2;
            }
            else {
                // Here we go to the next level, but since open is true, we need to make it false so after we return, we can have score * 2 if there is a ')'
                open = false;
                score += scoreOfParentheses(S);
            }
            i++;
        }
        return score;
    }
}
