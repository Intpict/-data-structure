package algorithm;

/**
 * User: linsen
 * Date: 18/4/27
 * Time: 下午4:05
 * Description:
 */

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Title25 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> stack = new ArrayList<Integer>();
        if (root == null)
            return ans;
        findpathWithStatus(root, target, ans, stack);
        return ans;
    }

    /**
     * 具体处理方法
     *
     * @param node
     * @param target
     * @param ans
     * @param stack
     */
    public void findpathWithStatus(TreeNode node, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> stack) {
        // 入栈操作
        stack.add(node.val);
        // 值相等且当前节点为叶子节点
        if (target == node.val && node.left == null && node.right == null)
            ans.add((ArrayList<Integer>) stack.clone());
        if (node.left != null)
            findpathWithStatus(node.left, target - node.val, ans, stack);
        if (node.right != null)
            findpathWithStatus(node.right, target - node.val, ans, stack);
        // 出栈操作，删除最后一个元素
        stack.remove(stack.size() - 1);
    }

}
