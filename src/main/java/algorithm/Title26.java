package algorithm;

/**
 * User: linsen
 * Date: 18/4/27
 * Time: 下午5:26
 * Description:
 */

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Title26 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 思路：拷贝每一个节点，并放到原链表对应位置的下一个节点。然后完成random节点的链路连接，最后拆链。
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        // 拷贝节点，并插入到对应节点的下一个节点
        RandomListNode p = pHead, cloneHead = null, p1;
        for (; ; ) {
            // 到链尾，跳出循环
            if (p == null)
                break;

            RandomListNode node = new RandomListNode(p.label);
            // 拷贝链表头结点的赋值
            if (p == pHead)
                cloneHead = node;

            // 将本次拷贝的节点赋值到当前节点的next节点中
            RandomListNode pNext = p.next;
            p.next = node;
            node.next = pNext;
            p = pNext;
        }

        // 完成拷贝节点random的赋值
        p = pHead;
        p1 = cloneHead;
        for (; ; ) {
            // random赋值, 确保random存在
            if (p.random != null)
                p1.random = p.random.next;
            // 前移节点
            p = p1.next;
            // 到链尾，跳出循环
            if (p == null)
                break;
            p1 = p.next;

        }

        // 链路拆分
        p = pHead;
        p1 = cloneHead;
        for (; ; ) {
            p = p.next = p1.next;
            // 到链尾，跳出循环
            if (p == null)
                break;
            p1 = p1.next = p.next;
        }

        return cloneHead;

    }

    public static void main(String[] args) {
        Title26 title26 = new Title26();
        RandomListNode n1 = title26.new RandomListNode(1);
        RandomListNode n2 = title26.new RandomListNode(2);
        RandomListNode n3 = title26.new RandomListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n2;
        n2.random = n3;
        n3.random = n1;
        title26.Clone(n1);
    }

}
