/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionPreOrderTraversal {
    // preOrder root, left, right
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> preOrderList = new ArrayList<>();
	    if (a == null) return preOrderList;
	    
	    // No Recursion use stack
	    Stack<TreeNode> st = new Stack<>();
	    st.add(a);
	    
	    while (!st.isEmpty()) {
	        TreeNode root = st.pop();
	        if (root != null) {
	            preOrderList.add(root.val);
	        }
	        
	        if (root.right != null) {
	            st.add(root.right);
	        }
	        
	        if (root.left != null) {
	            st.add(root.left);
	        }
	    }
	    
	    return preOrderList;
	}
}
