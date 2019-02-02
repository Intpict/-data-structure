package algorithm;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 上午10:50
 * Description:
 */

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Title20 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // 边界判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;
        int rStart = 0, rEnd = matrix.length - 1, cStart = 0, cEnd = matrix[0].length - 1;
        // 顺时针遍历
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int i = cStart; i <= cEnd; i++)
                ans.add(matrix[rStart][i]);
            for (int i = rStart + 1; i <= rEnd; i++)
                ans.add(matrix[i][cEnd]);
            // 防止一行重复打印
            if (rEnd > rStart) {
                for (int i = cEnd - 1; i >= cStart; i--)
                    ans.add(matrix[rEnd][i]);
            }
            // 防止一列重复打印
            if (cEnd > cStart) {
                for (int i = rEnd - 1; i >= rStart + 1; i--)
                    ans.add(matrix[i][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Title20().printMatrix(new int[][]{{1, 2, 3, 4}});
    }

}
