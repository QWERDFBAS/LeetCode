import org.junit.Test;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 */

public class LC387_字符串中的第一个唯一字符 {

    @Test
    public void test() {
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        if(len == 0) {
            return -1;
        }
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, len);
            } else {
                map.put(c, i);
            }
        }
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            res = Math.min(entry.getValue(), res);
        }
        return res == len ? -1 : res;
    }
}
