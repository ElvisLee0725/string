import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "I love programing and programing";
        String t = "programing and";
        System.out.println(new Solution().findMissingWords(s, t));
    }
    // [I, am, using, HackerRank, to, improve, programming]
    //                                            i
    // [am, HackerRank, to, improve]
    //                               j
    // res: [I, using]
    // Split each word in s and t by space into array of strings
    // Use 2 pointers, i pointing at start of s and j pointing at start of t
    // If the word at 2 pointers are not equal, add to result and move pointer i
    // Else, move both i and j
    // Add all the rest of words in s array to result
    // Return result
    // Time: O(N), Space: O(N+M)
    private List<String> findMissingWords(String s, String t) {
        String [] sArr = s.split(" ");
        String [] tArr = t.split(" ");
        List<String> res = new ArrayList();
        int i = 0;
        int j = 0;
        while(i < sArr.length && j < tArr.length) {
            if(!sArr[i].equals(tArr[j])) {
                res.add(sArr[i]);
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        while(i < sArr.length) {
            res.add(sArr[i]);
            i++;
        }
        return res;
    }
}
