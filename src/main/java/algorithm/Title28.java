package algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * User: linsen
 * Date: 18/4/27
 * Time: 下午9:06
 * Description:
 */

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Title28 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<String>();
        if (str == null || str.length() == 0)
            return ans;

        if (str.length() == 1) {
            ans.add(str);
            return ans;
        }

        StringBuilder sb = new StringBuilder(str);
        subPermutation(sb, 0, ans);
        Collections.sort(ans);
        return ans;

    }

    public void subPermutation(StringBuilder sb, int index, ArrayList<String> ans) {
        if (index == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = index; i < sb.length(); i++) {
            // 判断字符是否在之前出现过
            boolean isFinish = false;
            if (i != index) {
                for (int j = index; j < i; j++)
                    if (sb.charAt(i) == sb.charAt(j)) {
                        isFinish = true;
                        break;
                    }
            }
            if (isFinish)
                continue;

            // 交换字符
            char tmp = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, tmp);

            // 递归调用
            subPermutation(sb, index + 1, ans);

            // 交换回来
            tmp = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, tmp);
        }

    }



    public static void main(String[] args) {
        ArrayList<String> ans = new Title28().Permutation("abb");
        for (int i = 0; i < ans.size(); i++)
            System.out.println(ans.get(i));
    }

}
