package algorithm;

/**
 * User: linsen
 * Date: 18/5/7
 * Time: 下午10:42
 * Description:
 */

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Title43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (array == null || array.length == 0)
            return ans;
        int start = 0;
        int end = array.length - 1;
        int multi = 0;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                if (ans.size() == 0) {
                    ans.add(array[start]);
                    ans.add(array[end]);
                    multi = array[start] * array[end];
                } else {
                    if (array[start] * array[end] < multi) {
                        ans.set(0, array[start]);
                        ans.set(1, array[end]);
                        multi = array[start] * array[end];
                    }
                }
                start++;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }

}
