import java.util.HashSet;
import java.util.Set;

public class LC316 {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                res.append('a' + i);
            }
        }
        return res.toString();

    }
}
