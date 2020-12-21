import org.junit.Test;

import javax.swing.border.SoftBevelBorder;
import java.util.*;

public class LC973 {
    Random rand = new Random();

    @Test
    public void test() {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        System.out.println(kClosest(points, K));
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        random_select(points, 0, len - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivot_id = left + rand.nextInt(right - left + 1);
        int pivot = points[pivot_id][0] * points[pivot_id][0] + points[pivot_id][1] * points[pivot_id][1];
        swap(points, pivot_id, right);
        int i = left - 1;
        for(int j = left; j < right; j++) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if(dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);

        if(K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        } else if(K < i - left + 1) {
            random_select(points, left, i - 1, K);
        }

    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
