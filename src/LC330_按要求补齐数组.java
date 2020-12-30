import org.junit.Test;

/**
 * 给定一个已排序的正整数数组 nums，和一个正整数n 。从[1, n]区间内选取任意个数字补充到nums中，使得[1, n]区间内的任何数字都可以用nums中
 * 某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例1:
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums里现有的组合[1], [3], [1,3]，可以得出1, 3, 4。
 * 现在如果我们将2添加到nums 中，组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字1, 2, 3, 4, 5, 6，能够覆盖[1, 6]区间里所有的数。
 * 所以我们最少需要添加一个数字。
 *
 * 示例 2:
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加[2, 4]。
 *
 * 示例3:
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 */

public class LC330_按要求补齐数组 {

    @Test
    public void test() {
        int[] nums = {1, 5, 10};
        System.out.println(minPatches(nums, 20));
    }

    public int minPatches(int[] nums, int n) {
//        nums数组已经有序
        int len = nums.length;
        int index = 0;
        int res = 0;
        long x = 1;
        while(x <= n) {
            if(index < len && nums[index] < x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                res++;
            }
        }
        return res;
    }
}
