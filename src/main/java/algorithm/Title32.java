package algorithm;

/**
 * User: linsen
 * Date: 18/5/1
 * Time: 下午4:08
 * Description:
 */

/**
 * 从1到n的整数中1出现的次数
 */
public class Title32 {

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        if (n < 10)
            return 1;
        int high = getHighestNum(n);
        int rest = getRestNum(n);
        // 千位数即为1000，万位数即为10000
        int highWeight = (n - rest) / high;
        int highIsOneNum = 0, otherIsOneNum = 0;
        if (high == 1) {
            highIsOneNum = rest + 1;
        } else {
            highIsOneNum = highWeight;
        }
        otherIsOneNum = high * highWeight / 10 * (getCount(n) - 1);
        return highIsOneNum + otherIsOneNum + NumberOf1Between1AndN_Solution(rest);
    }

    /**
     * 获取整数的最高位
     */
    int getHighestNum(int n) {
        while (n / 10 != 0) {
            n /= 10;
        }
        return n % 10;
    }

    /**
     * 出去整数的最高位后的整数值
     */
    int getRestNum(int n) {
        int high = getHighestNum(n), init = n;
        while (n / 10 != 0) {
            n /= 10;
            high *= 10;
        }
        return init - high;
    }

    /**
     * 获取当前整数的位数
     */
    int getCount(int n) {
        int count = 1;
        while (n / 10 != 0) {
            n /= 10;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Title32().NumberOf1Between1AndN_Solution(100));
    }

}
