package algorithm;

/**
 * User: linsen
 * Date: 18/4/27
 * Time: 下午8:01
 * Description:
 */

import apple.laf.JRSUIUtils;

import java.util.LinkedList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Title27 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode listTail;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head;

        // 左子树存在,与当前节点合并
        if (pRootOfTree.left != null) {
            head = Convert(pRootOfTree.left);
            listTail.right = pRootOfTree;
            pRootOfTree.left = listTail;
            listTail = pRootOfTree;
        } else {
            head = listTail = pRootOfTree;
        }

        // 右子树存在，与当前节点合并
        if (pRootOfTree.right != null) {
            pRootOfTree.right = Convert(pRootOfTree.right);
            pRootOfTree.right.left = pRootOfTree;
        }

        return head;

    }

}
