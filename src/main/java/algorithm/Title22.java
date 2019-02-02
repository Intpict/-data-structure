package algorithm;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 下午2:37
 * Description:
 */

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 */
public class Title22 {

    public boolean isPopOrder(int [] pushA, int [] popA) {
        // 边界判断，全为null
        if (pushA == null && popA == null)
            return true;
        // 只有一个为null, 或者都不为null但是长度不相等
        if (pushA == null || popA == null || pushA.length != popA.length)
            return false;
        // 遍历pushA数组，执行stack的push操作
        // 如果栈顶元素等于出栈元素，则直接pop，否则继续入栈。
        // index：p代表此时popA数组移动的下标位置
        int p = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty()) {
                if (stack.peek() == popA[p]) {
                    stack.pop();
                    p++;
                } else {
                    break;
                }
            }
        }
        if (!stack.empty() || p != popA.length)
            return false;
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Title22().isPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

}
