import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC31 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        perm(nums, 0, nums.length);
    }

    public static void perm(int[] array, int start, int end) {
        if(start == end) {
            int len = array.length;
            int count = 0;
            for(int i = len - 1; i >= 0; i--) {
                count += Math.pow(10, len - i - 1) * array[i];
            }
            System.out.println(count);
        } else {
            for (int i = start; i < end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(array,start,i);
                perm(array,start+1,end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array,start,i);
            }
        }
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
