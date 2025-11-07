package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 深度优先搜索
 * <p>
 * 前序遍历
 * 访问顺序为：根节点 -> 左子树 -> 右子树。
 * 中序遍历
 * 访问顺序为：左子树 -> 根节点 -> 右子树。
 * 后序遍历
 * 访问顺序为：左子树 -> 右子树 -> 根节点。
 */
public class BinaryTreeDFS {

    // 前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    // 后序遍历
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }


    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 使用队列来辅助实现层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("前序遍历结果: " + preorderTraversal(root));
        System.out.println("中序遍历结果: " + inorderTraversal(root));
        System.out.println("后序遍历结果: " + postorderTraversal(root));

        System.out.println("广度优先搜索（层序遍历）结果: " + levelOrderTraversal(root));
    }
}    