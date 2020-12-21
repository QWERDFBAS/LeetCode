import org.junit.Test;

import java.util.*;

public class LC1356 {
    Map<Integer, List<Integer>> map = new HashMap<>();

    @Test
    public void test() {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(sortByBits(arr));
    }

    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int[] res = new int[len];
        // for(int i = 0; i < len; i++) {
        //     String s = Integer.toBinaryString(arr[i]);
        //     int l = s.length();
        //     int count = 0;
        //     for(int j = 0; j < l; j++) {
        //         if(s.charAt(j) == '1'') {
        //             count++;
        //         }
        //     }
        //     map.push(arr[i], count);
        // }
        for(int num : arr) {
            int temp = num;
            int count = 0;
            while(temp != 0) {
                count += temp % 2;
                temp /= 2;
            }
            List<Integer> list = map.getOrDefault(count, new ArrayList<>());
            list.add(num);
            map.put(count , list);
        }
        int index = 0;
        for(int k : map.keySet()) {
            List<Integer> l = map.get(k);
            for(int i = 0; i < l.size(); i++) {
                res[i] = l.get(i);
            }
        }
        return res;
    }


    public int[] sortByBits1(int[] arr) {
        int len = arr.length;
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for(int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if(bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int get(int x) {
        int count = 0;
        while(x != 0) {
            count += x % 2;
            x /= 2;
        }
        return count;
    }
}
