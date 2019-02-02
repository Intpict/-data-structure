package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 下午5:22
 * Description:
 */

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Title23 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        // 使用双向节点保存当前行的所有TreeNode
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode current = deque.pop();
            ans.add(current.val);
            if (current.left != null)
                deque.add(current.left);
            if (current.right != null)
                deque.add(current.right);
        }
        return ans;
    }

}
