/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode n = q.poll();

                if (leftToRight) level.addLast(n.val);
                else level.addFirst(n.val);

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}