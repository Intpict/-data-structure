package algorithm;

/**
 * User: linsen
 * Date: 18/5/2
 * Time: 下午8:30
 * Description:
 */

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Title34 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        if (index == 1)
            return 1;
        int[] uglys = new int[index];
        uglys[0] = 1;
        int nextIndex = 1, index2 = 0, index3 = 0, index5 = 0;
        while (nextIndex < index) {
            uglys[nextIndex] = min(uglys[index2] * 2, uglys[index3] * 3, uglys[index5] * 5);
            while (uglys[index2] * 2 <= uglys[nextIndex])
                index2++;
            while (uglys[index3] * 3 <= uglys[nextIndex])
                index3++;
            while (uglys[index5] * 5 <= uglys[nextIndex])
                index5++;
            nextIndex++;
        }
        return uglys[nextIndex - 1];
    }

    public int min(int n1, int n2, int n3) {
        int min = (n1 < n2) ? n1 : n2;
        min = (min < n3) ? min : n3;
        return min;
    }

}
