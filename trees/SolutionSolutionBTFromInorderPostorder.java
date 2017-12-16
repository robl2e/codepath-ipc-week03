/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionBTFromInorderPostorder {
    int index;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    index = postorder.size()-1;
        return buildTreeUtil(inorder, postorder, 0, inorder.size()-1);
	}
	
	public TreeNode buildTreeUtil(ArrayList<Integer> inorder,
	    ArrayList<Integer> postorder,
	    int left, int right) {
	        
	    if (left > right) return null;
	    if (index < 0) return null;
	    
        int rootNum = postorder.get(index);
        index--;
        TreeNode node = new TreeNode(rootNum);
        
        // No children return node
        if (left == right) {
            return node;
        }

        int rootIndex = inorder.indexOf(rootNum); 
        node.right = buildTreeUtil(inorder, postorder, rootIndex+1, right);
        node.left = buildTreeUtil(inorder, postorder, left, rootIndex-1);
        return node;
	}
	
}
