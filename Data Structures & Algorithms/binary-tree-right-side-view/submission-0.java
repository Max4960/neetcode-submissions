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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            List<Integer> res = new ArrayList<>();
            return res;
        }

        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int qLen = q.size();
            levelOrder.add(new ArrayList<>());
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                levelOrder.get(level).add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            level++;
        }

        for (List<Integer> levels : levelOrder) {
            result.add(levels.get(levels.size()-1));
        }
        return result;

    }
}
