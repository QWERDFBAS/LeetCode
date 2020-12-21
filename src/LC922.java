import org.junit.Test;

public class LC922 {

    @Test
    public void test() {
        int[] A = {1, 3, 2, 5};
        System.out.println(sortArrayByParityII(A));
    }

    public int[] sortArrayByParityII(int[] A) {
//        int len = A.length;
//        // i是偶数，j是基数
//        int i = 0, j = 1;
//        while(i < len && j < len) {
//            if(A[i] % 2 == 1 && A[j] % 2 == 0) {
//                swap(A, i, j);
//            }
//            if(A[i] % 2 == 0) {
//                i += 2;
//            }
//            if(A[j] % 2 == 1) {
//                j += 2;
//            }
//        }
//        return A;
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
