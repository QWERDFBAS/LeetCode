import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */

public class LC290WordLow {

    @Test
    public void test() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern1(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] word = s.split(" ");
        int len = pattern.length();
        if(len != word.length) {
            return false;
        }

//        判断当前的模式是什么，如果已经存在判断，已存的字符是否是当前的字符
//        每个字段对应一个模式，需要判断map中是否含有当前的值。
        for(int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word[i])) {
                    return false;
                }
            } else {
                map.put(c, word[i]);
            }
        }

//        判断相同的字符串是否对应相同的key
        List<Character> cl = new ArrayList<>();
        List<String> sl = new ArrayList<>();
        for(Map.Entry<Character, String> entry : map.entrySet()) {
            char c = entry.getKey();
            String str = entry.getValue();
            for(int i = 0; i < sl.size(); i++) {
                if(sl.get(i).equals(str)) {
                    if(cl.get(i) != c) {
                        return false;
                    }
                }
            }
            cl.add(c);
            sl.add(str);
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        Map<String, Character> str2char = new HashMap<>();
        Map<Character, String> char2str = new HashMap<>();
        int len = pattern.length();
        String[] words = s.split(" ");

        if(words.length != len) {
            return false;
        }

        for(int i = 0; i < len; i++) {
            if(str2char.containsKey(words[i]) && str2char.get(words[i]) != pattern.charAt(i)) {
                return false;
            }
            if(char2str.containsKey(pattern.charAt(i)) && !char2str.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
            str2char.put(words[i], pattern.charAt(i));
            char2str.put(pattern.charAt(i), words[i]);
        }
        return true;
    }
}
