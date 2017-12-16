/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 *  5
    / \
    3   6
    /\
    2 4
 */
public class SolutionKthSmallestElementTree {
    int count = 0; int result;
    public int kthsmallest(TreeNode root, int k) {
        inOrder(root,k);
        return result;
    }
    
    public void inOrder(TreeNode node, int k) {
        if (node == null) return;
        
        inOrder(node.left, k);
        count++;
        
        if (count == k) {
            result = node.val;
            return;
        }
        
        inOrder(node.right,k);
    }
}
