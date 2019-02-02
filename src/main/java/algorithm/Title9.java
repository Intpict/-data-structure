package algorithm;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午8:47
 * Description:
 */

/**
 * 大家都知道斐波那契数列
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Title9 {

    public int Fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];
        int i = 1;
        do {
            int tmp = result[0] + result[1];
            result[0] = result[1];
            result[1] = tmp;
        } while (++i < n);

        return result[1];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        target--;
        int[] result = {1, 2};
        if (target < 2)
            return result[target];
        int i = 1;
        do {
            int tmp = result[0] + result[1];
            result[0] = result[1];
            result[1] = tmp;
        } while (++i < target);

        return result[1];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        // 2^(n-1)
        return (int)Math.pow(2, target-1);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法。
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        target--;
        int[] result = {1, 2};
        if (target < 2)
            return result[target];
        int i = 1;
        do {
            int tmp = result[0] + result[1];
            result[0] = result[1];
            result[1] = tmp;
        } while (++i < target);

        return result[1];
    }

    public static void main(String[] args) {
        System.out.println(new Title9().Fibonacci(4));
        System.out.println(new Title9().RectCover(5));
    }

}
