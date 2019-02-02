package algorithm;

/**
 * User: linsen
 * Date: 18/4/25
 * Time: 下午2:51
 * Description:
 */

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Title18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：相当于遍历root1，找不到就分别转到左右节点
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean result = false;
        result = doesTree1HaveTree2(root1, root2);
        if (!result)
            result = hasSubtree(root1.left, root2);
        if (!result)
            result = hasSubtree(root1.right, root2);
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        // 必须先判断root2，root2为null时允许root1为null，但是root2不为null时root1为null必定不行
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val)
            return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
        return false;
    }

}
