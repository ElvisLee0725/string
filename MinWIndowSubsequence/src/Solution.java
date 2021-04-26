// Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
// If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

// Iterate string S, use j as the pointer to point at T
// While j reaches the end of T, a subsequence is found, find the start of this subsequence and update if it is shorter
// Time: O(n^2), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("abcdebdde", "bde"));
    }
    public String minWindow(String S, String T) {
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == T.charAt(j)) {
                j++;
                if(j == T.length()) {
                    int start = findStart(S, T, i);
                    if(i - start + 1 < minLen) {
                        res = S.substring(start, i+1);
                        minLen = i - start + 1;
                    }
                    j = 0;
                    i = start;
                }
            }
        }
        return res;
    }

    private int findStart(String S, String T, int end) {
        int start = end;
        int matched = T.length();
        while(matched > 0) {
            if(S.charAt(start) == T.charAt(matched - 1)) {
                matched--;
            }
            start--;
        }
        return start + 1;
    }
}