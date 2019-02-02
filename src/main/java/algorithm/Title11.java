package algorithm;

/**
 * User: linsen
 * Date: 18/4/24
 * Time: 上午11:10
 * Description:
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方
 */
public class Title11 {

    public double Power(double base, int exponent) {
        // 边界考虑
        if (base == 0 && exponent < 0)
            return 0;
        // 指数为0
        if (exponent == 0)
            return 1;
        // 指数不为0
        if (exponent > 0) {
            double result = 1;
            while (exponent-- > 0) {
                result *= base;
            }
            return result;
        } else {
            double result = 1;
            exponent = -1 * exponent;
            while (exponent-- > 0) {
                result *= base;
            }
            result = 1.0/result;
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Title11().Power(10.5, -2));
    }

}
