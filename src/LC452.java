import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LC452 {

    @Test
    public void test() {
//        [[10,16],[2,8],[1,6],[7,12]]
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }


    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) {
                    return -1;
                } else if(o1[1] > o2[1]){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int position = points[0][1];
        int ans = 1;
        for(int[] ballon : points) {
            if(ballon[0] > position) {
                ans++;
                position = ballon[1];
            }
        }
        return ans;
    }
}
