import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 */


public class LC842 {

    List<Integer> list = new ArrayList<>();
    int len;

    @Test
    public void test() {
        String S = "123456579";
        System.out.println(splitIntoFibonacci(S));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        this.len = S.length();
        back(S, 0, 0, 0);
        return list;
    }

//    回溯算法，index是当前进行的下标
    public boolean back(String s, int index, int sum, int prev) {
        if(index == len) {
            return list.size() >= 3;
        }
        long currlong = 0;
        for(int i = index; i < len; i++) {
            if(i > index && s.charAt(index) == '0') {
                break;
            }
            currlong = currlong * 10 + (s.charAt(i) - '0');
            if(currlong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int)currlong;
            if(list.size() >= 2) {
                if(sum > curr) {
                    continue;
                } else if(sum < curr) {
                    break;
                }
            }
            list.add(curr);
            if(back(s, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
