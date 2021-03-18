import java.util.ArrayList;
import java.util.List;

// A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

// Use an array of length 26 to store the last occurance of letter
// Use a variable start to record the start of a partition, end is the end of partition
// Iterate each index of that string, update the last occurance of the end character. 
// If i == end, we found a partition, record distance and update start to end + 1
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        List<Integer> r = new Solution().partitionLabels("ababcbacadefegdehijhklij");
        for(Integer n : r) {
            System.out.print(n + " ");
        }
    }
    public List<Integer> partitionLabels(String S) {
        int [] lastOcc = new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastOcc[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int lastIdx = 0;
        List<Integer> res = new ArrayList();
        for(int i = 0; i < S.length(); i++) {
            lastIdx = Math.max(lastIdx, lastOcc[S.charAt(i) - 'a']);
            if(i == lastIdx) {
                res.add(lastIdx - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}