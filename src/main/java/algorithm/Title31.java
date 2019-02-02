package algorithm;

/**
 * User: linsen
 * Date: 18/5/1
 * Time: 下午12:28
 * Description:
 */

/**
 * 最大子数组和(子向量的长度至少是1)
 */
public class Title31 {

    public int findGreatestSumOfSubArray(int[] array) {
        int len = array.length, max;
        //以array[i]为结尾的最大子数组和记录为ans[i]
        int[] ans = new int[len];
        max = ans[0] = array[0];
        for(int i=1; i<len; i++) {
            ans[i] = Math.max(ans[i-1]+array[i], array[i]);
            if (ans[i] > max)
                max = ans[i];
        }
        return max;
    }

}
