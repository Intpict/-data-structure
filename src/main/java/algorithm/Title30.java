package algorithm;

/**
 * User: linsen
 * Date: 18/4/28
 * Time: 下午3:32
 * Description:
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Title30 {

    public ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (input == null || k <= 0 || input.length == 0 || k > input.length)
            return ans;
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);

        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++)
            ans.add(input[i]);
        return ans;
    }

    /**
     * 快排算法
     * @param input
     * @param start
     * @param end
     */
    public void quickSort(int[] input, int start, int end) {
        if (start >= end)
            return;
        int index = partition(input, start, end);
        quickSort(input, start, index - 1);
        quickSort(input, index + 1, end);

    }

    // 快速排序partition方法，给定下标start, end, input数组，和pivotIndex(轴)
    // 返回轴的值所在的新位置的索引
    public int partition(int[] input, int start, int end) {
        // end的值作为轴值
        int pivot = input[end], storeIndex = start;
        for (int i = start; i < end; i++) {
            if (input[i] < pivot) {
                swap(input, storeIndex, i);
                storeIndex++;
            }
        }
        // 将end中存储的轴值交换到应该的中间位置
        swap(input, storeIndex, end);
        return storeIndex;
    }

    // 数组中索引值交换
    public void swap(int[] input, int indexA, int indexB) {
        int tmp = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,3,12,2,6,7};
        ArrayList<Integer> ans = new Title30().getLeastNumbersSolution(input, input.length);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            System.out.print(" ");
        }
        new Title30().quickSort(input, 0, input.length - 1);
        System.out.println("");

    }

}
