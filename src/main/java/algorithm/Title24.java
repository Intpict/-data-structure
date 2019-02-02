package algorithm;

/**
 * User: linsen
 * Date: 18/4/26
 * Time: 下午9:12
 * Description:
 */

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则输出false。假设输入的数组的任意两个数字都互不相同
 */
public class Title24 {

    /**
     * 思路：后续遍历，最后一个值为根节点，左子树所有值都比根节点小，右子树所有值都比根节点大
     * 找打第一个比根节点大的节点，认为它之后全为右子树，必须满足后面的值都比根节点的值大
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int length = sequence.length;
        // 说明为空数组
        if (length == 1)
            return true;
        // 获取根节点的值
        int rootVal = sequence[length - 1];
        // 获取左子树的所有值
        int i;
        for (i = 0; i < length - 1; i++) {
            if (sequence[i] > rootVal)
                break;
        }
        // 验证右子树是否满足全部大于根节点
        for (int j = i; j < length - 1; j++) {
            if (sequence[j] < rootVal)
                return false;
        }
        // 左右子树的长度
        int leftLen = i, rightLen = length - 1 - i;
        // 拷贝并且递归校验
        int[] left = new int[leftLen], right = new int[rightLen];
        System.arraycopy(sequence, 0, left, 0, leftLen);
        System.arraycopy(sequence, i, right, 0, rightLen);

        if (leftLen == 0 && rightLen == 0)
            return true;
        else if (leftLen == 0)
            return VerifySquenceOfBST(right);
        else if (rightLen == 0)
            return VerifySquenceOfBST(left);
        else
            return VerifySquenceOfBST(left) && VerifySquenceOfBST(right);
    }

    public static void main(String[] args) {
        new Title24().VerifySquenceOfBST(new int[]{7,4,6,5});
    }

}
