package algorithm;

/**
 * User: linsen
 * Date: 18/5/3
 * Time: 下午8:21
 * Description:
 */

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Title38 {

    public int GetNumberOfK(int [] array , int k) {
        int ans = 0;
        if (array == null || array.length == 0)
            return ans;

        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        // 找到k
        if (first != -1 && last != -1) {
            ans = last - first + 1;
        }
        return ans;

    }

    /**
     * 如果未找到，返回-1
     * @return
     */
    public int getFirstK(int [] array , int k, int start, int end) {
        if (start == end)
            return (array[start] == k) ? start : -1;
        int midIndex = (start + end) >> 1;
        if (array[midIndex] == k) {
            if (midIndex == 0 || array[midIndex - 1] != k)
                return midIndex;
            else
                return getFirstK(array, k, start, midIndex - 1);
        } else if (array[midIndex] > k) {
            return getFirstK(array, k, start, midIndex - 1);
        } else {
            return getFirstK(array, k, midIndex + 1, end);
        }
    }

    /**
     * 如果未找到，返回-1
     * @return
     */
    public int getLastK(int [] array , int k, int start, int end) {
        if (start == end)
            return (array[start] == k) ? start : -1;
        int midIndex = (start + end) >> 1;
        if (array[midIndex] == k) {
            if (midIndex == array.length - 1 || array[midIndex + 1] != k)
                return midIndex;
            else
                return getLastK(array, k, midIndex + 1, end);
        } else if (array[midIndex] > k) {
            return getLastK(array, k, start, midIndex - 1);
        } else {
            return getLastK(array, k, midIndex + 1, end);
        }
    }

    public static void main(String[] args) {
        Title38 title = new Title38();
        int[] array = new int[] {1, 2, 2, 4, 6, 10, 10, 10};
        title.GetNumberOfK(array, 2);
    }

}
