package algorithm;

/**
 * User: linsen
 * Date: 18/5/22
 * Time: 下午10:54
 * Description:
 */

/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Title49 {

    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }

}
