class Solution {
    ArrayList<Integer>res=new ArrayList<>();
    public void preOrder(Node root)
    {
        if(root==null)
        return;
        if(root.left==null && root.right==null)
        res.add(root.key);
        preOrder(root.left);
        preOrder(root.right);
        
    }
    public ArrayList<Integer> leafNodes(int[] preorder) {
         Node root=new Node(preorder[0]);
         for(int i=1;i<preorder.length;i++)
         {
             root=insert(root,preorder[i]);
         }
         preOrder(root);
         return res;
    }
    public Node insert(Node root,int key)
    {
        if (root == null)
            return new Node(key);
        if (root.key == key)
            return root;
        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
}
class Node
{
    int key;
    Node left,right;
    Node(int key)
    {
        this.key=key;
        left=right=null;
    }
}