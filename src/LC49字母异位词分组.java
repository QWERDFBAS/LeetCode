import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

public class LC49字母异位词分组 {

    @Test
    public void test() {
        String[] strs = {"tea", "eat", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
//            针对当前的String进行排序，使得相同字母的字符串，用相同的顺序存入map
            for (int j = 0; j < str.length(); j++) {
                if (j == 0) {
                    sb.append(str.charAt(j));
                } else {
                    int sblen = sb.length();
                    for (int k = 0; k < sblen; k++) {
                        if (str.charAt(j) < sb.charAt(k)) {
                            sb.insert(k, str.charAt(j));
                            break;
                        } else if(k == sblen - 1) {
                            sb.append(str.charAt(j));
                        }
                    }
                }
            }

//             判断当前的String存不存在map中，根据情况分批存入map

            if (map.containsKey(sb.toString())) {
                List<String> some = map.get(sb.toString());
                some.add(str);
                map.put(sb.toString(), some);
            } else {
                map.put(sb.toString(), new ArrayList<String>() {{
                    add(str);
                }});
            }
        }

//        将map中的值存入res链表
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
