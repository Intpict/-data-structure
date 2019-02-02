package algorithm;

/**
 * User: linsen
 * Date: 18/5/7
 * Time: 下午10:17
 * Description:
 */

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Title42 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int start = 1, end = 2;
        while (start <= sum / 2) {
            int tmp = (end - start + 1) * (start + end) / 2;
            if (tmp == sum) {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                for (int i = start; i <= end; i++)
                    sub.add(i);
                ans.add(sub);
                start++;
            } else if (tmp < sum) {
                end++;
            } else {
                start++;
            }
        }
        return ans;
    }

}
