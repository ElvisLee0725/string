// Use an array of length equals to S, arr[i] represents the index that at indexes, sources and targets the sources[index] matches S's substring(indexes[index], indexes[index] + sources[index].length()). Initialize with -1
// Iterate the array. If the value is not -1, that means there is a match at S's index i! We append the target
// Else, just use the original character from S since there is not a match.
// Time: O(n), Space: O(n)

import java.util.Arrays;

class Solution {;
    public static void main(String[] args) {
        int [] indexes = {0, 2};
        String [] sources = {"a", "cd"};
        String [] targets = {"eee", "ffff"};
        System.out.print(new Solution().findReplaceString("abcd", indexes, sources, targets));
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = S.length();
        int [] arr = new int[n];
        Arrays.fill(arr, -1);

        for(int i = 0; i < indexes.length; i++) {
            if(sources[i].equals(S.substring(indexes[i], indexes[i] + sources[i].length()))) {
                arr[indexes[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != -1) {
                sb.append(targets[arr[i]]);
                i += sources[arr[i]].length();
            }
            else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}