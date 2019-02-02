package algorithm;

/**
 * User: linsen
 * Date: 18/5/8
 * Time: 上午1:18
 * Description:
 */

import java.util.HashMap;

/**
 * 0~n-1这n个数排成一个圆圈，从0开始每次删除第m个数字，求最后剩下的数字
 */
public class Title47 {

    public int LastRemaining_Solution(int n, int m) {
        assert n > 0 && m > 0;
        int ans = 0;
        // map用来记录当前的下标值是否已经被踢出
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 统计当前被踢出的数值个数
        int count = 0;
        int i = 0, j = 0;
        for (; ; ) {
            // 已经被提出
            if (map.containsKey(i)) {
                if (i == n - 1)
                    i = 0;
                else
                    i++;

                // 没有被提出
            } else {
                // 需要被提出
                if (j == m - 1) {
                    map.put(i, 1);
                    j = 0;
                    // 只剩一个，跳出循环
                    count++;
                    if (count == n - 1)
                        break;
                    if (i == n - 1)
                        i = 0;
                    else
                        i++;
                } else {
                    j++;
                    if (i == n - 1)
                        i = 0;
                    else
                        i++;
                }
            }
        }
        for (int k = 0; k < n; k++)
            if (!map.containsKey(k)) {
                ans = k;
                break;
            }

        return ans;

    }

    public int standard(int n, int m) {
        if (n == 0 || m == 0) return -1;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;

    }

    public static void main(String[] args) {
        System.out.println(new Title47().LastRemaining_Solution(300, 100));
        System.out.println(new Title47().standard(300, 100));
    }

}
