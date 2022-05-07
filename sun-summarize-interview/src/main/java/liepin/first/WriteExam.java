package liepin.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunxiaoyu3
 * @description 正数的因数分解
 * @createTime 2020/11/04 13:49:00
 */
public class WriteExam {
    public static void main(String[] args) {
        System.out.println(handle(12));
    }

    private static List<Integer> handle(int n) {
        List<Integer> result = new ArrayList<>();

        int k = 2;

        while (k <= n) {
            if (k == n) {
                result.add(n);
                return result;
            } else if (n % k == 0) {
                result.add(k);
                n = n / k;
            } else {
                k++;
            }

        }
        return result;
    }
}
