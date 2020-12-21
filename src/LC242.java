import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC242 {

    @Test
    public void test() {
        String s = "a";
        String t = "garam";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int lens = s.length();
        int lent = t.length();
        if(lens != lent) {
            return false;
        }
        for(int i = 0; i < lens; i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < lent; i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> map : map1.entrySet()) {
            Character k = map.getKey();
            int v = map.getValue();
//            需要判断如果map2不存在元素怎么办,当前遍历的map数量小
            if(!map2.containsKey(k)) {
                return false;
            } else if(v != map2.get(k)) {
                return false;
            }
        }
        return true;
    }

}
