package algorithm;

/**
 * User: linsen
 * Date: 18/5/3
 * Time: 下午7:59
 * Description:
 */

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Title37 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        // 算链表1的长度
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        // 算链表2的长度
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        // 长链表移动头结点到delta次
        if (len1 > len2) {
            int delta = len1 - len2;
            while (delta-- > 0) {
                pHead1 = pHead1.next;
            }
        } else {
            int delta = len2 - len1;
            while (delta-- > 0) {
                pHead2 = pHead2.next;
            }
        }

        // 同时移动两个头结点节点，找出第一个相同的节点
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;

    }

}
