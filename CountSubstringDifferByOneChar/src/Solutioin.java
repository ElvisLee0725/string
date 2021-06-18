// For all substring from s and t, check each position and count the different characters. If the diff is 1, we found a pair
// If the diff reaches 2 or out of range of string s and t, stop and try next substring
// Time: O(mn*Min(m, n)), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aba", "baba"));
    }
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int sPos = i;
                int tPos = j;
                int countDiff = 0;
                System.out.println(s.substring(i, s.length()) + " " + t.substring(j, t.length()));
                while(sPos < m && tPos < n && countDiff < 2) {
                    if(s.charAt(sPos) != t.charAt(tPos)) {
                        countDiff++;
                    }
                    res += countDiff == 1 ? 1 : 0;

                    sPos++;
                    tPos++;
                }
            }
        }
        return res;
    }
}
