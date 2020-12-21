import org.junit.Test;

import java.util.Arrays;

public class LC204 {

    @Test
    public void test() {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    public int countPrimes(int n) {
//        if(n < 2) {
//            return 0;
//        }
//        if(n == 2) {
//            return 0;
//        }
//        if(n == 3) {
//            return 1;
//        }
        int res = 0;
//        if(n > 3) {
//            res += 2;
//        }
        int flag = 0;
        for(int i = 2; i < n; i++) {
            int temp = (int)Math.sqrt(i);
            for(int j = 2; j <= temp; j++) {
                if(i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                res++;
            } else {
                flag = 0;
            }
        }
        return res;
    }

    public int countPrimes1(int n) {
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int ans = 0;
        for(int i = 2; i < n; i++) {
            if(count[i] == 1) {
                ans++;
                if((long)i * i < n) {
                    for(int j = i * i; j < n; j += i) {
                        count[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
