import org.junit.Test;

/**
 * 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 *
 * 说明: N是在[0, 10^9]范围内的一个整数。
 */


public class LC738MonotonicallyIncreasingNumbers {

    @Test
    public void test() {
        int N = 332;
        System.out.println(monotoneIncreasingDigits(N));
    }

    public int monotoneIncreasingDigits(int N) {
//        char[] c = String.valueOf(N).toCharArray();
//        int len = c.length;
//        for(int i = len - 1; i > 0; i--) {
//            if(c[i] < c[i - 1]) {
//                c[i - 1]--;
//                for(int j = i; j < len; j++) {
//                    c[j] = '9';
//                }
//            }
//        }
//        return Integer.parseInt(String.valueOf(c));

        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));

//        for(int i = N; i >= 0; i--) {
//            if(isMonotonous(i)) {
//                return i;
//            }
//        }
//        return 0;
    }

    public boolean isMonotonous(int N) {
        if(N < 10) {
            return true;
        } else {
            int pre = N % 10;
            while(N > 0) {
                N = N / 10;
                int cur = N % 10;
                if(cur > pre) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }
}
