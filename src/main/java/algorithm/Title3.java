package algorithm;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午2:12
 * Description:
 */

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Title3 {

    public static boolean find(int target, int [][] array) {
        if (array == null || array.length == 0)
            return false;
        // a为行， b为列
        int a = 0, b = array[0].length - 1;
        // 处理逻辑
        while (a < array.length  && b >= 0) {
            if (array[a][b] == target) {
                return true;
            } else if (array[a][b] < target) {
                a++;
            } else {
                b--;
            }
        }
        // 没找到，返回false
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Title3.find(3, array));
        System.out.println(Title3.find(7, array));
        System.out.println(Title3.find(16, array));
    }

}
