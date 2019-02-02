package algorithm;

import com.sun.jdi.Mirror;

import java.sql.Time;
import java.util.Date;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 上午9:45
 * Description:
 */

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Title19 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {

        if (root == null)
            return;

        Mirror(root.left);
        Mirror(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }

}
