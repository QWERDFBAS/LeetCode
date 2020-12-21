import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 */
public class LC767 {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int len = S.length();
        if(len < 2) {
            return S;
        }
        StringBuffer sb = new StringBuffer();
        int maxcount = 0;
        for(int i = 0; i < len; i++) {
            count[S.charAt(i) - 'a']++;
            maxcount = Math.max(maxcount, count[S.charAt(i) - 'a']);
        }
        if(maxcount > (len + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });
        for(char i = 'a'; i <= 'z'; i++) {
            if(count[i - 'a'] > 0) {
                queue.offer(i);
            }
        }
        while(queue.size() > 1) {
            Character c1 = queue.poll();
            Character c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int index1 = c1 - 'a', index2 = c2 - 'a';
            count[index1]--;
            count[index2]--;
            if(count[index1] > 0) {
                queue.offer(c1);
            }
            if(count[index2] > 0) {
                queue.offer(c2);
            }
        }
        if(queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        System.out.println(a - b);
    }
}
