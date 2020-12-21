import org.junit.Test;

import java.util.Arrays;

public class LC1030 {

    @Test
    public void test() {
        int R = 2;
        int C = 2;
        int r0 = 0;
        int c0 = 0;
        int[][] res = allCellsDistOrder(R, C, r0,c0);
        System.out.println(res[0] + " " + res[1]);
    }


    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] local = new int[R * C][2];
        int index = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                local[index++] = new int[]{i, j};
            }
        }
        int[] dis = new int[R * C];
        for(int i = 0; i < R * C; i++) {
            dis[i] = Math.abs(r0 - local[i][0]) + Math.abs(c0 - local[i][1]);
        }
        quicksort(dis, 0, dis.length - 1, local);

        return local;
    }


    public void quicksort(int[] nums, int l, int r, int[][] local) {
        if(l >= r) {
            return ;
        }
        int j = partition(nums, l, r, local);
        quicksort(nums, l, j - 1, local);
        quicksort(nums, j + 1, r, local);
    }


    public int partition(int[] nums, int l, int r, int[][] local) {
        int i = l, j = r + 1;
        int v = nums[l];
        while(true) {
            while(nums[++i] < v) {
                if(i == r) {
                    break;
                }
            }
            while(nums[--j] > v) {
                if(j == l) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            swap(nums, i, j);
            swap(local, i, j);
        }
        swap(nums, l, j);
        swap(local, l, j);
        return j;
    }


    public void swap(int[][] num, int l, int r) {
        int[] temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }

    public void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
