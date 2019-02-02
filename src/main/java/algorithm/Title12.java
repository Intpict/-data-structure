package algorithm;

/**
 * User: linsen
 * Date: 18/4/24
 * Time: 下午12:27
 * Description:
 */

/**
 * 输入数字n，按顺序打印从1到最大n位的十进制数
 * 例：输入3，打印1，2，3...，999
 */
public class Title12 {

    public void printToMaxOfNDigits(int n) {
        assert (n > 0);
        char[] str = new char[n];
        // 最高位所在的索引，为0代表当前为n位十进制数
        fillCharWithIndex(str, 0);
    }

    /**
     * 填充对应index的字符
     */
    public void fillCharWithIndex(char[] str, int index) {
        if (index == str.length) {
            printWithoutPreixZreo(str);
            return;
        }
        for (int i = 0; i < 10; i++) {
            str[index] = String.valueOf(i).charAt(0);
            fillCharWithIndex(str, index + 1);
        }
    }

    /**
     * 打印字符串，去除以0开始的所有字符
     *
     * @param str
     */
    public void printWithoutPreixZreo(char[] str) {
        int i;
        for (i = 0; i < str.length; i++) {
            if (str[i] != '0')
                break;
        }
        // 说明全为'0'，不打印
        if (i == str.length)
            return;
        System.out.println(new String(str).substring(i));
    }

    public static void main(String[] args) {
        new Title12().printToMaxOfNDigits(3);
    }

}
