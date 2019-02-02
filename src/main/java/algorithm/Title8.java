package algorithm;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午7:51
 * Description:
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Title8 {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int size = array.length;
        int p1 = 0, p2 = size - 1;
        // 数组长度为1
        // 数组第一个元素小于最后一个元素，说明未旋转
        if (size == 1 || array[p1] < array[p2]) {
            return array[0];
        }
        // 如果mid = array[p1] = array[p1] 则遍历查找返回，否则二分
        while(true) {
            if (p2 - p1 == 1)
                return array[p2];

            int mid = (p1 + p2) / 2;
            // 三者相等
            if (array[p1] == array[p2] && array[p1] == array[mid]) {
                // 遍历查找
                int ans = array[p1];
                for (int i = p1 + 1; i <= p2; i++) {
                    if (array[i] < ans)
                        ans = array[i];
                }
                return ans;
            }

            // 三者不等
            if (array[p1] <= array[mid])
                p1 = mid;

            if (array[p2] >= array[mid])
                p2 = mid;

        }

    }
}
