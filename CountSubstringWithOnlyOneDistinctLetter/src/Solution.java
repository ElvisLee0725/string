// For each consecutive letter, the number of substring is word.length!
// Ex. "aaa" is 3! = 6, "aaaa" is 4! = 10
// Use 2 pointers for the start and end of a substring with the same letter. Calculate the permutation sum
// Return the permutation sum at the end
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countLetters("aaaba"));
    }
    public int countLetters(String S) {
        int i = 0;
        int j;
        int count = 0;
        while(i < S.length()) {
            j = i;
            while(j < S.length() - 1 && S.charAt(j+1) == S.charAt(i)) {
                j++;
            }
            count += factorial(j - i + 1);
            i = j + 1;
        }
        return count;
    }

    private int factorial(int len) {
        if(len == 1) {
            return 1;
        }

        return len + factorial(len - 1);
    }
}
