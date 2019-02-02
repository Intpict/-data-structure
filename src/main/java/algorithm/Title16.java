package algorithm;

/**
 * User: linsen
 * Date: 18/4/25
 * Time: 下午12:16
 * Description:
 */

/**
 * 输入一个链表，反转链表后，并输出链表的所有元素
 */
public class Title16 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 保存三个节点
        // 取出后，p2节点的next指向p1节点
        // 初始时，p1为head节点，翻转后，必定为null
        ListNode p1 = head, p2 = p1.next, p3 = p2.next;
        p1.next = null;
        p2.next = p1;
        while (p3 != null) {
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
        }
        return p2;
    }

}
