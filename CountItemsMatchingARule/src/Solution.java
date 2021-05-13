// You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
//
// The ith item is said to match the rule if one of the following is true:
//
// ruleKey == "type" and ruleValue == typei.
// ruleKey == "color" and ruleValue == colori.
// ruleKey == "name" and ruleValue == namei.
// Return the number of items that match the given rule.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Iterate each item in items, check index 0, 1 or 2 depending on the value of ruleKey.
// If the value matches ruleValue, count plut 1
// Return count after the iteration
// Time: O(n), Space: O(1)

class Solution {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("phone","blue","pixel");
        List<String> l2 = Arrays.asList("computer","silver","lenovo");
        List<String> l3 = Arrays.asList("phone","gold","iphone");
        List<List<String>> items = new ArrayList();
        items.add(l1);
        items.add(l2);
        items.add(l3);
        System.out.println(new Solution().countMatches(items, "color", "silver"));
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> item : items) {
            if(ruleKey.equals("type")) {
                if(item.get(0).equals(ruleValue)) {
                    count++;
                }
            }
            else if(ruleKey.equals("color")) {
                if(item.get(1).equals(ruleValue)) {
                    count++;
                }
            }
            else {
                if(item.get(2).equals(ruleValue)) {
                    count++;
                }
            }
        }
        return count;
    }
}