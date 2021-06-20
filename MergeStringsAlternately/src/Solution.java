// Add letter from word1 and word2 alternately
// The length of word1 and word2 are different
// Use a index to record the current index. As long as it's less than the length of word1 and word2, keep adding one letter from word1 then word2
// Finally, append the rest of letters from either word1 or word2
// Time: O(n + m), Space: O(n + m)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abcd", "pg"));
    }
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < word1.length() && i < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        if(i < word1.length()) {
            sb.append(word1.substring(i, word1.length()));
        }
        else if(i < word2.length()) {
            sb.append(word2.substring(i, word2.length()));
        }

        return sb.toString();
    }
}