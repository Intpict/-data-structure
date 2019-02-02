package algorithm;

/**
 * User: linsen
 * Date: 18/4/25
 * Time: 下午2:14
 * Description:
 */

/**
 * 合并两个排序的链表:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Title17 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        //  确定头结点
        ListNode head = null, p1 = list1, p2 = list2;
        if (p1.val < p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }

        // 归并操作
        ListNode p3 = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        // list1链表未归并完成
        if (p1 != null)
            p3.next = p1;
        // list2链表未归并完成
        if (p2 != null)
            p3.next = p2;

        return head;

    }


}
