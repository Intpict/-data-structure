package algorithm;

/**
 * User: linsen
 * Date: 18/4/24
 * Time: 下午2:51
 * Description:
 */

/**
 * 给定单向链表的头指针和一个节点指针，要求O(1)时间删除该节点，
 */
public class Title13 {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：O(1)，所以将target的next节点赋值给target，然后删除next
     * 注意：必须保证target在链表中
     *
     * @param head
     * @param target
     * @return 【必须返回新的头结点指针，并且在方法外部做头节点替换】
     */
    public ListNode delete(ListNode head, ListNode target) {
        // 边界判断
        if (head == null || target == null)
            return head;
        // target节点为头结点
        if (target == head) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        // target为尾节点
        } else if (target.next == null) {
            ListNode p = head;
            while(p.next != target)
                p = p.next;
            p.next = null;
        } else {
            // 不为尾节点，直接替换next节点的值到当前节点中
            ListNode p = target.next;
            target.next = p.next;
            target.val = p.val;
        }
        return head;
    }

}
