package algorithm;

/**
 * User: linsen
 * Date: 18/4/25
 * Time: 上午12:36
 * Description:
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Title15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode head, int k) {
        // 边界测试
        if (k <= 0 || head == null)
            return null;

        ListNode p1 = head, p2 = head;
        // p2先移动k-1个节点
        for (int i = 0; i < k-1; i++) {
            p2 = p2.next;
            // p2为null，说明链表的总个数没有k个，直接返回null
            if (p2 == null)
                return null;
        }

        // p2不是尾节点，则同时向前移动p1和p2节点
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

}
