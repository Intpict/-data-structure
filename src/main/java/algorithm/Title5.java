package algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午6:23
 * Description:
 */

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Title5 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> stack = new ArrayList<Integer>();
        while(listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = stack.size() - 1; i >= 0; i-- )
            ans.add(stack.get(i));
        return ans;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}
