import org.junit.Test;

import java.util.*;


public class LC103_二叉树的锯齿形层序遍历 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(zigzagLevelOrder1(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
//        true是正向，false是方向
        boolean flag = false;
        if(root == null) {
            return res;
        }
        queue.add(root);
//        层次遍历
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            if(flag) {
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    if(node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if(node.left != null) {
                        queue.addFirst(node.left);
                    }
                    temp.add(node.val);
                }
                flag = false;
            } else {
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    if(node.left != null) {
                        queue.addLast(node.left);
                    }
                    if(node.right != null) {
                        queue.addLast(node.right);
                    }
                    temp.add(node.val);
                }
                flag = true;
            }
            res.add(temp);
        }

        return res;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while(!queue.isEmpty()) {
            Deque<Integer> temp = new LinkedList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(flag) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add((new LinkedList<Integer>(temp)));
        }
        return res;
    }
}
