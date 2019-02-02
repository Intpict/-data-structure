package algorithm;

/**
 * User: linsen
 * Date: 18/4/28
 * Time: 上午9:02
 * Description:
 */

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Title29 {

    /**
     * 使用hashmap存储数组元素出现的次数
     * @param array
     * @return
     */
    public int moreThanHalfNumSolution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (array == null || array.length == 0)
            return 0;
        int threshold = (array.length >> 1) + 1;
        for (int i = 0; i < array.length; i++) {
            if (threshold == 1)
                return array[i];
            if (map.containsKey(array[i])) {
                if (map.get(array[i]) + 1 >= threshold)
                    return array[i];
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Title29().moreThanHalfNumSolution(new int[]{1,2,3,2,2,2,5,4,2});
    }

}
