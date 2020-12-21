import jdk.jfr.StackTrace;

import java.util.HashMap;
import java.util.Map;

public class LC03 {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        if(len == 0) {
            return 0;
        } else if(len == 1) {
            return 1;
        }
        int f = 0, m = 0;
        while(f < len) {
            if(map.containsKey(s.charAt(f))) {
                m = map.get(s.charAt(f));
                max = Math.max(f - m, max);
            }
            map.put(s.charAt(f), f);
            f++;
        }
         if(f == len) {
             
         }
        max = Math.max(max, f - m);
        return max;
    }
}
