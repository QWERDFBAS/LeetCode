import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1046 {

    @Test
    public void test() {
        int[] nums = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(nums));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int stone : stones) {
            queue.add(stone);
        }

        while(queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
//            if(a > b) {
//                queue.add(a - b);
//            }
            queue.add(a - b);
        }
        return queue.size() == 0 ? 0 : queue.poll();
    }
}
