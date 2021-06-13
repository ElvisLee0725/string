// Spliting the given string seq into two sub-sequences A and B, so that:
//
// A and B are both VPS
// the number of "(" of A plus that of B equals to the number of "(" of seq. (sub-sequence, not substring)
// let M=max(depth(A), depth(B)), our job is to find the right A and B to minimize M
// using 0 to denote that the i'th character belongs to A

// Make the depth of A and B balance:
// Use a variable to count current depth, if depth is odd -> A (insert 0), Else go to B (insert 1)
// Iterate the input string, if it's open parenthesis, add depth by 1 and insert either 0 or 1
// Else, insert either 0 or 1 and reduce depth by 1.
// Return the array at the end
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        int [] arr = new Solution().maxDepthAfterSplit("()(())");
        for(int n : arr) {
            System.out.print(n + " ");
        }
    }
    public int[] maxDepthAfterSplit(String seq) {
        int [] res = new int[seq.length()];
        int idx = 0;
        int depth = 0;
        for(int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if(ch == '(') {
                depth++;
                res[idx++] = depth % 2 == 1 ? 0 : 1;
            }
            else {
                res[idx++] = depth % 2 == 1 ? 0 : 1;
                depth--;
            }
        }
        return res;
    }
}
