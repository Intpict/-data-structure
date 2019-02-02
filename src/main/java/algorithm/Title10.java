package algorithm;

/**
 * User: linsen
 * Date: 18/4/24
 * Time: 上午10:10
 * Description:
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Title10 {

    /**
     * 还有一种解法：
     * n = n & (n-1) 直到等于0 为止
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int i = 1, count = 0;
        for (int j = 0; j < 32; j++) {
            if ((n & i) != 0)
                count++;
            i <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Title10().NumberOf1(-1));
    }

}
