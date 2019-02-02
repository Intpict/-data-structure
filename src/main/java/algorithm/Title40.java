package algorithm;

/**
 * User: linsen
 * Date: 18/5/3
 * Time: 下午9:13
 * Description:
 */

import javax.xml.soap.Node;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Title40 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class NodeStatus {
        int depth;
        boolean isBalanced;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        // 是平衡二叉树的条件：
        // 左，右子树为平衡二叉树且他们的深度差为1
        NodeStatus leftStatus = getTreeStatus(root.left);
        NodeStatus rightStatus = getTreeStatus(root.right);
        return leftStatus.isBalanced && rightStatus.isBalanced && Math.abs(leftStatus.depth - rightStatus.depth) <= 1;
    }

    NodeStatus getTreeStatus(TreeNode node) {
        NodeStatus status = new NodeStatus();
        if (node == null) {
            status.isBalanced = true;
            status.depth = 0;
        } else {
            NodeStatus leftStatus = getTreeStatus(node.left);
            NodeStatus rightStatus = getTreeStatus(node.right);
            status.depth = Math.max(leftStatus.depth, rightStatus.depth) + 1;
            status.isBalanced = leftStatus.isBalanced && rightStatus.isBalanced && Math.abs(leftStatus.depth - rightStatus.depth) <= 1;
        }
        return status;
    }

}
