import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 方法一：递归。
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;

        // 方法二：迭代。递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stk = new LinkedList<>();
//        while (root != null || !stk.isEmpty()) {
//            while (root != null) {
//                stk.push(root);
//                root = root.left;
//            }
//            root = stk.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        // 测试用例1：普通二叉树
//        //     1
//        //      \
//        //       2
//        //      /
//        //     3
//        TreeNode root1 = new TreeNode(1);
//        root1.right = new TreeNode(2);
//        root1.right.left = new TreeNode(3);
//        System.out.println("测试用例1 - 预期：[1,3,2]");
//        System.out.println("实际结果：" + solution.inorderTraversal(root1));
//        System.out.println();

//        // 测试用例2：空树
//        TreeNode root2 = null;
//        System.out.println("测试用例2 - 预期：[]");
//        System.out.println("实际结果：" + solution.inorderTraversal(root2));
//        System.out.println();
//
//        // 测试用例3：单节点树
//        TreeNode root3 = new TreeNode(1);
//        System.out.println("测试用例3 - 预期：[1]");
//        System.out.println("实际结果：" + solution.inorderTraversal(root3));
//        System.out.println();
//
        // 测试用例4：完全二叉树
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        System.out.println("测试用例4 - 预期：[4,2,5,1,6,3,7]");
        System.out.println("实际结果：" + solution.inorderTraversal(root4));
        System.out.println();
//
//        // 测试用例5：左斜树
//        //     1
//        //    /
//        //   2
//        //  /
//        // 3
//        TreeNode root5 = new TreeNode(1);
//        root5.left = new TreeNode(2);
//        root5.left.left = new TreeNode(3);
//        System.out.println("测试用例5 - 预期：[3,2,1]");
//        System.out.println("实际结果：" + solution.inorderTraversal(root5));
//        System.out.println();
//
//        // 测试用例6：右斜树
//        // 1
//        //  \
//        //   2
//        //    \
//        //     3
//        TreeNode root6 = new TreeNode(1);
//        root6.right = new TreeNode(2);
//        root6.right.right = new TreeNode(3);
//        System.out.println("测试用例6 - 预期：[1,2,3]");
//        System.out.println("实际结果：" + solution.inorderTraversal(root6));
    }
}
