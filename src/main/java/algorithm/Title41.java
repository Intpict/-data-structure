package algorithm;

/**
 * User: linsen
 * Date: 18/5/7
 * Time: 下午10:00
 * Description:
 */

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Title41 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0] = 0;
        num2[0] = 0;
        // 所有值异或
        int allXor = 0;
        for (int arr : array)
            allXor ^= arr;

        // 找出不为0的那一位对应的数值
        assert allXor != 0;
        int value = 1;
        for (int i = 0; i < 32; i++, value <<= 1)
            if ((allXor & value) != 0)
                break;

        // 二次异或，分组：该位为1的异或，不为1的异或
        for (int arr : array) {
            if ((arr & value) == 0)
                num1[0] ^= arr;
            else
                num2[0] ^= arr;
        }
    }

    public static void main(String[] args) {

    }

}
