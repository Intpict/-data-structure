package algorithm;

/**
 * User: linsen
 * Date: 18/5/8
 * Time: 上午12:54
 * Description:
 */

import java.util.Arrays;

/**
 * 从扑克中抽五张牌，看是否为顺子。大小王为可以代替任意数字
 * 大小王认为是0
 */
public class Title46 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;
        int[] copy = new int[numbers.length];
        System.arraycopy(numbers, 0, copy, 0, numbers.length);
        // 快速排序
        Arrays.sort(copy);
        // 数组中所有元素必然都为正数
        int zeroNum = 0, nonZeroIndex = 0;
        for (int i = 0; i < copy.length; i++)
            if (copy[i] == 0)
                zeroNum++;
        nonZeroIndex = zeroNum;
        // 中间的差值用0代替
        for (int i = nonZeroIndex; i < copy.length - 1; i++) {
            if (copy[i] == copy[i + 1])
                return false;
            zeroNum -= (copy[i + 1] - copy[i] - 1);
        }
        // 剩下的0的个数大于0，则说明是顺子
        if (zeroNum >= 0)
            return true;
        return false;
    }

}
