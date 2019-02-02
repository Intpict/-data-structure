package algorithm;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午6:40
 * Description:
 */

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Title6 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null)
            return null;
        assert(pre.length == in.length);
        int size = pre.length;
        TreeNode root = new TreeNode(pre[0]);
        // 左子树长
        int leftLength = 0;
        for (int i = 0; i < size; i++) {
            if (pre[0] == in[i])
                break;
            leftLength++;
        }
        // 右子树长
        int rightLength = size - leftLength - 1;
        // 生成左子树
        if (leftLength > 0) {
            int[] leftPre = new int[leftLength];
            int[] leftIn = new int[leftLength];
            System.arraycopy(pre, 1, leftPre, 0, leftLength);
            System.arraycopy(in, 0, leftIn, 0, leftLength);
            root.left = reConstructBinaryTree(leftPre, leftIn);
        }
        // 生成右子树
        if (rightLength > 0) {
            int[] rightPre = new int[rightLength];
            int[] rightIn = new int[rightLength];
            System.arraycopy(pre, size-rightLength, rightPre, 0, rightLength);
            System.arraycopy(in, size-rightLength, rightIn, 0, rightLength);
            root.right = reConstructBinaryTree(rightPre, rightIn);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {1,2,4,7,3,5,6,8};
        int[] in = new int[] {4,7,2,1,5,3,8,6};
        new Title6().reConstructBinaryTree(pre, in);
    }

}
