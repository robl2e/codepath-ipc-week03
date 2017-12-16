/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionMaxDepthBinaryTree {
    int max = 0;
	public int maxDepth(TreeNode a) {
	    if (a == null) return 0;
	    
	    preOrderTraversal(a, 0);
	    return max;
	}
	
	// root, left, right
	public void preOrderTraversal(TreeNode a, int count) {
        if (a != null) {
            count++;
            preOrderTraversal(a.left, count);
	        preOrderTraversal(a.right, count);
	        
	        // At leaf
	        if (a.left == null && a.right == null) {
	           max = Math.max(count, max);
               count = 0;
	        }
        }
	}
}
