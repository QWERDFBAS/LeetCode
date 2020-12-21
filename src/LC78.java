import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> res;
    List<Integer> list;


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        back(nums, 0);
        return res;
    }

    public void back(int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[index]);
        back(nums, index++);
        list.remove(list.size() - 1);
        back(nums, index++);
    }
}
