package algorithm;

/**
 * User: linsen
 * Date: 18/5/2
 * Time: 下午2:47
 * Description:
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Title33 {

    public String printMinNumber(int[] numbers) {
        Integer[] integers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            integers[i] = numbers[i];
        Arrays.sort(integers, new LinkComparator());
        StringBuilder sb = new StringBuilder();
        for (int num : integers)
            sb.append(num);
        return sb.toString();
    }

    class LinkComparator implements Comparator<Integer> {

        /**
         * mn < nm 代表 m < n
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Integer o1, Integer o2) {
            String mn = o1.toString() + o2.toString();
            String nm = o2.toString() + o1.toString();
            return compareStr(mn, nm);
        }

        /**
         * 比较两个整形数组的大小
         *
         * @param str1
         * @param str2
         */
        public int compareStr(String str1, String str2) {
            assert (str1.length() == str2.length());
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i))
                    continue;
                else if (str1.charAt(i) < str2.charAt(i))
                    return -1;
                else
                    return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Title33().printMinNumber(new int[]{1, 21, 5, 13}));
    }

}
