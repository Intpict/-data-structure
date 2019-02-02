package algorithm;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 下午2:00
 * Description:
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Title21 {

    // 数据栈, 存储正常数据
    Stack<Integer> datas = new Stack<Integer>();
    // 辅助栈，存储每次栈中的最小值
    Stack<Integer> mins = new Stack<Integer>();

    public void push(int node) {
        datas.push(node);
        if (mins.empty() || node < mins.peek()) {
            mins.push(node);
        } else {
            mins.push(mins.peek());
        }
    }

    public void pop() {
        datas.pop();
        mins.pop();
    }

    public int top() {
        return datas.peek();
    }

    public int min() {
        return mins.peek();
    }

}
