/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Serialize (Preorder)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    int i = 0;

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        int[] arr = Arrays.stream(data.split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        return build(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode build(int[] arr, int min, int max) {
        if (i == arr.length || arr[i] < min || arr[i] > max) return null;

        TreeNode root = new TreeNode(arr[i++]);
        root.left = build(arr, min, root.val);
        root.right = build(arr, root.val, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;