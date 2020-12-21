import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */



public class LC402 {

    int min = Integer.MAX_VALUE;
    StringBuilder res = new StringBuilder();

    @Test
    public void test() {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        int len = num.length();
        for(int i = 0; i < len; i++) {
            char temp = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && stack.peekLast() > temp) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(temp);
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();


    }


    public String removeKdigits1(String num, int k) {
        if(num.length() <= k) {
            return new String("0");
        }
        back(num, k, 0, 0);
        return Integer.toString(min);
    }

    public void back(String num, int k, int count, int index) {
        if(count == k && res.length() == num.length() - k) {
            int len = res.length();
            int temp = 0;
            for(int i = len - 1; i >= 0; i--) {
                temp += (res.charAt(i) - '0') * Math.pow(10, len - i - 1);
            }
            System.out.println(temp);
            min = Math.min(min, temp);
        }

        for(int i = index; i < num.length(); i++) {
            if(k > count) {
                back(num, k, count + 1, i + 1);
            }
            res.append(num.charAt(i));
            back(num, k, count, i + 1);
            res.deleteCharAt(res.length() - 1);
        }
    }
}
