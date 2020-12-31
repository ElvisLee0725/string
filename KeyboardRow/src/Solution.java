import java.util.ArrayList;
import java.util.List;
// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

public class Solution {
    public static void main(String[] args) {
        String [] array = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String [] res = new Solution().findWords(array);
        for(String s : res) {
            System.out.print(s + " ");
        }
    }

    public String[] findWords(String[] words) {
        String str1 = "qwertyuiopQWERTYUIOP";
        String str2 = "asdfghjklASDFGHJKL";
        String str3 = "zxcvbnmZXCVBNM";

        List<String> list = new ArrayList();
        for(String word : words) {
            if(isOneRow(str1, word) || isOneRow(str2, word) || isOneRow(str3, word)) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    public boolean isOneRow(String s, String word) {
        for(int i = 0; i < word.length(); i++) {
            if(s.indexOf(word.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
