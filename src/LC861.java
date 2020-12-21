import org.junit.Test;

public class LC861 {

    @Test
    public void test() {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore1(A));
    }


    public int matrixScore(int[][] A) {
        int res = 0;
        int len = A.length;
        int len1 = A[0].length;
        for(int i = 0; i < len; i++) {
            if(A[i][0] == 0) {
                for(int j = 0; j < len1; j++) {
                    if(A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }
        for(int j = 0; j < len1; j++) {
            int isone = 0;
            for(int i = 0; i < len; i++) {
                if(A[i][j] == 1) {
                    isone++;
                }
            }
            if(isone <= len / 2) {
                for(int i = 0; i < len; i++) {
                    if(A[i][j] == 1) {
                        A[i][j] = 0;
                    } else {
                        A[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len1; j++) {
                res += A[i][j] * Math.pow(2, len1 - j - 1);
            }
        }
        return res;
    }
    public int matrixScore1(int[][] A) {
        int len = A.length;
        int len1 = A[0].length;
//      已经赋给res，最大位全是一的值
        int res = len * (1 << (len1 - 1));

        for(int i = 1; i < len1; i++) {
            int isone = 0;
            for(int j = 0; j < len; j++) {
                if(A[j][0] == 0) {
                    isone += (1 - A[j][i]);
                } else {
                    isone += A[j][i];
                }
            }
            int k = Math.max(isone, len - isone);
            res += k * (1 << (len1 - 1 - i));
        }
        return res;
    }
}
