package algorithm;

/**
 * User: linsen
 * Date: 18/4/25
 * Time: 上午12:11
 * Description:
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Title14 {

    public void reOrderArray(int [] array) {
        // 边界判断
        if (array == null || array.length == 0)
            return;
        // 分别获取有序的技术和偶数序列
        int[] oddList = new int[array.length];
        int[] evenList = new int[array.length];
        int oddLen = 0, evenLen = 0;
        for (int i = 0; i < array.length; i++) {
            // 偶数末尾为0
            if ((array[i] & 1) == 0) {
                evenList[evenLen++] = array[i];
            } else {
                oddList[oddLen++] = array[i];
            }
        }
        // 拷贝赋值
        System.arraycopy(oddList, 0, array, 0, oddLen);
        System.arraycopy(evenList, 0, array, oddLen, evenLen);
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        new Title14().reOrderArray(array);
    }

}
