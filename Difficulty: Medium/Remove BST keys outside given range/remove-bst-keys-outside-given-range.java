class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
        if(root == null) {
            return null;
        }
        
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);
        
        if(root.data >= l && root.data <= r) {
            return root;
        }
        
        if(root.left != null) {
            return root.left;
        } else {
            return root.right;
        }
    }
}